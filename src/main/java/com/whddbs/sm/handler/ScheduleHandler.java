package com.whddbs.sm.handler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import com.whddbs.sm.domain.Schedule;

public class ScheduleHandler {
  static Scanner keyboard = new Scanner(System.in);
  static Schedule[] schedules = new Schedule[100]; 
  
  public static void addSchedule() {
    Schedule schedule = new Schedule();
    ++schedule.no;
    
    System.out.printf("번호 : %d\n", schedule.no);
    
    Calendar calendar = new GregorianCalendar(Locale.KOREA);
    int nYear = calendar.get(Calendar.YEAR);
    int nMonth = calendar.get(Calendar.MONTH) + 1;
    int nDay = calendar.get(Calendar.DAY_OF_MONTH);
    schedule.selectDay = nYear + "-" + nMonth + "-" + nDay;
    System.out.println(schedule.selectDay);
    System.out.print("제목 : ");
    schedule.title = keyboard.nextLine();
    
    System.out.print("내용 : ");
    schedule.contents = keyboard.nextLine();
    
    schedules[schedule.no - 1] = schedule;
  }

  public static void listSchedule() {
    System.out.print("확인할 번호 : ");
    int listNo = keyboard.nextInt();
    keyboard.nextLine();
    Schedule schedule = schedules[listNo - 1];
    System.out.printf("번호 : %d\n", listNo);
    System.out.printf("제목 : %s\n", schedule.title);
    System.out.printf("내용 : %s\n", schedule.contents);
    System.out.printf("등록일 : %s\n", schedule.selectDay);
  }
}
