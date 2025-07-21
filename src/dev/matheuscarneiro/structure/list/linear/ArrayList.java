package dev.matheuscarneiro.structure.list.linear;

public class ArrayList<T> {
  private T[] array;
  private int size;
  private static final int DEFAULT_CAPACITY = 10;

  @SuppressWarnings("unchecked")
  public ArrayList(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be greater than zero");
    }
    this.array = (T[]) new Object[capacity];
    this.size = 0;
  }

  public ArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public void add(T element) {
    checkElementNotNull(element);
    ensureCapacity();
    this.array[this.size++] = element;
  }

  public void add(int index, T element) {
    checkElementNotNull(element);
    checkIndexForAdd(index);
    ensureCapacity();
    System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
    this.array[index] = element;
    this.size++;
  }

  public T remove(int index) {
    checkIndexBounds(index);
    T removedElement = this.array[index];
    int numMoved = this.size - index - 1;
    if (numMoved > 0) {
      System.arraycopy(this.array, index + 1, this.array, index, numMoved);
    }
    this.array[--this.size] = null;
    return removedElement;
  }

  public T get(int index) {
    checkIndexBounds(index);
    return this.array[index];
  }

  public void set(int index, T element) {
    checkIndexBounds(index);
    checkElementNotNull(element);
    this.array[index] = element;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean contains(T element) {
    checkElementNotNull(element);
    for (int i = 0; i < this.size; i++) {
      if (this.array[i].equals(element)) {
        return true;
      }
    }
    return false;
  }

  public void clear() {
    for (int i = 0; i < this.size; i++) {
      this.array[i] = null;
    }
    this.size = 0;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("[");
    for (int i = 0; i < this.size; i++) {
      sb.append(this.array[i]);

      if (i < this.size - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");

    return sb.toString();
  }

  @SuppressWarnings("unchecked")
  private void ensureCapacity() {
    if (this.size == this.array.length) {
      int newCapacity = this.array.length * 3 / 2 + 1;
      T[] newArray = (T[]) new Object[newCapacity];
      System.arraycopy(this.array, 0, newArray, 0, this.size);
      this.array = newArray;
    }
  }

  private void checkElementNotNull(T element) {
    if (element == null) {
      throw new NullPointerException("Element cannot be null");
    }
  }

  private void checkIndexBounds(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for array size " + this.size);
    }
  }

  private void checkIndexForAdd(int index) {
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException(
          "Index " + index + " out of bounds for add operation with array size " + this.size);
    }
  }
}