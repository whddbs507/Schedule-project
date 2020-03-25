package com.whddbs.sm.util;

import java.util.List;
import java.util.Scanner;
import com.whddbs.sm.domain.Member;

public class MemberAddCommand implements Command {
  
  Scanner input;
  List<Member> memberList;
  
  public MemberAddCommand(Scanner input, List<Member> list) {
    this.input = input;
    this.memberList = list;
  }
    
  public void execute() {
    Member member = new Member();
    memberList.add(member);
    
    System.out.print("번호 : ");
    String no = input.nextLine();
    
    System.out.print("이름 : ");
    String name = input.nextLine();
    
    System.out.print("이메일 : ");
    String email = input.nextLine();
    
    System.out.print("비밀번호 : ");
    String pw = input.nextLine();
    
    System.out.print("비밀번호 재확인 : ");
    String pwRe = input.nextLine();
    
    member.setNo(Integer.parseInt(no));
    member.setName(name);
    member.setEmail(email);
    member.setPw(pw);
    member.setPwRe(pwRe);
  }
}
