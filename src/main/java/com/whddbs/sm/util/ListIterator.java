package com.whddbs.sm.util;

public class ListIterator<E> implements Iterator {
  
  List<E> list;
  int cursor;
  
  public ListIterator(E e) {
    
  }
  
  public boolean hasnext() {
    return cursor < list.size();
  }
  
  public Object next() {
    return list.get(cursor++);
  }
}
