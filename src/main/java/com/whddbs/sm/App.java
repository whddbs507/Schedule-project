/* 15번 게터세터 수정*/
package com.whddbs.sm;

import java.util.Scanner;
import com.whddbs.sm.handler.BoardHandler;
import com.whddbs.sm.handler.MemberHandler;
import com.whddbs.sm.handler.ScheduleHandler;

public class App {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    MemberHandler memberHandler = new MemberHandler();
    BoardHandler boardHandler = new BoardHandler(keyboard);
    BoardHandler boardHandler2 = new BoardHandler(keyboard, 10);
    BoardHandler boardHandler3 = new BoardHandler(keyboard, 500);
    BoardHandler boardHandler4 = new BoardHandler(keyboard);
    ScheduleHandler scheduleHandler = new ScheduleHandler();
    
    while (true) {
      System.out.print("명령어 > ");
      String command = keyboard.nextLine();
      
      switch(command) {
        case "/member/add":
          memberHandler.addMember();
          break;
        case "/member/list":
          memberHandler.listMember();
          break;
        case "/board/add":
          boardHandler.addBoard();
          break;
        case "/board/list":
          boardHandler.listBoard();
          break;
        case "/board2/add":
          boardHandler2.addBoard();
          break;
        case "/board2/list":
          boardHandler2.listBoard();
          break;
        case "/board3/add":
          boardHandler3.addBoard();
          break;
        case "/board3/list":
          boardHandler3.listBoard();
          break;
        case "/board4/add":
          boardHandler4.addBoard();
          break;
        case "/board4/list":
          boardHandler4.listBoard();
          break;
        case "/schedule/add":
          scheduleHandler.addSchedule();
          break;
        case "/schedule/list":
          scheduleHandler.listSchedule();
          break;
      }
      
      if (command.equalsIgnoreCase("quit")) {
        break;
      }
    }
    
  }
}