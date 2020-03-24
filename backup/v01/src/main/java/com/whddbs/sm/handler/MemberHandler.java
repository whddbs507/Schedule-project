package com.whddbs.sm.handler;

import java.util.Scanner;
import com.whddbs.sm.domain.Member;
import com.whddbs.sm.util.Iterator;
import com.whddbs.sm.util.List;

public class MemberHandler<E> {
  static Scanner keyboard = new Scanner(System.in);
  int memberCount = 0;
  Scanner scanner;
  List<Member> list;
  Iterator<Member> iterator;
    
  public MemberHandler(Scanner scanner, List<Member> list) {
    this.scanner = scanner;
    this.list = list;
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

    this.list.add(member);
  }

  public void listMember() {
    Member[] members = new Member[this.list.size()];
    
    members = this.list.toArray(members);
    
    iterator = list.iterator();
    
    System.out.println(iterator.hasnext());
    
    while (iterator.hasnext()) {
      Member m = iterator.next();
      System.out.printf("%d %s %s %s\n", m.getNo(),
          m.getName(), m.getEmail(), m.getPw());
    }
  }

  public void detailMember() {
    int detailNum = keyboard.nextInt();
    keyboard.nextLine();

    Member member = this.list.get(detailNum);

    System.out.printf("번호 : %d\n", member.getNo());
    System.out.printf("이름 : %s\n", member.getName());
    System.out.printf("이메일 : %s\n", member.getEmail());
    System.out.printf("비밀번호 : %s\n", member.getPw());
  }

  public void updateMember() {
    System.out.print("변경할 번호 선택 : ");
    int updateNum = keyboard.nextInt();
    keyboard.nextLine();

    Member member = this.list.set(updateNum);

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

    int index = indexOfMember(deleteNum);
    
    if (index == -1) {
      System.out.println("존재하지 않는 넘버입니다.");
    }
    
    this.list.remove(index);
  }
  
  private int indexOfMember(int no) {
    for (int i = 0; i <= this.list.size(); i++) {
      if (this.list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
