package com.whddbs.sm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.whddbs.sm.domain.Board;
import com.whddbs.sm.domain.Member;
import com.whddbs.sm.domain.Schedule;
import com.whddbs.sm.handler.BoardHandler;
import com.whddbs.sm.handler.MemberHandler;
import com.whddbs.sm.handler.ScheduleHandler;

public class App {
  static Scanner keyboard = new Scanner(System.in);
  static Deque<String> stack = new ArrayDeque();
  static Queue<String> queue = new LinkedList();

  public static void main(String[] args) throws CloneNotSupportedException{

    ArrayList<Member> memberList = new ArrayList<>();
    MemberHandler memberHandler = new MemberHandler(keyboard, memberList);
    
    LinkedList<Board> boardList = new LinkedList<>();
    BoardHandler boardHandler = new BoardHandler(keyboard, boardList);
    
    LinkedList<Schedule> scheduleList = new LinkedList<>();
    ScheduleHandler scheduleHandler = new ScheduleHandler(keyboard, scheduleList);

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
        case "/schedule/delete":
          scheduleHandler.deleteSchedule();
          break;
        case "history":
          printCommandHistory(stack.iterator());
          break;
        case "history2":
          printCommandHistory(queue.iterator());
          break;
      }

      if (command.equalsIgnoreCase("quit")) {
        break;
      }
    }

  }

  public static void printCommandHistory(Iterator iterator) throws CloneNotSupportedException {
    while (iterator.hasNext()) {
      System.out.printf("%s\n", iterator.next());
    }
  }
}