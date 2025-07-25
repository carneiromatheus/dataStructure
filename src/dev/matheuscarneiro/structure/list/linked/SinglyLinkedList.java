package dev.matheuscarneiro.structure.list.linked;

public class SinglyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public SinglyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);

    if (this.isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.setNext(this.head);
      this.head = newNode;
    }

    this.size++;
  }

  public void add(int index, T data) {
    checkIndexForAdd(index);

    if (index == 0) {
      addFirst(data);
      return;
    }

    if (index == this.size) {
      addLast(data);
      return;
    }

    Node<T> previousNode = getNode(index - 1);
    Node<T> newNode = new Node<>(data);

    newNode.setNext(previousNode.getNext());
    previousNode.setNext(newNode);
    this.size++;
  }

  public void addLast(T data) {
    Node<T> newNode = new Node<>(data);

    if (this.isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.setNext(newNode);
      this.tail = newNode;
    }

    this.size++;
  }

  public T get(int index) {
    return getNode(index).getData();
  }

  public T removeFirst() {
    checkIfEmpty();
    T removedData = this.head.getData();
    this.head = this.head.getNext();
    this.size--;

    if (this.isEmpty()) {
      this.tail = null;
    }
    return removedData;
  }

  public T remove(int index) {
    checkIndexBounds(index);

    if (index == 0) {
      return removeFirst();
    }

    if (index == this.size - 1) {
      return removeLast();
    }

    Node<T> previousNode = getNode(index - 1);
    Node<T> nodeToRemove = previousNode.getNext();

    previousNode.setNext(nodeToRemove.getNext());
    this.size--;

    return nodeToRemove.getData();
  }

  public T removeLast() {
    checkIfEmpty();
    T removedData = this.tail.getData();

    if (this.head == this.tail) {
      this.head = null;
      this.tail = null;
    } else {
      Node<T> current = this.head;
      while (current.getNext() != this.tail) {
        current = current.getNext();
      }
      current.setNext(null);
      this.tail = current;
    }

    this.size--;
    return removedData;
  }

  private Node<T> getNode(int index) {
    checkIndexBounds(index);
    Node<T> current = this.head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current;
  }

  private void checkIfEmpty() {
    if (this.isEmpty()) {
      throw new IllegalStateException("List is empty");
    }
  }

  private void checkIndexBounds(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
  }

  private void checkIndexForAdd(int index) {
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException("Index for add operation out of bounds");
    }
  }
}