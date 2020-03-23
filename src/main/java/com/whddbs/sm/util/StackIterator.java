package com.whddbs.sm.util;

public class StackIterator implements Iterator {
  
  Stack stack;
  
  public StackIterator(Stack stack) throws CloneNotSupportedException {
    this.stack = stack.clone();
  }
  
  public boolean hasnext() {
    return !stack.empty();
  }
  
  public Object next() {
    return stack.pop();
  }
}
