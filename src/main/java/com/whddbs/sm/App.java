package com.whddbs.sm;

import java.util.Scanner;
import java.sql.Date;

public class App {
  public static void main(String[] args) {

    Scanner keyScan = new Scanner(System.in);

    class Contents {
      int no;
      String name;
      String description;
      Date startDay;
      Date endDay;
      int totalHour;
      int dayHour;      
    }
    final int SIZE = 100;
    Contents[] contentsArray = new Contents[SIZE];
    int count = 1;

    for (int i = 0; i < count; i++) {
      Contents aa = new Contents();
      contentsArray[i] = aa;
      aa.no = count;
      System.out.print("수업명 ?  ");
      aa.name = keyScan.nextLine();
      System.out.print("설명 ?  ");
      aa.description = keyScan.nextLine();
      System.out.print("시작일 ?  ");
      aa.startDay = Date.valueOf(keyScan.nextLine());
      System.out.print("종료일 ?  ");
      aa.endDay = Date.valueOf(keyScan.nextLine());
      System.out.print("총수업시간 ?  ");
      aa.totalHour = keyScan.nextInt();
      keyScan.nextLine();
      System.out.print("일수업시간 ?  ");
      aa.dayHour = keyScan.nextInt();
      keyScan.nextLine();
      System.out.println("계속 입력하시겠습니까? (Y/n)");
      String response = keyScan.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
      count++;
    }
    for (int i = 0; i < count; i++) {
      Contents bb = contentsArray[i];
      System.out.printf("%d, %s, %s, %s, %s, %d, %d\n", bb.no, bb.name, bb.description, bb.startDay, bb.endDay, bb.totalHour, bb.dayHour);  
    }
  }
}