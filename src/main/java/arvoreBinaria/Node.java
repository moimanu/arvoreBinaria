package arvoreBinaria;

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
