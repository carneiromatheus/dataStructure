package dev.matheuscarneiro.tp.sparse_matrix;

import java.util.Scanner;

public class SparseMatrix {
  private Cell mainHeader;
  private int numRows;
  private int numCols;

  public SparseMatrix(int rows, int columns) {
    if (rows <= 0 || columns <= 0) {
      throw new IllegalArgumentException("Matrix dimensions must be positive.");
    }

    this.numRows = rows;
    this.numCols = columns;
    this.mainHeader = new Cell();

    Cell[] rowHeaders = new Cell[rows];
    for (int i = 0; i < rows; i++) {
      rowHeaders[i] = new Cell();
    }

    Cell[] colHeaders = new Cell[columns];
    for (int i = 0; i < columns; i++) {
      colHeaders[i] = new Cell();
    }

    this.mainHeader.right = colHeaders[0];
    this.mainHeader.down = rowHeaders[0];

    for (int i = 0; i < columns - 1; i++) {
      colHeaders[i].right = colHeaders[i + 1];
    }

    for (int i = 0; i < rows - 1; i++) {
      rowHeaders[i].down = rowHeaders[i + 1];
    }
  }

  public void insert(int row, int column, float value) {
    if (row <= 0 || row > this.numRows || column <= 0 || column > this.numCols) {
      throw new IndexOutOfBoundsException("Row or column out of bounds.");
    }

    if (value == 0) {
      return;
    }

    Cell previousInRow = this.mainHeader;
    for (int i = 0; i < row; i++) {
      previousInRow = previousInRow.down;
    }
    Cell currentInRow = previousInRow;
    while (currentInRow.right != previousInRow && currentInRow.right.column < column) {
      currentInRow = currentInRow.right;
    }

    Cell previousInCol = this.mainHeader;
    for (int i = 0; i < column; i++) {
      previousInCol = previousInCol.right;
    }
    Cell currentInCol = previousInCol;
    while (currentInCol.down != previousInCol && currentInCol.down.row < row) {
      currentInCol = currentInCol.down;
    }

    if (currentInRow.right.column == column && currentInCol.down.row == row) {
      currentInRow.right.value = value;
      return;
    }

    Cell newNode = new Cell(row, column, value);

    newNode.right = currentInRow.right;
    currentInRow.right = newNode;

    newNode.down = currentInCol.down;
    currentInCol.down = newNode;
  }

  public void printMatrix() {
    Cell currentRowHeader = this.mainHeader.down;

    for (int i = 1; i <= this.numRows; i++) {
      Cell currentCell = currentRowHeader.right;

      for (int j = 1; j <= this.numCols; j++) {
        if (currentCell != currentRowHeader && currentCell.column == j) {
          System.out.print(currentCell.value + "\t");
          currentCell = currentCell.right;
        } else {
          System.out.print("0.0\t");
        }
      }

      System.out.println();
      currentRowHeader = currentRowHeader.down;
    }
  }

  public void readFromString(String input) {
    Scanner scanner = new Scanner(input);

    if (scanner.hasNextLine()) {
      String[] dimensions = scanner.nextLine().split(",");
      if (dimensions.length != 2) {
        scanner.close();
        throw new IllegalArgumentException("Invalid format for dimensions. Expected 'rows,cols'.");
      }
    }

    while (scanner.hasNextLine()) {
      String[] parts = scanner.nextLine().split(",");
      if (parts.length == 3) {
        try {
          int row = Integer.parseInt(parts[0].trim());
          int col = Integer.parseInt(parts[1].trim());
          float value = Float.parseFloat(parts[2].trim());
          this.insert(row, col, value);
        } catch (NumberFormatException e) {
          System.err.println("Skipping invalid line: " + String.join(",", parts));
        }
      }
    }
    scanner.close();
  }

  public SparseMatrix sum(SparseMatrix other) {
    if (this.numRows != other.numRows || this.numCols != other.numCols) {
      System.err.println("Error: Matrix dimensions must be the same for addition.");
      return null;
    }

    SparseMatrix resultMatrix = new SparseMatrix(this.numRows, this.numCols);

    Cell currentRowHeaderA = this.mainHeader.down;
    Cell currentRowHeaderB = other.mainHeader.down;

    for (int i = 1; i <= this.numRows; i++) {
      Cell currentA = currentRowHeaderA.right;
      Cell currentB = currentRowHeaderB.right;

      while (currentA != currentRowHeaderA || currentB != currentRowHeaderB) {
        if (currentA.column < currentB.column && currentA != currentRowHeaderA || currentB == currentRowHeaderB) {
          resultMatrix.insert(currentA.row, currentA.column, currentA.value);
          currentA = currentA.right;
        } else if (currentB.column < currentA.column && currentB != currentRowHeaderB
            || currentA == currentRowHeaderA) {
          resultMatrix.insert(currentB.row, currentB.column, currentB.value);
          currentB = currentB.right;
        } else {
          float sumValue = currentA.value + currentB.value;
          if (sumValue != 0) {
            resultMatrix.insert(currentA.row, currentA.column, sumValue);
          }
          currentA = currentA.right;
          currentB = currentB.right;
        }
      }

      currentRowHeaderA = currentRowHeaderA.down;
      currentRowHeaderB = currentRowHeaderB.down;
    }

    return resultMatrix;
  }

  public SparseMatrix multiply(SparseMatrix other) {
    if (this.numCols != other.numRows) {
      System.err.println(
          "Error: The number of columns in the first matrix must be equal to the number of rows in the second for multiplication.");
      return null;
    }

    SparseMatrix resultMatrix = new SparseMatrix(this.numRows, other.numCols);

    Cell currentRowHeaderA = this.mainHeader.down;
    for (int i = 1; i <= this.numRows; i++) {
      Cell currentColHeaderB = other.mainHeader.right;

      for (int j = 1; j <= other.numCols; j++) {
        Cell currentA = currentRowHeaderA.right;
        Cell currentB = currentColHeaderB.down;
        float dotProduct = 0;

        while (currentA != currentRowHeaderA && currentB != currentColHeaderB) {
          if (currentA.column < currentB.row) {
            currentA = currentA.right;
          } else if (currentB.row < currentA.column) {
            currentB = currentB.down;
          } else {
            dotProduct += currentA.value * currentB.value;
            currentA = currentA.right;
            currentB = currentB.down;
          }
        }

        if (dotProduct != 0) {
          resultMatrix.insert(i, j, dotProduct);
        }

        currentColHeaderB = currentColHeaderB.right;
      }
      currentRowHeaderA = currentRowHeaderA.down;
    }

    return resultMatrix;
  }
}