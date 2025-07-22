package dev.matheuscarneiro.tp.sparse_matrix.test;

import dev.matheuscarneiro.tp.sparse_matrix.SparseMatrix;

public class TestSparseMatrix {

  public static void main(String[] args) {
    String inputA = "4,4\n" +
        "1,1,50.0\n" +
        "2,1,10.0\n" +
        "2,3,20.0\n" +
        "4,1,-30.0\n" +
        "4,3,-60.0\n" +
        "4,4,5.0";

    String inputB = "4,4\n" +
        "1,1,50.0\n" +
        "1,2,30.0\n" +
        "2,1,10.0\n" +
        "2,3,-20.0\n" +
        "4,4,-5.0";

    String inputC = "2,3\n" +
        "1,1,3.0\n" +
        "2,2,-1.0";

    System.out.println("--- Loading and Printing Matrix A ---");
    SparseMatrix matrixA = new SparseMatrix(4, 4);
    matrixA.readFromString(inputA);
    matrixA.printMatrix();

    System.out.println("\n--------------------------------------\n");

    System.out.println("--- Loading and Printing Matrix B ---");
    SparseMatrix matrixB = new SparseMatrix(4, 4);
    matrixB.readFromString(inputB);
    matrixB.printMatrix();

    System.out.println("\n--------------------------------------\n");

    System.out.println("--- Loading and Printing Matrix C ---");
    SparseMatrix matrixC = new SparseMatrix(2, 3);
    matrixC.readFromString(inputC);
    matrixC.printMatrix();

    System.out.println("\n--------------------------------------\n");

    System.out.println("--- Testing Matrix Sum (A + B) ---");
    SparseMatrix matrixSum = matrixA.sum(matrixB);
    if (matrixSum != null) {
      matrixSum.printMatrix();
    }

    System.out.println("\n--------------------------------------\n");

    System.out.println("--- Testing Matrix Multiplication (A * B) ---");
    SparseMatrix matrixProductAB = matrixA.multiply(matrixB);
    if (matrixProductAB != null) {
      matrixProductAB.printMatrix();
    }

    System.out.println("\n--------------------------------------\n");

    System.out.println("--- Testing Matrix Multiplication (B * B) ---");
    SparseMatrix matrixProductBB = matrixB.multiply(matrixB);
    if (matrixProductBB != null) {
      matrixProductBB.printMatrix();
    }
  }
}