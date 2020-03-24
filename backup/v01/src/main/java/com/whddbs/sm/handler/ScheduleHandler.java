package com.whddbs.sm.handler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import com.whddbs.sm.domain.Schedule;
import com.whddbs.sm.util.Iterator;
import com.whddbs.sm.util.List;

public class ScheduleHandler {
  static Scanner keyboard = new Scanner(System.in);
  List<Schedule> list;
  Iterator<Schedule> iterator;
  
  Scanner scanner;
  static int scheduleCount = 0;

  public ScheduleHandler(Scanner scanner, List<Schedule> list) {
    this.scanner = scanner;
    this.list = list;
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

    this.list.add(schedule);
  }

  public void listSchedule() {
    Schedule[] schedules = new Schedule[this.list.size()];

    schedules = this.list.toArray(schedules);
    iterator = list.iterator();
    while (iterator.hasnext()) {
      Schedule s = iterator.next();
      System.out.printf("%d %s %s %s\n", s.getNo(),
          s.getTitle(), s.getContents(), s.getSelectDay());
    }
  }

  public void detailSchedule() {
    System.out.print("확인할 번호 : ");
    int scheduleNo = keyboard.nextInt();
    keyboard.nextLine();

    Schedule schedule = this.list.get(scheduleNo);

    System.out.printf("번호 : %d\n", scheduleNo);
    System.out.printf("제목 : %s\n", schedule.getTitle());
    System.out.printf("내용 : %s\n", schedule.getContents());
    System.out.printf("등록일 : %s\n", schedule.getSelectDay());
  }

  public void updateSchedule() {
    System.out.print("변경할 번호 선택 : ");
    int updateNum = keyboard.nextInt();
    keyboard.nextLine();

    Schedule schedule = this.list.set(updateNum);

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

  }

  public void deleteSchedule() {
    System.out.print("삭제할 번호 선택 : ");
    int deleteNum = keyboard.nextInt();
    keyboard.nextLine();

    int index = indexOfSchedule(deleteNum);
    
    if (index == -1) {
      System.out.println("존재하지 않는 넘버입니다.");
    }
    
    this.list.remove(index);
  }

  private int indexOfSchedule(int no) {
    for (int i = 0; i <= this.list.size(); i++) {
      if (this.list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
