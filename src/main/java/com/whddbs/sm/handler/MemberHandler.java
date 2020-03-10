package com.whddbs.sm.handler;

import java.util.Scanner;
import com.whddbs.sm.domain.Member;
import com.whddbs.sm.util.ArrayList;

public class MemberHandler {
  static Scanner keyboard = new Scanner(System.in);
  int memberCount = 0;
  Scanner scanner;
  ArrayList<Member> memberList;

  public MemberHandler(Scanner scanner) {
    this.scanner = scanner;
    this.memberList = new ArrayList<>();
  }

  public MemberHandler(Scanner scanner, int capacity) {
    this.scanner = scanner;
    this.memberList = new ArrayList<>(capacity);
  }

  public void addMember() {
    Member member = new Member();
    member.setNo(++memberCount);

    System.out.printf("번호 : %d\n", member.getNo());

    System.out.print("이름 : ");
    member.setName(keyboard.nextLine());

    System.out.print("이메일 : ");
    member.setEmail(keyboard.nextLine());

    System.out.print("비밀번호 : ");
    member.setPw(keyboard.nextLine());

    System.out.print("비밀번호 확인 : ");
    member.setPwRe(keyboard.nextLine());

    this.memberList.add(member);
  }

  public void listMember() {
    System.out.print("확인할 번호 : ");
    int listNo = keyboard.nextInt();
    keyboard.nextLine();
    
    Member member = this.memberList.get(listNo);
    
    System.out.printf("번호 : %d\n", listNo);
    System.out.printf("이름 : %s\n", member.getName());
    System.out.printf("이메일 : %s\n", member.getEmail());
    System.out.printf("비밀번호 : %s\n", member.getPw());
  }
}
