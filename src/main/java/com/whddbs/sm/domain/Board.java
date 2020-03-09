package com.whddbs.sm.domain;

public class Board {
  private static int no;
  private String registeredDay;
  private String title;
  private String contents;
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public int getNo() {
    return no;
  }
  
  public void setRegisterDay(String Day) {
    this.registeredDay = Day;
  }
  
  public String getRegisteredDay() {
    return this.registeredDay;
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