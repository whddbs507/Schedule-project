package com.whddbs.sm.handler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import com.whddbs.sm.domain.Board;
import com.whddbs.sm.util.Iterator;
import com.whddbs.sm.util.List;

public class BoardHandler<E> {
  static Scanner keyboard = new Scanner(System.in);
  static Board[] boards; 
  static int boardCount = 0;
  List<Board> list;
  Scanner input;
  Iterator<Board> iterator;
  
  public BoardHandler(Scanner input, List<Board> list) {
    this.input = input;
    this.list = list;
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

    this.list.add(board);

  }

  public void listBoard() {
    Board[] boards = new Board[this.list.size()];

    boards = this.list.toArray(boards);
    iterator = list.iterator();
    while (iterator.hasnext()) {
      Board b = iterator.next();
      System.out.printf("%d %s %s %s\n", b.getNo(),
          b.getTitle(), b.getContents(), b.getRegisteredDay());
    }
  }

  public void detailBoard() {
    int detailNum = keyboard.nextInt();
    keyboard.nextLine();

    Board board = this.list.get(detailNum);

    System.out.printf("번호 : %d\n", board.getNo());
    System.out.printf("제목 : %s\n", board.getTitle());
    System.out.printf("내용 : %s\n", board.getContents());
    System.out.printf("등록일 : %s\n", board.getRegisteredDay());
  }

  public void updateBoard() {
    System.out.print("변경할 번호 선택 : ");
    int updateNum = keyboard.nextInt();
    keyboard.nextLine();

    Board board = this.list.set(updateNum);

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
    
    this.list.remove(index);
  }

  private int indexOfBoard(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      if (this.list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}