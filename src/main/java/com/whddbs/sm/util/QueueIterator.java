package com.whddbs.sm.util;

public class QueueIterator implements Iterator {
  
  Queue queue;
  
  public QueueIterator(Queue queue) throws CloneNotSupportedException {
    this.queue = queue.clone();
  }
  
  public boolean hasnext() {
    return queue.size() > 0; 
  }
  
  public Object next() {
    return queue.poll();
  }
}
