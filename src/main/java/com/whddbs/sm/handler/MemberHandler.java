package com.whddbs.sm.handler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import com.whddbs.sm.domain.Board;
import com.whddbs.sm.domain.Member;
import com.whddbs.sm.util.ArrayList;

public class MemberHandler {
  static Scanner keyboard = new Scanner(System.in);
  int memberCount = 0;
  Scanner scanner;
  LinkedList<Member> memberList;

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
    Member[] members = new Member[this.memberList.size()];

    members = this.memberList.list(members);

    for (Member m : members) {
      System.out.printf("%d %s %s %s\n", m.getNo(),
          m.getName(), m.getEmail(), m.getPw());
    }
  }

  public void detailMember() {
    int detailNum = keyboard.nextInt();
    keyboard.nextLine();

    Member member = this.memberList.get(detailNum);

    System.out.printf("번호 : %d\n", member.getNo());
    System.out.printf("이름 : %s\n", member.getName());
    System.out.printf("이메일 : %s\n", member.getEmail());
    System.out.printf("비밀번호 : %s\n", member.getPw());
  }

  public void updateMember() {
    System.out.print("변경할 번호 선택 : ");
    int updateNum = keyboard.nextInt();
    keyboard.nextLine();

    Member member = this.memberList.set(updateNum);

    System.out.print("이름 : ");
    member.setName(keyboard.nextLine());

    System.out.print("이메일 : ");
    member.setEmail(keyboard.nextLine());

    System.out.print("비밀번호 : ");
    member.setPw(keyboard.nextLine());

    System.out.print("비밀번호 확인 : ");
    member.setPwRe(keyboard.nextLine());

  }

  public void deleteMember() {
    System.out.print("삭제할 번호 선택 : ");
    int deleteNum = keyboard.nextInt();
    keyboard.nextLine();

    this.memberList.remove(deleteNum);
  }
}
