package com.whddbs.sm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.google.gson.Gson;
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
    Gson gson = new Gson();
    File file = new File("./board.data");
    
    try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      int size = in.readInt();
      
      for (int i = 0; i < size; i++) {
        Board board = new Board();
        board.setNo(in.readInt());
        board.setTitle(in.readUTF());
        board.setContents(in.readUTF());
        
        boardList.add(board);
      }
      
      System.out.printf("%d개의 board 데이터를 로드했습니다.\n", boardList.size());
      
      in.close();
    } catch (Exception e) {
      
    }
  }
  
  private static void loadMemberData() {
    Gson gson = new Gson();
    File file = new File("./member.data");
    
    try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      int size = in.readInt();
      
      for (int i = 0; i < size; i++) {
        Member member = new Member();
        
        member.setNo(in.readInt());
        member.setName(in.readUTF());
        member.setEmail(in.readUTF());
        member.setPw(in.readUTF());
        
        memberList.add(member);
      }
      
      System.out.printf("%d개의 member 데이터를 로드합니다.\n", memberList.size());
    } catch (Exception e) {
      
    }
  }
  
  private static void saveBoardData() {
    Gson gson = new Gson();
    File file = new File("./board.data");
    
    try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeInt(boardList.size());
      
      for (Board board : boardList) {
        out.writeInt(board.getNo());
        out.writeUTF(board.getTitle());
        out.writeUTF(board.getContents());
      }
      
      System.out.printf("%d개의 board 데이터를 저장합니다.\n", boardList.size());
      
      out.close();
    } catch (Exception e) {
      
    }
  }
  
  private static void saveMemberData() {
    Gson gson = new Gson();    
    File file = new File("./member.data");
    
    try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeInt(memberList.size());
      
      for (Member member : memberList) {
        out.writeInt(member.getNo());
        out.writeUTF(member.getName());
        out.writeUTF(member.getEmail());
        out.writeUTF(member.getPw());
      }
      
      System.out.printf("%d개의 member 데이터를 저장합니다.\n", memberList.size());
    } catch (Exception e) {
      
    }
  }
  
  
}