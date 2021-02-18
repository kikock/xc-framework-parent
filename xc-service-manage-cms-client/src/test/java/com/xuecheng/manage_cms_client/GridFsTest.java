package com.xuecheng.manage_cms_client;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

/**
 * @project_name: xc-framework-parent
 * @description: mongdb 存储文件测试
 * @create_name: kikock
 * @create_date: 2021-01-19 13:40
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class GridFsTest {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Resource
    private GridFSBucket gridFSBucket;


    // 文件保存
    @Test
    public void GridFsSave() throws FileNotFoundException {
        //要存储的文件
        File file = new File("d:/index_banner.ftl");
        //定义输入流
        FileInputStream inputStram = new FileInputStream(file);
        //向GridFS存储文件
        ObjectId objectId = gridFsTemplate.store(inputStram, "轮播图静态文件", "");
        //得到文件ID
        String fileId = objectId.toString();
        System.out.println(fileId);
    }

    // 文件读取
    @Test
    public void queryFile() throws IOException {
        String fileId = "6017c7233422d704fc076c43";
        //根据文件id查询文件
        GridFSFile gridFSFile =
                gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));

        if (Objects.nonNull(gridFSFile)) {
            //打开下载流对象
            GridFSDownloadStream gridFSDownloadStream =
                    gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
            //创建gridFsResource，用于获取流对象
            GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
            //获取流中的数据
            String s = IOUtils.toString(gridFsResource.getInputStream());
            System.out.println(s);
        } else {
            System.out.println("文件id不存在");
        }
    }

    // 文件删除
    //删除文件
    @Test
    public void testDelFile() throws IOException {
        //根据文件id删除fs.files和fs.chunks中的记录
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is("6006793358e4a408843d58681")));
    }

}
