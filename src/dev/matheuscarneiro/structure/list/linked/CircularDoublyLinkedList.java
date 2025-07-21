package dev.matheuscarneiro.structure.list.linked;

public class CircularDoublyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public CircularDoublyLinkedList() {
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
      newNode.setPrev(tail);
    } else {
      newNode.setNext(this.head);
      this.head.setPrev(newNode);
      newNode.setPrev(this.tail);
      this.tail.setNext(newNode);
      this.head = newNode;
    }
    this.size++;
  }

  public void addLast(T data) {
    if (isEmpty()) {
      addFirst(data);
      return;
    }
    Node<T> newNode = new Node<>(data);
    newNode.setPrev(this.tail);
    this.tail.setNext(newNode);
    newNode.setNext(this.head);
    this.head.setPrev(newNode);
    this.tail = newNode;
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
      this.head.setPrev(this.tail);
      this.tail.setNext(this.head);
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
      this.tail.setNext(this.head);
      this.head.setPrev(this.tail);
    }
    this.size--;
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
    Node<T> nodeToRemove = getNode(index);
    Node<T> previousNode = nodeToRemove.getPrev();
    Node<T> nextNode = nodeToRemove.getNext();

    previousNode.setNext(nextNode);
    nextNode.setPrev(previousNode);
    this.size--;

    return nodeToRemove.getData();
  }

  private Node<T> getNode(int index) {
    checkIndexBounds(index);
    Node<T> current;
    if (index < this.size / 2) {
      current = this.head;
      for (int i = 0; i < index; i++) {
        current = current.getNext();
      }
    } else {
      current = this.tail;
      for (int i = this.size - 1; i > index; i--) {
        current = current.getPrev();
      }
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
      throw new IndexOutOfBoundsException("Index for add operation out of bounds");
    }
  }
}