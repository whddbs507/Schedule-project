package com.whddbs.sm.util;

import com.whddbs.sm.domain.Board;

public class ArrayList<E> {
  
  final static int DEFAULT_CAPACITY = 10;
  
  Object[] list;
  int size = 0;
  
  public ArrayList() {
    list = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int capacity) {
    list = new Object[capacity];
  }
  
  public void add(E object) {
    list[size++] = object;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int listNo) {
    if (listNo > 0 || listNo <= list.length) {
      return (E)list[listNo - 1];
    }
    return null;
  }
  
}
