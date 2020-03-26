package com.whddbs.sm.domain;

public class Board {
  private int no;
  private String registeredDay;
  private String title;
  private String contents;
  
  public String toCsvString() {
    return String.format("%d,%s,%s\n", getNo(), getTitle()
        , getContents());
  }
  
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
    return registeredDay;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setContents(String contents) {
    this.contents = contents;
  }
  
  public String getContents() {
    return contents;
  }
}