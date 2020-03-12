package com.whddbs.sm.util;

import java.util.Arrays;

public class LinkedList<E> {

  Node first;
  Node last;

  int size;

  static class Node {
    Object value;
    Node next;
  }

  public void add(E value) {
    Node node = new Node();
    node.value = value;

    if(first == null) {
      first = last = node;
    } else {
      last.next = node;
      last = node;
    }

    size++;
  }

  public E get(int index) {
    Node cursor = first;

    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }

    return (E) cursor.value;
  }

  /*remove수정*/
  public void remove(int index) {
    Node cursor = first;

    if (index == 1) {
      first = first.next;
    } else {
      for (int i = 0; i < index - 2; i++) {
        cursor = cursor.next;
      }
      Node deleteNode = cursor.next;
      cursor.next = deleteNode.next;
    }
    size--;
  }

  public E set(int index) {
    Node cursor = new Node();
    cursor = first;

    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    return (E) cursor.value;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] e) {
    Object[] arr = new Object[size];

    Node cursor = new Node();
    cursor = first;

    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }

    return (E[]) Arrays.copyOf(arr, size, e.getClass());
  }

  public int size() {
    return this.size;
  }
  /*
   add(value)
   get(index)
   add(index, value)
   remove(index)
   set(index, value)
   toArray()
   size() 
   */
}
