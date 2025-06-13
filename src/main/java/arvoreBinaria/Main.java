package arvoreBinaria;

public class Main {
    public static void main(String[] args) {

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

        // Removendo nós pares e atualizar a raiz
        tree = tree.removePairs(tree);
        System.out.print("5) Sem nós pares: ");
        tree.printNodes(tree);
    }
}