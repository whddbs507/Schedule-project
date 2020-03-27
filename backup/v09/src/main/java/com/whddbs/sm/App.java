package com.whddbs.sm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import com.whddbs.sm.context.ApplicationContextListener;
import com.whddbs.sm.domain.Board;
import com.whddbs.sm.domain.Member;
import com.whddbs.sm.util.BoardAddCommand;
import com.whddbs.sm.util.BoardDeleteCommand;
import com.whddbs.sm.util.BoardDetailCommand;
import com.whddbs.sm.util.BoardListCommand;
import com.whddbs.sm.util.Command;
import com.whddbs.sm.util.MemberAddCommand;
import com.whddbs.sm.util.MemberDeleteCommand;
import com.whddbs.sm.util.MemberDetailCommand;
import com.whddbs.sm.util.MemberListCommand;

public class App {

  Scanner keyboard = new Scanner(System.in);
  Deque<String> stack = new ArrayDeque();
  Queue<String> queue = new LinkedList();

  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new ArrayList<>();
  
  Map<String, Object> context = new HashMap<>();
  
  Set<ApplicationContextListener> listeners = new HashSet<>();
  
  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }
  
  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }
  
  public void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }
  
  public void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed();
    }
  }
  
  public void service() {
    
    notifyApplicationInitialized();
    
    HashMap<String, Command> commandMap = new HashMap<>();
    
    boardList = (List<Board>) context.get("boardList");
    memberList = (List<Member>) context.get("memberList");
    
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));

    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));

    while (true) {
      System.out.print("명령어 : ");
      String command = keyboard.nextLine();
      stack.push(command);
      queue.offer(command);

      if (command.equalsIgnoreCase("quit")) {
        break;
      } else if (command.equals("history")) {
        printCommandHistory(stack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(queue.iterator());
        continue;
      }

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch(Exception e) {
          System.out.printf("명령어 중 오류 발생 : %s\n", e.getMessage());
        }
      } else {
        System.out.println("잘못된 명령어입니당 ^^");
      }
      
    }
    notifyApplicationDestroyed();
  }
  
  public static void main(String[] args) {
    App app = new App();
    
    app.addApplicationContextListener(new DataLoaderListener());
    app.addApplicationContextListener(new GreetingListener());
    
    app.service();
  }

  private static void printCommandHistory(Iterator<String> iterator) {
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

}