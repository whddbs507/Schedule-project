package com.whddbs.sm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.whddbs.sm.util.BoardAddCommand;
import com.whddbs.sm.util.BoardDeleteCommand;
import com.whddbs.sm.util.BoardDetailCommand;
import com.whddbs.sm.util.BoardListCommand;
import com.whddbs.sm.util.Command;
import com.whddbs.sm.util.MemberAddCommand;
import com.whddbs.sm.util.MemberDeleteCommand;
import com.whddbs.sm.util.MemberDetailCommand;
import com.whddbs.sm.util.MemberListCommand;

public class App {
  static Scanner keyboard = new Scanner(System.in);
  static Deque<String> stack = new ArrayDeque();
  static Queue<String> queue = new LinkedList();

  public static void main(String[] args) throws CloneNotSupportedException{
  }
  
  public static void printCommandHistory(Iterator iterator) throws CloneNotSupportedException {
    while (iterator.hasNext()) {
      System.out.printf("%s\n", iterator.next());
    }
  }
}