package avltree;


class AVLTree extends BST {

	//the root property is inherited

	//constructor

	public AVLTree() {
		this.root = null;
	}

	////////building an AVL Tree that balance itself
	public void avlInsert(int data) {
		//first we use bst insert function
		Node temp = insert(data);

		checkBalance(temp);

		System.out.println(data + " added successfully!" );
	}
	///////////////////////////////////////


	//////AVL delete function, tree balance itself
	public void avlDelete(int data) {
		//first we use bst delete function
		Node temp = treeDelete(data);

		//if item wasn't found return
		if (temp == null)
			return;

		checkBalance(temp);

		System.out.println(data + " deleted successfully!" );

	}
	/////////////////////////////


	/////Binary Search Tree delete function
	public Node treeDelete(int data) {
		Node dnode = treeSearch(root, data);
		if (dnode == null) {
			System.out.println("Node {" + data + "} Wasn't Found on this AVL Tree");
			return dnode;
		}

		Node y;
		if (dnode.getLeft() == null || dnode.getRight() == null)
			y = dnode;
		else y = treeSuccessor(dnode);

		Node x;
		if (y.getLeft() != null)
			x = y.getLeft();
		else x = y.getRight();

		if (x != null)
			x.setParent(y.getParent());

		if (y.getParent() == null)
			root = x;
		else if (y == y.getParent().getLeft())
			y.getParent().setLeft(x);
		else y.getParent().setRight(x);

		if (y != dnode)
			dnode.setData(y.getData());

		return y;
	}
	///////////////////

	/////Binary Search Tree insert function

	///////////////////////////////////////////

	public Node getRoot() {
		return root;
	}

	// inOrder Print function


	//left rotate function
	private void leftRotate(Node node) {
		Node y = node.getRight();
		node.setRight( y.getLeft());
		if (y.getLeft() != null) {
			y.getLeft().setParent(node);
		}
		y.setParent(node.getParent());
		if (node.getParent() == null)
			root = y;
		else if (node == node.getParent().getLeft())
			node.getParent().setLeft(y);
		else node.getParent().setRight(y);
		y.setLeft(node);
		node.setParent(y);
	}
	///////

	//right rotate function
	private void rightRotate(Node node) {
		Node y = node.getLeft();
		node.setLeft(y.getRight());
		if (y.getRight() != null) {
			y.getRight().setParent(node);
		}
		y.setParent(node.getParent());
		if (node.getParent() == null)
			root = y;
		else if (node == node.getParent().getRight())
			node.getParent().setRight(y);
		else node.getParent().setLeft(y);
		y.setRight(node);
		node.setParent(y);
	}
	//////////

	private void checkBalance(Node node){
		//now we check every node balance factor until root
		int balanceFactor;
		while (node.getParent() != null) {
			//check node balance factor and rotate if necessary
			balanceFactor = node.getBalanceFactor();
			if (balanceFactor == 2) {
				rightRotate(node);
			} else if (balanceFactor == -2) {
				leftRotate(node);
			}
			node = node.getParent();
		}
	}

}