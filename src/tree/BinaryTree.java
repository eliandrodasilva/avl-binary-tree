package tree;

public class BinaryTree {
    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value) {
            this.value = value;
            this.height = 0;
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
        updateHeight(node);
        return rebalance(node);
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

    private int height(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    private void updateHeight(Node node) {
        int left = 1 + height(node.left);
        int right = 1 + height(node.right);
        node.height = (left > right) ? left : right;
    }

    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private Node rebalance(Node node) {
        int bf = balanceFactor(node);
        if (bf < -1 && balanceFactor(node.right) <= 0) {
            return rotateLeft(node);
        }
        if (bf > 1 && balanceFactor(node.left) >= 0) {
            return rotateRight(node);
        }
        if (bf < -1 && balanceFactor(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        if (bf > 1 && balanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        return node;
    }

    private Node rotateLeft(Node node) {
        Node newNode = node.right;
        Node leftRight = newNode.left;

        newNode.left = node;
        node.right = leftRight;

        updateHeight(node);
        updateHeight(newNode);

        return newNode;
    }

    private Node rotateRight(Node node) {
        Node newNode = node.left;
        Node rightLeft = newNode.right;

        node.left = rightLeft;
        newNode.right = node;

        updateHeight(node);
        updateHeight(newNode);

        return newNode;
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
        System.out.print("Largura: " + largura);
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
        System.out.print("Altura: " + altura);
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
        if (node == null) return;

        if (node.left == null && node.right == null) {
            System.out.print(node.value + " - ");
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

    private void printTree(Node node, int nivel) {
        if (node == null) return;
        printTree(node.right, nivel + 1);
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(node.value+"("+node.height+"/"+balanceFactor(node)+")");
        printTree(node.left, nivel + 1);
    }
}
