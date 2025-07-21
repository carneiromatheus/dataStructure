package dev.matheuscarneiro.structure.list.linked;

class Node<T> {
  private T data;
  private Node<T> next;

  protected Node(T data) {
    checkArgumentNotNull(data);
    this.data = data;
    this.next = null;
  }

  protected T getData() {
    return data;
  }

  protected void setData(T data) {
    checkArgumentNotNull(data);
    this.data = data;
  }

  protected Node<T> getNext() {
    return next;
  }

  protected void setNext(Node<T> next) {
    this.next = next;
  }

  private void checkArgumentNotNull(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Data cannot be null");
    }
  }

  @Override
  public String toString() {
    return data.toString();
  }
}
