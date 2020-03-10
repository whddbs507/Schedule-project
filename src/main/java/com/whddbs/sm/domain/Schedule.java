package com.whddbs.sm.domain;

public class Schedule {
  private static int no;
  private String selectDay;
  private String title;
  private String contents;
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public int getNo() {
    return this.no;
  }
  
  public void setSelectDay(String selectDay) {
    this.selectDay = selectDay;
  }
  
  public String getSelectDay() {
    return this.selectDay;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setContents(String contents) {
    this.contents = contents;
  }
  
  public String getContents() {
    return this.contents;
  }
}
