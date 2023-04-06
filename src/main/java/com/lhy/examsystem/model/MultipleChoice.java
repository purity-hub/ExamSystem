package com.lhy.examsystem.model;


public class MultipleChoice {

  private long id;
  private long examId;
  private String question;
  private String aChoice;
  private String bChoice;
  private String cChoice;
  private String dChoice;
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


  public String getAChoice() {
    return aChoice;
  }

  public void setAChoice(String aChoice) {
    this.aChoice = aChoice;
  }


  public String getBChoice() {
    return bChoice;
  }

  public void setBChoice(String bChoice) {
    this.bChoice = bChoice;
  }


  public String getCChoice() {
    return cChoice;
  }

  public void setCChoice(String cChoice) {
    this.cChoice = cChoice;
  }


  public String getDChoice() {
    return dChoice;
  }

  public void setDChoice(String dChoice) {
    this.dChoice = dChoice;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public String toString() {
    return id + "," + examId + "," + question + "," + aChoice + "," + bChoice + "," + cChoice + "," + dChoice + "," + answer;
  }
}
