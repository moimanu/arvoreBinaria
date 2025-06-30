package arvoreBinaria;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Exercício de iteratividade
    public static void listaExercicioDois() {

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

        System.out.println("Questão 1)");

        // Encontrando o menor valor na árvore
        System.out.println("Menor valor da árvore: " + tree.findSmaller(tree));

        System.out.print("\nQuestão 2)");

        // Print In Order
        System.out.print("\nInOrder: ");
        tree.printNodes(tree);

        // Print Pre Order
        System.out.print("\nPreOrder: ");
        tree.printNodesPreOrder(tree);

        // Print Pos Order
        System.out.print("\nPosOrder: ");
        tree.printNodesPosOrder(tree);

        System.out.print("\n\nQuestão 3)");

        // Criando nova árvore (QUESTÃO 3)
        Node treeQ3 = new Node(7);

        // Inserindo nós
        tree.insertNode(8, treeQ3);
        tree.insertNode(4, treeQ3);
        tree.insertNode(3, treeQ3);
        tree.insertNode(2, treeQ3);
        tree.insertNode(1, treeQ3);
        tree.insertNode(6, treeQ3);
        tree.insertNode(5, treeQ3);

        // Print In Order
        System.out.print("\nInOrder: ");
        tree.printNodes(tree);

        // Print Pre Order
        System.out.print("\nPreOrder: ");
        tree.printNodesPreOrder(tree);

        // Print Pos Order
        System.out.print("\nPosOrder: ");
        tree.printNodesPosOrder(tree);

        // Removendo 7 e 6
        treeQ3.removeNode(treeQ3, 7);
        treeQ3.removeNode(treeQ3, 6);
        System.out.print("\nApós remoção: ");
        tree.printNodes(tree);

        // Imprimindo caminhos
        List<Integer> currentPath = new ArrayList<>();
        System.out.print("\n\nQuestão 5) Caminhos até as folhas: \n");
        treeQ3.findPaths(treeQ3, currentPath);

        // Imprimindo quantidade de nós em níveis ímpares
        System.out.print("\n\nQuestão 6) \nQntd de nós em níveis ímpares: ");
        System.out.println("" + treeQ3.countOddNodes(treeQ3));
    }

    //Exercício de recursividade
    public static void listaExercicioUm() {

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
        listaExercicioDois();
    }
}