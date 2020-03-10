package com.whddbs.sm.handler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import com.whddbs.sm.domain.Board;
import com.whddbs.sm.util.ArrayList;

public class BoardHandler {
  static Scanner keyboard = new Scanner(System.in);
  static Board[] boards; 
  static int boardCount = 0;
  ArrayList<Board> boardList;
  Scanner input;
  
  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList<>();
  }
  
  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new ArrayList<>(capacity);
  }
  
  public void addBoard() {
    Board board = new Board();
    board.setNo(++boardCount);
    System.out.println(boardCount);
    
    System.out.printf("번호 : %d\n", board.getNo());
    
    Calendar calendar = new GregorianCalendar(Locale.KOREA);
    int nYear = calendar.get(Calendar.YEAR);
    int nMonth = calendar.get(Calendar.MONTH) + 1;
    int nDay = calendar.get(Calendar.DAY_OF_MONTH);
    
    board.setRegisterDay(nYear + "-" + nMonth + "-" + nDay);
    System.out.println(board.getRegisteredDay());
    
    System.out.print("제목 : ");
    board.setTitle(keyboard.nextLine());
    
    System.out.print("내용 : ");
    board.setContents(keyboard.nextLine());

    this.boardList.add(board);
  }

  public void listBoard() {
    System.out.print("확인할 번호 : ");
    int listNo = keyboard.nextInt();
    keyboard.nextLine();

    Board board = (Board)this.boardList.get(listNo);
    
    if (board == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
    }
    
    System.out.printf("번호 : %d\n", listNo);
    System.out.printf("제목 : %s\n", board.getTitle());
    System.out.printf("내용 : %s\n", board.getContents());
    System.out.printf("등록일 : %s\n", board.getRegisteredDay());
  }
}