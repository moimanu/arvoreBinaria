package arvoreBinaria;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int valor){
        this.value = valor;
        this.left = null;
        this.right = null;
    }

    public Node insertNode (int value, Node no) {
        if(no == null) {
            no = new Node(value);
            return no;
        }

        if(value < no.value) {
            no.left = insertNode(value, no.left);
            return no;
        } else {
            if(value > no.value) {
                no.right = insertNode(value, no.right);
                return no;
            }
        }
        return no;
    }

    public void printNodes(Node no) {
        if(no != null) {
            printNodes(no.left);
            System.out.print(no.value + " ");
            printNodes(no.right);
        }
    }

    //------------------LISTA 2------------------//

    //1 - Função não recursiva que retorna o menor valor de uma ABB
    public int findSmaller(Node no) {
        if (no == null) throw new IllegalArgumentException("A árvore está vazia.");
        int smaller = no.value;
        while (no.left != null) {
            no = no.left;
            smaller = no.value;
        }
        return smaller;
    }

    //2 - Funções Pre e Pos Orders

    public void printNodesPreOrder(Node no) {
        if(no != null) {
            System.out.print(no.value + " ");
            printNodes(no.left);
            printNodes(no.right);
        }
    }

    public void printNodesPosOrder(Node no) {
        if(no != null) {
            printNodes(no.left);
            printNodes(no.right);
            System.out.print(no.value + " ");
        }
    }

    //3 - Função que remove um nó
    public Node removeNode(Node no, int value) {
        if (no == null) return null;

        if (value < no.value) {
            no.left = removeNode(no.left, value);
        } else if (value > no.value) {
            no.right = removeNode(no.right, value);
        } else {
            // Caso 1: sem filhos ou um filho só
            if (no.left == null) return no.right;
            if (no.right == null) return no.left;

            // Caso 2: dois filhos
            // Substitui pelo menor valor da subárvore direita (sucessor)
            Node temp = findMin(no.right);
            no.value = temp.value;
            no.right = removeNode(no.right, temp.value);
        }

        return no;
    }

    private Node findMin(Node no) {
        while (no.left != null) {
            no = no.left;
        }
        return no;
    }

    //5 - Função para imprimir os caminhos até um nó
    public void findPaths(Node node, List<Integer> currentPath) {
        if (node == null) return;

        currentPath.add(node.value);

        if (node.left == null && node.right == null) {
            System.out.println(currentPath);
        } else {
            findPaths(node.left, new ArrayList<>(currentPath));
            findPaths(node.right, new ArrayList<>(currentPath));
        }
    }

    //6 - Função que conta o número de nós em níveis ímpares em uma ABB simples 
    public int countOddNodes (Node no) {
        if (no == null) return 0;
        if (((no.value % 2) != 0)) return 1;
        return countOddNodes(no.left) + countOddNodes(no.right);
    }

    //------------------LISTA 1------------------//

    //1 - Função que conta o número de nós não folhas em uma ABB simples
    public int countInternNodes(Node no) {
        if (no == null) return 0;
        if (no.left == null && no.right == null) return 0;
        return 1 + countInternNodes(no.left) + countInternNodes(no.right);
    }

    //2 - Função que conta o número de nós folhas em uma ABB simples
    public int countLeaves (Node no) {
        if (no == null) return 0;
        if (no.left == null && no.right == null) return 1;
        return countLeaves(no.left) + countLeaves(no.right);
    }

    //3 - Função que calcula a altura de uma árvore
    public int calculateHeight(Node no) {
        if (no == null) return -1;
        int heightLeft = calculateHeight(no.left);
        int heightRight = calculateHeight(no.right);
        return 1 + Math.max(heightLeft, heightRight);
    }

    //4 - Função que remove todos os nós com chave par
    public Node removePairs(Node no) {
        if (no == null) return null;

        no.left = removePairs(no.left);
        no.right = removePairs(no.right);

        if (no.value % 2 == 0) {
            if (no.left == null) return no.right;
            if (no.right == null) return no.left;

            Node temp = no.right;
            while (temp.left != null) temp = temp.left;
            temp.left = no.left;
            return no.right;
        }

        return no;
    }

    //5 - Função que encontra o maior número em uma ABB.
    public Integer findBigger(Node no) {
        if (no == null) { return null; }
        while (no.right != null) { no = no.right; }
        return no.value;
    }
}
