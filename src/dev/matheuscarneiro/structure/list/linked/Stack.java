package dev.matheuscarneiro.structure.list.linked;

import java.util.NoSuchElementException;

public class Stack<T> {
  private DoublyLinkedList<T> list;

  public Stack() {
    this.list = new DoublyLinkedList<>();
  }

  public void push(T element) {
    list.addFirst(element);
  }

  public T pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    return list.removeFirst();
  }

  public T peek() {
    if (isEmpty()) {
      return null;
    }
    return list.get(0);
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