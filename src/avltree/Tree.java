package avltree;

public interface Tree {

    void printInOrder(Node root);
    Node treeSearch(Node root, int key);
    Node treeMinimum(Node root);
    Node treeSuccessor(Node node);

}
