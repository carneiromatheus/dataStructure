package dev.matheuscarneiro.tp.sparse_matrix;

class Cell {
  Cell right;
  Cell down;
  int row;
  int column;
  float value;

  public Cell(int row, int column, float value) {
    this.row = row;
    this.column = column;
    this.value = value;
    this.right = null;
    this.down = null;
  }

  public Cell() {
    this.row = -1;
    this.column = -1;
    this.value = 0;
    this.right = this;
    this.down = this;
  }
}