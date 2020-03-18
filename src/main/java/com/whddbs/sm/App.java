package com.whddbs.sm;

import java.util.Scanner;
import com.whddbs.sm.handler.BoardHandler;
import com.whddbs.sm.handler.MemberHandler;
import com.whddbs.sm.handler.ScheduleHandler;
import com.whddbs.sm.util.Queue;
import com.whddbs.sm.util.Stack;

public class App {
  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> stack = new Stack();
  static Queue<String> queue = new Queue();
  
  public static void main(String[] args) {

    MemberHandler memberHandler = new MemberHandler(keyboard);
    BoardHandler boardHandler = new BoardHandler(keyboard, 100);
    ScheduleHandler scheduleHandler = new ScheduleHandler(keyboard);
    
    while (true) {
      System.out.print("명령어 > ");
      String command = keyboard.nextLine();

      stack.push(command);
      queue.offer(command);
      
      switch(command) {
        case "/member/add":
          memberHandler.addMember();
          break;
        case "/member/list":
          memberHandler.listMember();
          break;
        case "/member/detail":
          memberHandler.detailMember();
          break;
        case "/member/update":
          memberHandler.updateMember();
          break;
        case "/member/delete":
          memberHandler.deleteMember();
          break;
        case "/board/add":
          boardHandler.addBoard();
          break;
        case "/board/list":
          boardHandler.listBoard();
          break;
        case "/board/detail":
          boardHandler.detailBoard();
          break;
        case "/board/update":
          boardHandler.updateBoard();
          break;
        case "/board/delete":
          boardHandler.deleteBoard();
          break;
        case "/schedule/add":
          scheduleHandler.addSchedule();
          break;
        case "/schedule/list":
          scheduleHandler.listSchedule();
          break;
        case "/schedule/detail":
          scheduleHandler.detailSchedule();
          break;
        case "/schedule/update":
          scheduleHandler.updateSchedule();
          break;
        case "/schedule/delete":
          scheduleHandler.deleteSchedule();
          break;
        case "history":
          printCommandHistory();
          break;
        case "history2":
          printCommandHistory2();
          break;
      }

      if (command.equalsIgnoreCase("quit")) {
        break;
      }
    }

  }
  
  public static void printCommandHistory() {
    while (!stack.empty()) {
      System.out.printf("%s\n", stack.pop());
    }
  }
  
  public static void printCommandHistory2() {
    while (queue.size() > 0) {
      System.out.println(queue.poll());
    }
  }
}