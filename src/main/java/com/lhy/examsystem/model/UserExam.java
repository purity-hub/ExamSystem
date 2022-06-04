package com.lhy.examsystem.model;


public class UserExam {

  private long id;
  private long userId;
  private long examId;
  private long mark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getExamId() {
    return examId;
  }

  public void setExamId(long examId) {
    this.examId = examId;
  }


  public long getMark() {
    return mark;
  }

  public void setMark(long mark) {
    this.mark = mark;
  }

}
