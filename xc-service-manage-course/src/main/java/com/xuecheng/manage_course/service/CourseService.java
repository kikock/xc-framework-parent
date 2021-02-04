package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.dao.CourseBaseRepository;
import com.xuecheng.manage_course.dao.TeachplanMapper;
import com.xuecheng.manage_course.dao.TeachplanRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 *
 * @project_name: xc-service-manage-course
 * @description:  课程管理服务层
 * @create_name:  kikock
 * @create_date:  2021/2/2 16:13
 *
 **/
@Service
public class CourseService {
    @Autowired
    TeachplanMapper teachplanMapper;

    @Autowired
    TeachplanRepository teachplanRepository;

    @Autowired
    CourseBaseRepository courseBaseRepository;

    /**
     * @description: 查询课程计划树形结构
     * @param: 课程id
     * @return: 树形课程计划
     * @create_name: kikock
     * @create_date: 2021/2/4 9:44
     **/
    public List<Teachplan> findTeachplanList(String courseId) {
        List<Teachplan> teachplanList = teachplanRepository.findByCourseid(courseId);
        return teachplanFormatter(teachplanList);
    }

    /**
     * @description: 树形转换
     * @param: 所有课程list
     * @return: 转换后树形结构
     * @create_name: kikock
     * @create_date: 2021/2/4 9:59
     **/
    private List<Teachplan> teachplanFormatter(List<Teachplan> teachplanList) {
        //返回数据
        List<Teachplan> result = new ArrayList<>();
        Map<String, Teachplan> cache = new HashMap<>();
        //课程id 放进cache
        for (Teachplan teachplan : teachplanList) {
            //遍历所有的菜单放进map缓存 <id object>
            cache.put(teachplan.getId(), teachplan);
        }
        for (Teachplan teachplan : teachplanList) {
            //判断1级菜单
            if ("0".equals(teachplan.getParentid())) {
                //一级菜单
                result.add(teachplan);
            } else {
                String pid = teachplan.getParentid();
                Teachplan parent = cache.get(pid);
                if (parent != null) {
                    List<Teachplan> children = parent.getChildren();
                    if (children == null) {
                        children = new ArrayList<>();
                        parent.setChildren(children);
                    }
                    children.add(teachplan);
                }
            }
        }
        return result;
    }


    @Transactional
    public ResponseResult addTeachplan(Teachplan teachplan) {

        if (teachplan == null ||
                StringUtils.isEmpty(teachplan.getPname()) ||
                StringUtils.isEmpty(teachplan.getCourseid())) {
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        //课程id
        String courseid = teachplan.getCourseid();
        //父结点的id
        String parentid = teachplan.getParentid();
        if(StringUtils.isEmpty(parentid)){
            //获取课程的根结点
            parentid = getTeachplanRoot(courseid);
        }
        //查询根结点信息
        Optional<Teachplan> optional = teachplanRepository.findById(parentid);
        Teachplan teachplan1 = optional.get();
        //父结点的级别
        String parent_grade = teachplan1.getGrade();
        //创建一个新结点准备添加
        Teachplan teachplanNew = new Teachplan();
        //将teachplan的属性拷贝到teachplanNew中
        BeanUtils.copyProperties(teachplan,teachplanNew);
        //要设置必要的属性
        teachplanNew.setParentid(parentid);
        if(parent_grade.equals("1")){
            teachplanNew.setGrade("2");
        }else{
            teachplanNew.setGrade("3");
        }
        teachplanNew.setStatus("0");//未发布
        teachplanRepository.save(teachplanNew);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    //获取课程的根结点
    public String getTeachplanRoot(String courseId){
        Optional<CourseBase> optional = courseBaseRepository.findById(courseId);
        if(!optional.isPresent()){
            return null;
        }
        CourseBase courseBase = optional.get();
        //调用dao查询teachplan表得到该课程的根结点（一级结点）
        List<Teachplan> teachplanList = teachplanRepository.findByCourseidAndParentid(courseId, "0");
        if(teachplanList == null || teachplanList.size()<=0){
            //新添加一个课程的根结点
            Teachplan teachplan = new Teachplan();
            teachplan.setCourseid(courseId);
            teachplan.setParentid("0");
            teachplan.setGrade("1");//一级结点
            teachplan.setStatus("0");
            teachplan.setPname(courseBase.getName());
            teachplanRepository.save(teachplan);
            return teachplan.getId();

        }
        //返回根结点的id
        return teachplanList.get(0).getId();

    }
}
