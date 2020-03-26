package com.whddbs.sm.util;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.whddbs.sm.domain.Board;

public class BoardListCommand implements Command {
  
  Scanner input;
  List<Board> boardList;
  
  public BoardListCommand(Scanner input, List<Board> list) {
    this.input = input;
    this.boardList = list; 
  }
  
  public void execute() {
    Iterator iterator = boardList.iterator();
      
    while (iterator.hasNext()) {
      Board board = (Board) iterator.next();
      System.out.printf("%d %s %s\n"
          , board.getNo(), board.getTitle(), board.getTitle());
    }
  }
}
