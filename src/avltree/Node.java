package avltree;

public class Node {

    //properties => data + children + parent

    private int data;
    private Node left;
    private Node right;
    private Node parent;

    //constructor

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    //getters & setters

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int d) {
        data = d;
    }

    //complementary methods

    public int getBalanceFactor() {
        if(left == null && right == null)
            return 0;
        else if(left == null && right != null)
            return 0 - (right.height() + 1);
        else if(left != null && right == null)
            return left.height() + 1;
        else
            return left.height() - right.height();
    }

    public int height() {
        int res = 0;
        if(left != null) res = left.height() + 1;
        if(right != null)
            res = Math.max(res, right.height() + 1);
        return res;
    }

    public String toString() {
        String msg = "{"+data+"} ";
        return msg;
    }

}
