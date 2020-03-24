package com.whddbs.sm.util;

import java.util.Arrays;

public class ArrayList<E> implements List<E>{
  
  final static int DEFAULT_CAPACITY = 10;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int capacity) {
    elementData = new Object[capacity];
  }
  
  public void add(E e) {
    elementData[size++] = e;
  }
  
  public E get(int index) {
      return (E) elementData[index];
  }
  
  public E set(int index) {
    return (E) elementData[index];
  }
  
  public E remove(int index) {
    for (int i = index - 1; i < size - 1; i++) {
      elementData[i] = elementData[i + 1];
    }
    elementData[size--] = null;
    return null;
  }
  
  public E[] toArray(E[] e) {
    return (E[]) Arrays.copyOf(elementData, size, e.getClass());
  }
  
  public int size() {
    return this.size;
  }
  
  public Iterator<E> iterator() {
    return new ListIterator<E>(this);
  }
}