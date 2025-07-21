package dev.matheuscarneiro.structure.list.linear;

import java.util.NoSuchElementException;

public class Queue<T> {
  private ArrayList<T> list;

  public Queue() {
    this.list = new ArrayList<>();
  }

  public Queue(int initialCapacity) {
    this.list = new ArrayList<>(initialCapacity);
  }

  public void enqueue(T element) {
    list.add(element);
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }

    return list.remove(0);
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