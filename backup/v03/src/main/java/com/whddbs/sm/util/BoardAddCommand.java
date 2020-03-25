package com.whddbs.sm.util;

import java.util.List;
import java.util.Scanner;
import com.whddbs.sm.domain.Board;

public class BoardAddCommand implements Command {
  
  Scanner input;
  List<Board> boardList;
  int no;
  
  public BoardAddCommand(Scanner input, List<Board> list) {
    this.input = input;
    this.boardList = list;
  }
  
  public void execute() {
    Board board = new Board();
    
    board.setNo(++no);
    
    System.out.print("제목 : ");
    String title = input.nextLine();
    board.setTitle(title);
    
    System.out.print("내용 : ");
    String contents = input.nextLine();
    board.setContents(contents);
   
    boardList.add(board);
  }
}
