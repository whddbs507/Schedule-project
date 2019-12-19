package com.whddbs.sm;

import java.util.Scanner;
import java.sql.Date;

public class App3 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    class Board {
      int no;
      String index;
      Date today;
      int viewCount;
    }
    final int SIZE = 100;
    int count = 1;
    Board[] noticeBoard = new Board[SIZE];
    
    for(int i = 0; i < count; i++) {
      Board iboard = new Board();
      noticeBoard[i] = iboard;
      
      iboard.no = count;
      System.out.print("내용:  ");
      iboard.index = keyScan.nextLine();
      iboard.today = new Date(System.currentTimeMillis());
      System.out.println("계속 입력하시겠습니까? (Y/n)");
      String response = keyScan.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
      count++;
    }
    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s, %d\n", noticeBoard[i].no, noticeBoard[i].index, noticeBoard[i].today, noticeBoard[i].viewCount );
    }
  }
}