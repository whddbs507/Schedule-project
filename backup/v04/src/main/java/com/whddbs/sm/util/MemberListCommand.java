package com.whddbs.sm.util;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.whddbs.sm.domain.Member;

public class MemberListCommand implements Command {
  
  Scanner input;
  List<Member> memberList;
  
  public MemberListCommand(Scanner input, List<Member> list) {
    this.input = input;
    this.memberList = list;
  }
  
  public void execute() {
    
    Iterator<Member> iterator = memberList.iterator();
    
    while (iterator.hasNext()) {
      Member member = iterator.next();
      System.out.printf("%d %s %s %s\n", member.getNo(), member.getName()
          , member.getEmail(), member.getPw());
    }
  }
}
