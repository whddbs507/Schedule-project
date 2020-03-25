package com.whddbs.sm.util;

import java.util.List;
import java.util.Scanner;
import com.whddbs.sm.domain.Board;

public class BoardDetailCommand implements Command {
  
  Scanner input;
  List<Board> boardList;
  
  public BoardDetailCommand(Scanner input, List<Board> list) {
    this.input = input;
    this.boardList = list;
  }
  
  public void execute() {
    System.out.print("확인할 번호 : ");
    int no = input.nextInt();
    input.nextLine();

    for (int i = 0; i < boardList.size(); i++) {
      if (boardList.get(i).getNo() == no) {
        Board board = boardList.get(i);
        System.out.printf("번호 : %d\t", board.getNo());
        System.out.printf("제목 : %s\t", board.getTitle());
        System.out.printf("내용 : %s\n", board.getContents());
        break;
      }
    }
  }
}
