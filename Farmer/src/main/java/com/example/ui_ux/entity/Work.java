package com.example.ui_ux.entity;

public class Work {

  private int id;

  private String work;

  private String timeStart;

  private String timeFinish;

  private String workplace;

  private String description;

  public Work(int id, String work, String timeStart, String timeFinish, String workplace, String description) {
    this.id = id;
    this.work = work;
    this.timeStart = timeStart;
    this.timeFinish = timeFinish;
    this.workplace = workplace;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getWork() {
    return work;
  }

  public void setWork(String work) {
    this.work = work;
  }

  public String getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(String timeStart) {
    this.timeStart = timeStart;
  }

  public String getTimeFinish() {
    return timeFinish;
  }

  public void setTimeFinish(String timeFinish) {
    this.timeFinish = timeFinish;
  }

  public String getWorkplace() {
    return workplace;
  }

  public void setWorkplace(String workplace) {
    this.workplace = workplace;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
