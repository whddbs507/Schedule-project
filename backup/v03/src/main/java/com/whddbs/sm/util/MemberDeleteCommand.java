package com.whddbs.sm.util;

import java.util.List;
import java.util.Scanner;
import com.whddbs.sm.domain.Member;

public class MemberDeleteCommand implements Command {
  
  Scanner input;
  List<Member> memberList;
  
  public MemberDeleteCommand(Scanner input, List<Member> list) {
    this.input = input;
    this.memberList = list;
  }
  
  public void execute() {
    System.out.print("삭제할 번호 :");
    int no = input.nextInt();
    input.nextLine();
    
    for (int i = 0; i < memberList.size(); i++) {
      if (memberList.get(i).getNo() == no) {
        memberList.remove(i);
        break;
      }
    }
  }

}
