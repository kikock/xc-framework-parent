package com.xuecheng.framework.domain.report;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by admin on 2018/2/27.
 */
@Document(collection = "report_course")
public class ReportCourse {

    @Id
    private String id;
    private Float evaluation_score;//评价分数
    private Long collect_num;//收藏次数
    private Long play_num;//播放次数
    private Long student_num;//学生人数
    private Long timelength;//课程时长

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

    public Long getCollect_num() {
        return collect_num;
    }

    public void setCollect_num(Long collect_num) {
        this.collect_num = collect_num;
    }

    public Long getPlay_num() {
        return play_num;
    }

    public void setPlay_num(Long play_num) {
        this.play_num = play_num;
    }

    public Long getStudent_num() {
        return student_num;
    }

    public void setStudent_num(Long student_num) {
        this.student_num = student_num;
    }

    public Long getTimelength() {
        return timelength;
    }

    public void setTimelength(Long timelength) {
        this.timelength = timelength;
    }

    @Override
    public String toString() {
        return "ReportCourse{" +
                "id='" + id + '\'' +
                ", evaluation_score=" + evaluation_score +
                ", collect_num=" + collect_num +
                ", play_num=" + play_num +
                ", student_num=" + student_num +
                ", timelength=" + timelength +
                '}';
    }
}
