package dev.matheuscarneiro.structure.list.linear;

import java.util.NoSuchElementException;

public class Stack<T> {
  private ArrayList<T> list;

  public Stack() {
    this.list = new ArrayList<>();
  }

  public void push(T element) {
    list.add(element);
  }

  public T pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }

    return list.remove(list.size() - 1);
  }

  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }

    return list.get(list.size() - 1);
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public String toString() {
    return list.toString();
  }
}