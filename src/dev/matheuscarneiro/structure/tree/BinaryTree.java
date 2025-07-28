package dev.matheuscarneiro.structure.tree;

public class BinaryTree {

  private Leaf leaf;
  private BinaryTree left;
  private BinaryTree right;

  public BinaryTree() {
    this.leaf = null;
    this.left = null;
    this.right = null;
  }

  public BinaryTree(Leaf newLeaf) {
    this.leaf = newLeaf;
    this.left = null;
    this.right = null;
  }

  public boolean isEmpty() {
    return this.leaf == null;
  }

  public void setLeaf(Leaf newLeaf) {
    if (this.isEmpty()) {
      this.leaf = newLeaf;
    } else {
      BinaryTree newTree = new BinaryTree(newLeaf);
      if (newLeaf.getValue() < this.leaf.getValue()) {
        if (this.left == null) {
          this.left = newTree;
          System.out.println("Leaf " + newLeaf.getValue() + " to the left of " + this.leaf.getValue() + ".");
        } else {
          this.left.setLeaf(newLeaf);
        }
      } else if (newLeaf.getValue() > this.leaf.getValue()) {
        if (this.right == null) {
          this.right = newTree;
          System.out.println("Leaf " + newLeaf.getValue() + " to the right of " + this.leaf.getValue() + ".");
        } else {
          this.right.setLeaf(newLeaf);
        }
      } else {
        System.out.println("Element " + newLeaf.getValue() + " already exists in the tree.");
      }
    }
  }

  public void inOrder() {
    if (!this.isEmpty()) {
      if (this.left != null) {
        this.left.inOrder();
      }
      System.out.print(this.leaf.getValue() + " ");
      if (this.right != null) {
        this.right.inOrder();
      }
    }
  }

  public void postOrder() {
    if (!this.isEmpty()) {
      if (this.left != null) {
        this.left.postOrder();
      }
      if (this.right != null) {
        this.right.postOrder();
      }
      System.out.print(this.leaf.getValue() + " ");
    }
  }

  public void preOrder() {
    if (!this.isEmpty()) {
      System.out.print(this.leaf.getValue() + " ");
      if (this.left != null) {
        this.left.preOrder();
      }
      if (this.right != null) {
        this.right.preOrder();
      }
    }
  }

  public boolean search(int value) {
    if (this.isEmpty()) {
      return false;
    }

    if (value == this.leaf.getValue()) {
      return true;
    } else if (value < this.leaf.getValue()) {
      return this.left != null && this.left.search(value);
    } else {
      return this.right != null && this.right.search(value);
    }
  }

  public BinaryTree removeLeaf(int value) {
    if (this.isEmpty()) {
      System.out.println("Element " + value + " not found in the tree.");
      return this;
    }

    if (value < this.leaf.getValue()) {
      if (this.left != null) {
        this.left = this.left.removeLeaf(value);
      } else {
        System.out.println("Element " + value + " not found in the tree.");
      }
    } else if (value > this.leaf.getValue()) {
      if (this.right != null) {
        this.right = this.right.removeLeaf(value);
      } else {
        System.out.println("Element " + value + " not found in the tree.");
      }
    } else {
      System.out.println("Element " + value + " removed from the tree.");

      if (this.left == null && this.right == null) {
        return null;
      } else if (this.left == null) {
        return this.right;
      } else if (this.right == null) {
        return this.left;
      } else {
        BinaryTree successor = findMinimum(this.right);
        this.leaf = successor.leaf;
        this.right = this.right.removeLeaf(successor.leaf.getValue());
      }
    }
    return this;
  }

  private BinaryTree findMinimum(BinaryTree node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  public void remove(int value) {
    BinaryTree result = this.removeLeaf(value);
    if (result == null) {
      this.leaf = null;
      this.left = null;
      this.right = null;
    }
  }
}
