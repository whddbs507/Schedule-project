package com.whddbs.sm.handler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import com.whddbs.sm.domain.Board;

public class BoardHandler {
  final static int SIZE = 100;
  static Scanner keyboard = new Scanner(System.in);
  static Board[] boards; 
  Scanner input;
  
  public BoardHandler(Scanner input) {
    this.input = input;
    boards = new Board[SIZE];
  }
  
  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    boards = new Board[capacity];
  }
  
  public static void addBoard() {
    Board board = new Board();
    ++board.no;
    
    System.out.printf("번호 : %d\n", board.no);
    
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
    
    boards[board.no - 1] = board;
  }

  public static void listBoard() {
    System.out.print("확인할 번호 : ");
    int listNo = keyboard.nextInt();
    keyboard.nextLine();
    Board board = boards[listNo - 1];
    System.out.printf("번호 : %d\n", listNo);
    System.out.printf("제목 : %s\n", board.title);
    System.out.printf("내용 : %s\n", board.contents);
    System.out.printf("등록일 : %s\n", board.registeredDay);
  }
}