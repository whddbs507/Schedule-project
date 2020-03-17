package com.whddbs.sm.util;

import java.util.Arrays;

public class LinkedList<E> {
  Node<E> first;
  Node<E> last;

  int size;

  public LinkedList() {
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
      last = newNode;
    }
    last.value = e;
    size++;
  }

  public E[] toArray(E[] arr) {
    Node cursor = first;

    for (int i = 0; i < this.size; i++) {
      arr[i] = (E)cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }

  public E get(int num) {
    Node cursor = first;

    for (int i = 0; i < num; i++) {
      cursor = cursor.next;
    }

    return (E)cursor.value;
  }

  public E set(int num) {
    Node cursor = first;

    for (int i = 0; i < num; i++) {
      cursor = cursor.next;
    }
    
    return (E)cursor.value;
  }  


  public E remove(int index) {
    Node cursor = first;
    
    if (index < 0 || index > size) {
      return null;
    }
    
    
    if (index == 0) {
      first = first.next;
      return first.value;
    } else {
      if(index == size - 1) {
        last = first;
        
        for (int i = 0; i < index - 1; i++) {
          last = last.next;
        }
      }
      for (int i = 0; i < index - 1; i++) {
        cursor = cursor.next;
      }
      
      Node deleteNode = cursor.next;
      cursor.next = deleteNode.next;
      
      --size;
      return (E)deleteNode.value;
    }
  }

  public int size() {
    return this.size;
  }
}
