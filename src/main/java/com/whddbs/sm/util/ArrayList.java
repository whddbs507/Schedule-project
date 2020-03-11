package com.whddbs.sm.util;

import java.util.Arrays;
import com.whddbs.sm.domain.Board;

public class ArrayList<E> {
  
  final static int DEFAULT_CAPACITY = 10;
  
  Object[] elementData;
  int size = 0;
  
  public ArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int capacity) {
    elementData = new Object[capacity];
  }
  
  public void add(E object) {
    elementData[size++] = object;
  }
  
  public E get(int detailNum) {
      return (E) elementData[detailNum - 1];
  }
  
  public E set(int updateNum) {
    return (E) elementData[updateNum - 1];
  }
  
  public void remove(int deleteNum) {
    for (int i = deleteNum - 1; i < size - 1; i++) {
      elementData[i] = elementData[i + 1];
    }
    elementData[size--] = null;
  }
  
  public E[] list(E[] e) {
    return (E[]) Arrays.copyOf(elementData, size, e.getClass());
  }
  
  public int size() {
    return this.size;
  }
}
