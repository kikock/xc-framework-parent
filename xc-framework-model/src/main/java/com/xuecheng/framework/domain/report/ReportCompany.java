package com.xuecheng.framework.domain.report;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by admin on 2018/2/27.
 */
@Document(collection = "report_company")
public class ReportCompany {

    @Id
    private String id;
    private Float evaluation_score;//评价分数（平均分）
    private Float good_scale;//好评率
    private Long course_num;//课程数
    private Long student_num;//学生人数
    private Long play_num;//播放次数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getEvaluation_score() {
        return evaluation_score;
    }

    public void setEvaluation_score(Float evaluation_score) {
        this.evaluation_score = evaluation_score;
    }

    public Float getGood_scale() {
        return good_scale;
    }

    public void setGood_scale(Float good_scale) {
        this.good_scale = good_scale;
    }

    public Long getCourse_num() {
        return course_num;
    }

    public void setCourse_num(Long course_num) {
        this.course_num = course_num;
    }

    public Long getStudent_num() {
        return student_num;
    }

    public void setStudent_num(Long student_num) {
        this.student_num = student_num;
    }

    public Long getPlay_num() {
        return play_num;
    }

    public void setPlay_num(Long play_num) {
        this.play_num = play_num;
    }

    @Override
    public String toString() {
        return "ReportCompany{" +
                "id='" + id + '\'' +
                ", evaluation_score=" + evaluation_score +
                ", good_scale=" + good_scale +
                ", course_num=" + course_num +
                ", student_num=" + student_num +
                ", play_num=" + play_num +
                '}';
    }
}
