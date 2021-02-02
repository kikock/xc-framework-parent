package com.xuecheng.framework.domain.course;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by admin on 2018/2/10.
 */

@Entity
@Table(name = "course_pic")
@GenericGenerator(name = "jpa-assigned", strategy = "assigned")
public class CoursePic implements Serializable {
    private static final long serialVersionUID = -916357110051689486L;

    @Id
    @GeneratedValue(generator = "jpa-assigned")
    private String courseid;
    private String pic;

    @Override
    public String toString() {
        return "CoursePic{" +
                "courseid='" + courseid + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
