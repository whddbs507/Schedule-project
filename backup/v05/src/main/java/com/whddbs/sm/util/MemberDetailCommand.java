package com.whddbs.sm.util;

import java.util.List;
import java.util.Scanner;
import com.whddbs.sm.domain.Member;

public class MemberDetailCommand implements Command {
  
  Scanner input;
  List<Member> memberList;
  
  public MemberDetailCommand(Scanner input, List<Member> list) {
    this.input = input;
    this.memberList = list;
  }
  
  public void execute() {
    System.out.print("확인할 번호 : ");
    int no = input.nextInt();
    input.nextLine();
    
    for (int i = 0; i < memberList.size(); i++) {
      if (memberList.get(i).getNo() == no) {
        Member member = memberList.get(i);
        System.out.printf("번호 : %d\t", member.getNo());
        System.out.printf("이름 : %s\t", member.getName());
        System.out.printf("이메일 : %s\t", member.getEmail());
        System.out.printf("비밀번호 : %s\n", member.getPw());
        break;
      }
    }
  }

}
