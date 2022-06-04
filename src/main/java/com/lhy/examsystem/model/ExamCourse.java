package com.lhy.examsystem.model;


public class ExamCourse {

  private long id;
  private String examId;//展示
  private String courseId;//展示


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getExamId() {
    return examId;
  }

  public void setExamId(String examId) {
    this.examId = examId;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }
}
