package com.whddbs.sm.util;

public class Queue<E> extends LinkedList<E> {
  
  public void offer(E str) {
    this.add(str);
  }

  public E poll() {
    return this.remove(0);
  }
}
