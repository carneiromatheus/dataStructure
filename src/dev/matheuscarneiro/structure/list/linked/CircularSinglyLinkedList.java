package dev.matheuscarneiro.structure.list.linked;

public class CircularSinglyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public CircularSinglyLinkedList() {
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
    if (isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
      newNode.setNext(head);
    } else {
      newNode.setNext(this.head);
      this.head = newNode;
      this.tail.setNext(head);
    }
    this.size++;
  }

  public void addLast(T data) {
    if (isEmpty()) {
      addFirst(data);
      return;
    }
    Node<T> newNode = new Node<>(data);
    this.tail.setNext(newNode);
    this.tail = newNode;
    this.tail.setNext(this.head);
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

  public T get(int index) {
    return getNode(index).getData();
  }

  public T removeFirst() {
    checkIfEmpty();
    T removedData = this.head.getData();
    if (this.head == this.tail) {
      this.head = null;
      this.tail = null;
    } else {
      this.head = this.head.getNext();
      this.tail.setNext(this.head);
    }
    this.size--;
    return removedData;
  }

  public T removeLast() {
    return remove(this.size - 1);
  }

  public T remove(int index) {
    checkIndexBounds(index);
    if (index == 0) {
      return removeFirst();
    }
    Node<T> previousNode = getNode(index - 1);
    Node<T> nodeToRemove = previousNode.getNext();
    T removedData = nodeToRemove.getData();
    previousNode.setNext(nodeToRemove.getNext());
    if (nodeToRemove == this.tail) {
      this.tail = previousNode;
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