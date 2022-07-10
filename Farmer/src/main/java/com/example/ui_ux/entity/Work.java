package com.example.ui_ux.entity;

public class Work {

  private String work;

  private String timeStart;

  private String timeFinish;

  private String workplace;

  private String description;

  public Work(String work, String timeStart, String timeFinish, String workplace, String description) {
    this.work = work;
    this.timeStart = timeStart;
    this.timeFinish = timeFinish;
    this.workplace = workplace;
    this.description = description;
  }

  public String getWork()
  {
    return work;
  }

  public String getTimeStart()
  {
    return timeStart;
  }

  public String getTimeFinish()
  {
    return timeFinish;
  }

  public String getWorkplace()
  {
    return workplace;
  }

  public String getDescription()
  {
    return description;
  }

  @Override
  public String toString()
  {
    return "Work{" +
      "work='" + work + '\'' +
      ", timeStart='" + timeStart + '\'' +
      ", timeFinish='" + timeFinish + '\'' +
      ", workplace='" + workplace + '\'' +
      ", description='" + description + '\'' +
      '}';
  }
}
