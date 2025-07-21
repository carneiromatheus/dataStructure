package dev.matheuscarneiro.structure.list.linked;

public class DoublyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public DoublyLinkedList() {
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
    } else {
      newNode.setNext(this.head);
      this.head.setPrev(newNode);
      this.head = newNode;
    }
    this.size++;
  }

  public void addLast(T data) {
    Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.setNext(newNode);
      newNode.setPrev(this.tail);
      this.tail = newNode;
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

    Node<T> currentNode = getNode(index);
    Node<T> previousNode = currentNode.getPrev();
    Node<T> newNode = new Node<>(data);

    newNode.setNext(currentNode);
    newNode.setPrev(previousNode);

    previousNode.setNext(newNode);
    currentNode.setPrev(newNode);

    this.size++;
  }

  public T removeFirst() {
    checkIfEmpty();
    T removedData = this.head.getData();
    if (this.head == this.tail) {
      this.head = null;
      this.tail = null;
    } else {
      this.head = this.head.getNext();
      this.head.setPrev(null);
    }
    this.size--;
    return removedData;
  }

  public T removeLast() {
    checkIfEmpty();
    T removedData = this.tail.getData();
    if (this.head == this.tail) {
      this.head = null;
      this.tail = null;
    } else {
      this.tail = this.tail.getPrev();
      this.tail.setNext(null);
    }
    this.size--;
    return removedData;
  }

  public T remove(int index) {
    checkIndexBounds(index);

    if (index == 0) {
      return removeFirst();
    }
    if (index == size - 1) {
      return removeLast();
    }

    Node<T> nodeToRemove = getNode(index);
    Node<T> previousNode = nodeToRemove.getPrev();
    Node<T> nextNode = nodeToRemove.getNext();

    previousNode.setNext(nextNode);
    nextNode.setPrev(previousNode);

    this.size--;

    nodeToRemove.setNext(null);
    nodeToRemove.setPrev(null);

    return nodeToRemove.getData();
  }

  public T get(int index) {
    return getNode(index).getData();
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
    if (isEmpty()) {
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
      throw new IndexOutOfBoundsException("Index for add out of bounds");
    }
  }
}