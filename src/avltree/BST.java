package avltree;

public class BST implements Tree {

    //properties

    protected Node root;

    //constructor

    public BST() {
        this.root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    //Binary Search Tree insert method

    public Node insert(int data) {

        Node insertNode = new Node(data);
        Node parentNode = null;
        Node tempNode = this.root;

        while (tempNode != null) {
            parentNode = tempNode;
            if (insertNode.getData() < tempNode.getData())
                tempNode = tempNode.getLeft();
            else
                tempNode = tempNode.getRight();
        }

        insertNode.setParent(parentNode);

        if (parentNode == null) {
            this.root = insertNode;
        } else if (insertNode.getData() < parentNode.getData())
            parentNode.setLeft(insertNode);
        else
            parentNode.setRight(insertNode);

        return insertNode;
    }

    //Binary Search Tree delete method

    public Node delete(int data) {
        return null;
    }

    @Override
    public Node treeSearch(Node root, int key) {
        if (root == null || root.getData() == key)
            return root;
        if (key < root.getData())
            return treeSearch(root.getLeft(), key);
        else
            return treeSearch(root.getRight(), key);
    }

    @Override
    public Node treeMinimum(Node node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

    @Override
    public Node treeSuccessor(Node node) {
        if (node.getRight() != null)
            return treeMinimum(node.getRight());
        Node parentNode = node.getParent();
        while (parentNode != null && node == parentNode.getRight()) {
            node = parentNode;
            parentNode = parentNode.getParent();
        }
        return parentNode;
    }

    @Override
    public void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.getLeft());
            System.out.print(root + " ");
            System.out.println("Balance Factor: " + root.getBalanceFactor());
            printInOrder(root.getRight());
        }
    }
}