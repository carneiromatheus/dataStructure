package dev.matheuscarneiro.structure.list.linked;

import java.util.NoSuchElementException;

public class Queue<T> {
  private DoublyLinkedList<T> list;

  public Queue() {
    this.list = new DoublyLinkedList<>();
  }

  public void enqueue(T element) {
    list.addLast(element);
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
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