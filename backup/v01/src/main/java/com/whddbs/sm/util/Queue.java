package com.whddbs.sm.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {
  
  public void offer(E str) {
    this.add(str);
  }

  public E poll() {
    return this.remove(0);
  }
  
  public Iterator iterator() throws CloneNotSupportedException {
    return new QueueIterator(this); 
  }
  
  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    return (Queue<E>) super.clone();
  }
}