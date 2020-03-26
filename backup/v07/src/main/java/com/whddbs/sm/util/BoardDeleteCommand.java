package com.whddbs.sm.util;

import java.util.List;
import java.util.Scanner;
import com.whddbs.sm.domain.Board;

public class BoardDeleteCommand implements Command {
  
  List<Board> boardList;
  Scanner input;
  
  public BoardDeleteCommand(Scanner input, List<Board> list) {
    this.input = input;
    this.boardList = list; 
  }
  
  public void execute() {
    System.out.print("삭제할 번호 : ");
    int no = input.nextInt();
    input.nextLine();

    for (int i = 0; i < boardList.size(); i++) {
      if (boardList.get(i).getNo() == no) {
        boardList.remove(i);
        break;
      } 
    }
  }
}
