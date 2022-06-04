package com.lhy.examsystem.model;


public class ExamCourse1 {

    private long id;
    private int examId;//数据库
    private int courseId;//数据库


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
