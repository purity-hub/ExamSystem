package com.lhy.examsystem.model;


public class Course {

  private long id;
  private String name;
  private long teacherId;
  private String type;
  private long credit;
  private long time;


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


  public long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(long teacherId) {
    this.teacherId = teacherId;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public long getCredit() {
    return credit;
  }

  public void setCredit(long credit) {
    this.credit = credit;
  }


  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return  id+ "," +name+ "," +teacherId+ "," +type+ "," +credit+ "," +time;
  }
}
