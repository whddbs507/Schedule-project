package com.whddbs.sm.handler;

import java.util.Scanner;
import com.whddbs.sm.domain.Member;

public class MemberHandler {
  static Scanner keyboard = new Scanner(System.in);
  static Member[] members = new Member[100]; 
  
  public static void addMember() {
    Member member = new Member();
    ++member.no;
    
    System.out.printf("번호 : %d\n", member.no);
    
    System.out.print("이름 : ");
    member.name = keyboard.nextLine();
    
    System.out.print("이메일 : ");
    member.email = keyboard.nextLine();
    
    System.out.print("비밀번호 : ");
    member.pw = keyboard.nextLine();
    
    System.out.print("비밀번호 확인 : ");
    member.pwRe = keyboard.nextLine();
    
    members[member.no - 1] = member;
  }

  public static void listMember() {
    System.out.print("확인할 번호 : ");
    int listNo = keyboard.nextInt();
    keyboard.nextLine();
    Member member = members[listNo - 1];
    System.out.printf("번호 : %d\n", listNo);
    System.out.printf("이름 : %s\n", member.name);
    System.out.printf("이메일 : %s\n", member.email);
    System.out.printf("비밀번호 : %s\n", member.pw);
  }
}
