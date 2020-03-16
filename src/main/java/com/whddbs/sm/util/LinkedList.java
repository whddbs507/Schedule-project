package com.whddbs.sm.util;

import java.util.Arrays;

public class LinkedList<E> {
  Node<E> first;
  Node<E> last;
  
  int size;
  
  LinkedList() {
  }
  
  public class Node<E> {
    E value;
    Node next;
  }
  
  public void add(E e) {
    Node newNode = new Node();
    
    if (first == null) {
      first = newNode;
      last = newNode;
    } else {
      last.next = newNode;
      last = last.next;
    }
    last.value = e;
  }
  
  public E[] toArray(E[] arr) {
    Node cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }
  
  public E get(int num) {
    
  }
  
  public E set(int num) {
    
  }
  
  public void remove(int index) {
    
  }
  
  public int size() {
    return this.size;
  }
}
