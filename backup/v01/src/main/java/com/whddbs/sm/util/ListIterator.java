package com.whddbs.sm.util;

public class ListIterator<E> implements Iterator {
  
  List<E> list;
  int cursor;
  
  public ListIterator(List<E> list) {
    this.list = list;
  }
  
  public boolean hasnext() {
    return cursor < list.size();
  }
  
  public E next() {
    return list.get(cursor++);
  }
}