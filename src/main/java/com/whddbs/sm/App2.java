package com.whddbs.sm;

import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    class SignUp {
      String name;
      String email;
      String password;
      String passwordRe;
      String picture;
    }

    final int SIZE = 100;
    int count = 1;

    SignUp[] joinSite = new SignUp[SIZE];

    for(int i = 0; i < count; i++) {
      SignUp sign = new SignUp();
      joinSite[i] = sign;

      System.out.print("이름?  ");
      sign.name = keyScan.nextLine();
      System.out.print("이메일?  ");
      sign.email = keyScan.nextLine();
      System.out.print("비밀번호?  ");
      sign.password = keyScan.nextLine();
      System.out.print("비밀번호 확인?  ");
      sign.passwordRe = keyScan.nextLine();
      if (!(sign.password).equals(sign.passwordRe) ) {
        System.out.println("비밀번호가 다릅니다. 다시 입력해주세요.");
        break;
      }
      System.out.print("사진?  ");
      sign.picture = keyScan.nextLine();
      System.out.println("계속 입력하시겠습니까? (Y/n)");
      String response = keyScan.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }  
      count++;
    }

    for (int i = 0; i < count; i++) {
      System.out.printf("%s %s %s %s\n", joinSite[i].name, joinSite[i].email, joinSite[i].password, joinSite[i].picture);
    }

  }
}