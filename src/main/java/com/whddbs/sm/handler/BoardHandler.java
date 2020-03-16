package com.whddbs.sm.handler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import com.whddbs.sm.domain.Board;
import com.whddbs.sm.util.ArrayList;
import com.whddbs.sm.util.LinkedList;

public class BoardHandler {
  static Scanner keyboard = new Scanner(System.in);
  static Board[] boards; 
  static int boardCount = 0;
  LinkedList<Board> boardList;
  Scanner input;

  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new LinkedList<>();
  }

  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new LinkedList<>();
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
    Board[] boards = new Board[this.boardList.size()];

    boards = this.boardList.toArray(boards);

    for (Board b : boards) {
      System.out.printf("%d %s %s %s\n", b.getNo(),
          b.getTitle(), b.getContents(), b.getRegisteredDay());
    }
  }

  public void detailBoard() {
    int detailNum = keyboard.nextInt();
    keyboard.nextLine();

    Board board = this.boardList.get(detailNum);

    System.out.printf("번호 : %d\n", board.getNo());
    System.out.printf("제목 : %s\n", board.getTitle());
    System.out.printf("내용 : %s\n", board.getContents());
    System.out.printf("등록일 : %s\n", board.getRegisteredDay());
  }

  public void updateBoard() {
    System.out.print("변경할 번호 선택 : ");
    int updateNum = keyboard.nextInt();
    keyboard.nextLine();

    Board board = this.boardList.set(updateNum);

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
  }

  public void deleteBoard() {
    System.out.print("삭제할 번호 선택 : ");
    int deleteNum = keyboard.nextInt();
    keyboard.nextLine();

    int index = indexOfBoard(deleteNum);
    
    if (index == -1) {
      System.out.println("존재하지 않는 넘버입니다.");
    }
    
    this.boardList.remove(index);
  }

  private int indexOfBoard(int no) {
    for (int i = 0; i <= this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}