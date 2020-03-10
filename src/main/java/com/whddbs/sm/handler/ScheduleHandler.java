package com.whddbs.sm.handler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import com.whddbs.sm.domain.Schedule;
import com.whddbs.sm.util.ArrayList;

public class ScheduleHandler {
  static Scanner keyboard = new Scanner(System.in);
  ArrayList<Schedule> scheduleList;
  
  Scanner scanner;
  static int scheduleCount = 0;
  
  public ScheduleHandler(Scanner scanner) {
    this.scanner = scanner;
    this.scheduleList = new ArrayList<>();
  }

  public ScheduleHandler(Scanner scanner, int capacity) {
    this.scanner = scanner;
    this.scheduleList = new ArrayList<>(capacity);
  }
  
  public void addSchedule() {
    Schedule schedule = new Schedule();
    schedule.setNo(++scheduleCount);
    
    System.out.printf("번호 : %d\n", schedule.getNo());
    
    Calendar calendar = new GregorianCalendar(Locale.KOREA);
    int nYear = calendar.get(Calendar.YEAR);
    int nMonth = calendar.get(Calendar.MONTH) + 1;
    int nDay = calendar.get(Calendar.DAY_OF_MONTH);
    schedule.setSelectDay(nYear + "-" + nMonth + "-" + nDay); 
    System.out.println(schedule.getSelectDay());
    System.out.print("제목 : ");
    schedule.setTitle(keyboard.nextLine());
    
    System.out.print("내용 : ");
    schedule.setContents(keyboard.nextLine());
    
    this.scheduleList.add(schedule);
  }

  public void listSchedule() {
    System.out.print("확인할 번호 : ");
    int listNo = keyboard.nextInt();
    keyboard.nextLine();
    
    Schedule schedule = this.scheduleList.get(listNo);
    
    System.out.printf("번호 : %d\n", listNo);
    System.out.printf("제목 : %s\n", schedule.getTitle());
    System.out.printf("내용 : %s\n", schedule.getContents());
    System.out.printf("등록일 : %s\n", schedule.getSelectDay());
  }
}
