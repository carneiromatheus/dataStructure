package dev.matheuscarneiro.structure.tree;

public class TestBinaryTree {
    
    public static void main(String[] args) {
        System.out.println("=== Teste da Árvore Binária ===\n");
        
        // Criando a árvore
        BinaryTree tree = new BinaryTree();
        
        // Inserindo elementos
        System.out.println("Inserindo elementos: 50, 30, 70, 20, 40, 60, 80");
        tree.setLeaf(new Leaf(50));
        tree.setLeaf(new Leaf(30));
        tree.setLeaf(new Leaf(70));
        tree.setLeaf(new Leaf(20));
        tree.setLeaf(new Leaf(40));
        tree.setLeaf(new Leaf(60));
        tree.setLeaf(new Leaf(80));
        
        System.out.println("\n--- Estado inicial da árvore ---");
        System.out.print("Travessia InOrder: ");
        tree.inOrder();
        System.out.print("\nTravessia PreOrder: ");
        tree.preOrder();
        System.out.print("\nTravessia PostOrder: ");
        tree.postOrder();
        
        // Testando busca
        System.out.println("\n--- Testando busca ---");
        System.out.println("Buscar 40: " + tree.search(40));
        System.out.println("Buscar 25: " + tree.search(25));
        
        // Testando remoção - Caso 1: Nó folha
        System.out.println("\n--- Removendo nó folha (20) ---");
        tree.remove(20);
        System.out.print("InOrder após remoção: ");
        tree.inOrder();
        System.out.println();
        
        // Testando remoção - Caso 2: Nó com um filho
        System.out.println("\n--- Removendo nó com um filho (80) ---");
        tree.remove(80);
        System.out.print("InOrder após remoção: ");
        tree.inOrder();
        System.out.println();
        
        // Inserindo mais um elemento para testar remoção com dois filhos
        tree.setLeaf(new Leaf(35));
        tree.setLeaf(new Leaf(45));
        System.out.println("\n--- Adicionando 35 e 45 ---");
        System.out.print("InOrder: ");
        tree.inOrder();
        System.out.println();
        
        // Testando remoção - Caso 3: Nó com dois filhos
        System.out.println("\n--- Removendo nó com dois filhos (30) ---");
        tree.remove(30);
        System.out.print("InOrder após remoção: ");
        tree.inOrder();
        System.out.println();
        
        // Testando remoção da raiz
        System.out.println("\n--- Removendo a raiz (50) ---");
        tree.remove(50);
        System.out.print("InOrder após remoção da raiz: ");
        tree.inOrder();
        System.out.println();
        
        // Testando remoção de elemento inexistente
        System.out.println("\n--- Tentando remover elemento inexistente (100) ---");
        tree.remove(100);
    }
}
