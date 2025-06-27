package arvoreBinaria;

public class Main {

    // Exercício de iteratividade
    public static void testesIterativos() {

        // Criando nova árvore
        Node tree = new Node(33);

        // Inserindo nós
        tree.insertNode(15, tree);
        tree.insertNode(41, tree);
        tree.insertNode(38, tree);
        tree.insertNode(34, tree);
        tree.insertNode(47, tree);
        tree.insertNode(43, tree);
        tree.insertNode(49, tree);

        // Encontrando o menor valor na árvore
        System.out.println(tree.findSmaller(tree));

        // Print In Order
        System.out.print("InOrder: ");
        tree.printNodes(tree);

        // Print Pre Order
        System.out.print("PreOrder: ");
        tree.printNodesPreOrder(tree);

        // Print Pos Order
        System.out.print("PosOrder: ");
        tree.printNodesPosOrder(tree);

    }

    //Exercício de recursividade
    public static void testesRecursivos() {

        /* Árvore:

            10
           /  \
          5    15
         / \   / \
        3   7 12 18

        */

        // Criando nova árvore
        Node tree = new Node(10);

        // Inserindo nós
        tree.insertNode(5, tree);
        tree.insertNode(15, tree);
        tree.insertNode(3, tree);
        tree.insertNode(7, tree);
        tree.insertNode(12, tree);
        tree.insertNode(18, tree);

        //Imprimindo nós
        System.out.print("Print InOrder: ");
        tree.printNodes(tree);

        //Contando nós (exceto folhas)
        System.out.println("\n1) Nós internos: " + tree.countInternNodes(tree));

        //Contando folhas
        System.out.println("2) Folhas: " + tree.countLeaves(tree));

        //Calculando a altura da árvore
        System.out.println("3) Altura: " + tree.calculateHeight(tree));

        //Encontrando o maior valor na árvore
        System.out.println("4) Maior valor: " + tree.findBigger(tree));

        //Removendo nós pares e atualizar a raiz
        tree = tree.removePairs(tree);
        System.out.print("5) Sem nós pares: ");
        tree.printNodes(tree);

    }

    public static void main(String[] args) {
        testesIterativos();
    }
}