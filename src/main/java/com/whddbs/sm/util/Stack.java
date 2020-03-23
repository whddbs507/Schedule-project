package com.whddbs.sm.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable {
  
  Object[] elementData;
  int size;
  
  private static final int DEFAULT_CAPACITY = 10;
 
  public Stack() {
    elementData = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }
  
  public void push(E str) {
    elementData[size++] = str;
  }
  
  public Object pop() {
    return elementData[--size];
  }
  
  public void grow() {
    Arrays.copyOf(elementData, newCapacity());
  }
  
  public boolean empty() {
    return this.size == 0;
  }
  
  private int newCapacity() {
    int oldCapacity = elementData.length;
    return oldCapacity + (oldCapacity >> 1);
  }
  
  public Iterator iterator() throws CloneNotSupportedException {
    return new StackIterator(this);
  }
  
  @Override
  public Stack<E> clone() throws CloneNotSupportedException {
    return (Stack<E>) super.clone();
  }
}
