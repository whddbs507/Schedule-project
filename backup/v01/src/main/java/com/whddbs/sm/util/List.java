package com.whddbs.sm.util;

public interface List<E> {
  public abstract void add(E e);
  public abstract E get(int no);
  public abstract E set(int no);
  public abstract E remove(int no);
  public abstract E[] toArray(E[] e);
  public abstract int size();
  public abstract Iterator<E> iterator();
}