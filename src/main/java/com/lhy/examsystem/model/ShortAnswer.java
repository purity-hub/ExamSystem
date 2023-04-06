package com.lhy.examsystem.model;


public class ShortAnswer {

  private long id;
  private long examId;
  private String question;
  private String answer;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getExamId() {
    return examId;
  }

  public void setExamId(long examId) {
    this.examId = examId;
  }


  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public String toString() {
    return id + "," + examId + "," + question + "," + answer;
  }
}
