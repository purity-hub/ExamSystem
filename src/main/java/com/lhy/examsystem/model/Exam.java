package com.lhy.examsystem.model;


public class Exam {

  private long id;
  private String name;
  private java.sql.Timestamp createTime;
  private long singleTotal;
  private long multipleTotal;
  private long judgmentTotal;
  private long shortTotal;
  private java.sql.Timestamp endTime;
  private java.sql.Timestamp startTime;
  private String createBy;
  private long totalScore;
  private long singleScore;
  private long multipleScore;
  private long shortScore;
  private long judgmentScore;
  private String miaoshu;
  private String state;
  private int examTime;

  private String CourseName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public long getSingleTotal() {
    return singleTotal;
  }

  public void setSingleTotal(long singleTotal) {
    this.singleTotal = singleTotal;
  }


  public long getMultipleTotal() {
    return multipleTotal;
  }

  public void setMultipleTotal(long multipleTotal) {
    this.multipleTotal = multipleTotal;
  }


  public long getJudgmentTotal() {
    return judgmentTotal;
  }

  public void setJudgmentTotal(long judgmentTotal) {
    this.judgmentTotal = judgmentTotal;
  }


  public long getShortTotal() {
    return shortTotal;
  }

  public void setShortTotal(long shortTotal) {
    this.shortTotal = shortTotal;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }


  public long getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(long totalScore) {
    this.totalScore = totalScore;
  }


  public long getSingleScore() {
    return singleScore;
  }

  public void setSingleScore(long singleScore) {
    this.singleScore = singleScore;
  }


  public long getMultipleScore() {
    return multipleScore;
  }

  public void setMultipleScore(long multipleScore) {
    this.multipleScore = multipleScore;
  }


  public long getShortScore() {
    return shortScore;
  }

  public void setShortScore(long shortScore) {
    this.shortScore = shortScore;
  }


  public long getJudgmentScore() {
    return judgmentScore;
  }

  public void setJudgmentScore(long judgmentScore) {
    this.judgmentScore = judgmentScore;
  }


  public String getMiaoshu() {
    return miaoshu;
  }

  public void setMiaoshu(String miaoshu) {
    this.miaoshu = miaoshu;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public int getExamTime() {
    return examTime;
  }

  public void setExamTime(int examTime) {
    this.examTime = examTime;
  }

  public String getCourseName() {
    return CourseName;
  }

  public void setCourseName(String courseName) {
    CourseName = courseName;
  }

  @Override
  public String toString() {
    return id + //0
            "," + name + //1
            "," + createTime + //2
            "," + singleTotal + //3
            "," + multipleTotal + //4
            "," + judgmentTotal + //5
            "," + shortTotal + //6
            "," + endTime + //7
            "," + startTime + //8
            "," + createBy + //9
            "," + totalScore + //10
            "," + singleScore + //11
            "," + multipleScore + //12
            "," + shortScore + //13
            "," + judgmentScore + //14
            "," + miaoshu + //15
            "," + state + //16
            "," + examTime; //17
  }
}
