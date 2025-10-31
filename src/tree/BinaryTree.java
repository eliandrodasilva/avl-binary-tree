package tree;

public class BinaryTree {
    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        if (root == null) return true;
        return false;
    }

    public void add(int value) {
        root = add(root, value);
    }

    private Node add(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else {
            if (value < node.value) {
                node.left = add(node.left, value);
            } else {
                node.right = add(node.right, value);
            }
        }
        return node;
    }

    public void remove(int value) {
        root = remove(root, value);
    }

    private Node remove(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = remove(node.left, value);
        } else if (value > node.value) {
            node.right = remove(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node minRight = min(node.right);
            node.value = minRight.value;
            node.right = remove(node.right, minRight.value);
        }
        return node;
    }

    private Node min(Node node) {
        Node temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public void nodeQuantity() {
        int quantity = nodeQuantity(root);
        System.out.println("Node quantity: " + quantity);
    }

    private int nodeQuantity(Node node) {
        if (node == null) return 0;
        int leftCount = nodeQuantity(node.left);
        int rightCount = nodeQuantity(node.right);
        return 1 + leftCount + rightCount;
    }


    public boolean treeSearch(int value) {
        Node node = root;
        while (node != null) {
            if (node.value == value) return true;
            node = value < node.value ? node.left : node.right;
        }
        return false;
    }

    public void treeWidth() {
        int largura = treeWidth(root);
        System.out.print("Largura: "+largura);
        System.out.println();
    }

    private int treeWidth(Node node) {
        if (node == null) {
            return 0;
        }


        if (node.left == null && node.right == null) {
            return 1;  // Conta este nó como uma folha
        }

        int leftLeaves = treeWidth(node.left);
        int rightLeaves = treeWidth(node.right);

        return leftLeaves + rightLeaves;
    }

    public void treeHeight() {
        int altura = treeHeight(root);
        System.out.print("Altura: "+altura);
        System.out.println();
    }

    private int treeHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = treeHeight(node.left);
        int rightHeight = treeHeight(node.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    public void printLeafs() {
        System.out.print("Folhas: ");
        printLeafs(root);
        System.out.println();
    }

    private void printLeafs(Node node) {
        if(node == null) return;

        if(node.left == null && node.right == null) {
            System.out.print(node.value+" - ");
        }

        printLeafs(node.left);
        printLeafs(node.right);
    }

    public void printPre() {
        System.out.print("Pré: ");
        printPre(root);
        System.out.println();
    }

    private void printPre(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " - ");
        printPre(node.left);
        printPre(node.right);
    }

    public void printIn() {
        System.out.print("In: ");
        printIn(root);
        System.out.println();
    }

    private void printIn(Node node) {
        if (node == null) {
            return;
        }
        printIn(node.left);
        System.out.print(node.value + " - ");
        printIn(node.right);
    }

    public void printPos() {
        System.out.print("Pós: ");
        printPos(root);
        System.out.println();
    }

    private void printPos(Node node) {
        if (node == null) {
            return;
        }
        printPos(node.left);
        printPos(node.right);
        System.out.print(node.value + " - ");
    }

    public void printTree() {
        printTree(root, 0);
        System.out.println("\n-------------------------------------------\n");

    }

    private void printTree(Node root, int nivel) {
        if (root == null) return;
        printTree(root.right, nivel + 1);
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(root.value);
        printTree(root.left, nivel + 1);
    }
}
