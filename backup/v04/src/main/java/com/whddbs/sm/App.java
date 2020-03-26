package com.whddbs.sm;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
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

  static Scanner keyboard = new Scanner(System.in);
  static Deque<String> stack = new ArrayDeque();
  static Queue<String> queue = new LinkedList();

  static LinkedList<Board> boardList = new LinkedList<>();
  static LinkedList<Member> memberList = new LinkedList<>();

  public static void main(String[] args) {

    loadBoardData();
    loadMemberData();
    
    HashMap<String, Command> commandMap = new HashMap<>();

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

    saveBoardData();
    saveMemberData();
  }

  private static void printCommandHistory(Iterator<String> iterator) {
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static void loadBoardData() {
    File file = new File("./board.csv");
    FileReader in = null;
    Scanner dataScan = null;
    int count = 0;

    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);

      while (true) {
        String str = dataScan.nextLine();
        String[] strArray = str.split(",");

        Board board = new Board();
        board.setNo(Integer.parseInt(strArray[0]));
        board.setTitle(strArray[1]);
        board.setContents(strArray[2]);
        boardList.add(board);

        count++;
      }
    } catch (Exception e) {

    }
    System.out.printf("%d개의 board 데이터를 로드했습니다.\n", count);
  }

  private static void loadMemberData() {
    File file = new File("./member.csv");
    FileReader in = null;
    Scanner dataScan = null;
    int count = 0;
    
    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);
      
      while (true) {
        String str = dataScan.nextLine();
        String[] strArray = str.split(",");
        
        Member member = new Member();
        
        member.setNo(Integer.parseInt(strArray[0]));
        member.setName(strArray[1]);
        member.setEmail(strArray[2]);
        member.setPw(strArray[3]);
        
        memberList.add(member);
        
        count++;
        in.close();
      }
      
    } catch (Exception e) {
      
    }
    System.out.printf("%d개의 member 데이터를 로드했습니다.\n", count);
  }
  
  private static void saveBoardData() {
    File file = new File("./board.csv");
    FileWriter out = null;
    int count = 0;

    try {
      out = new FileWriter(file);

      for (Board board : boardList) {
        String line = String.format("%d,%s,%s\n", board.getNo(), board.getTitle(), board.getContents());
        out.write(line);
        count++;
      }
      out.close();

    } catch (Exception e) {

    }
    System.out.printf("%d개의 board 데이터가 저장 되었습니다.\n", count);
  }

  private static void saveMemberData() {
    File file = new File("./member.csv");
    FileWriter out = null;
    int count = 0;
    
    try {
      out = new FileWriter(file);
      
      for (int i = 0; i < memberList.size(); i++) {
        Member m = memberList.get(i);
        String str = String.format("%d,%s,%s,%s\n", m.getNo()
            , m.getName(), m.getEmail(), m.getPw());
        out.write(str);
        count++;
      }
      out.close();
    } catch (Exception e) {

    }
    System.out.printf("%d개의 member 데이터를 저장했습니다.", count);
  }
}