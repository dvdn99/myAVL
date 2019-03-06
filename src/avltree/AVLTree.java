package avltree;


class AVLTree {
	private BTNode root;

	public AVLTree() {
		root = null;
	}

	////////building an AVL Tree that balance itself
	public void avlInsert(int data) {
		//first we use bst insert function
		BTNode temp = treeInsert(data);
		
		//now we check every node balance factor until root
		int bfactor;
		while(temp.parent != null) {
			//check node balance factor and rotate if necessary
			bfactor = temp.getBalanceFactor();
			if(bfactor == 2) {
				rightRotate(temp);
			}else if(bfactor == -2) {
				leftRotate(temp);
			}
			temp = temp.parent;
		}
	}	
	///////////////////////////////////////


	//////AVL delete function, tree balance itself
	public void avlDelete(int data) {
		//first we use bst delete function
		BTNode temp = treeDelete(data);
		
		//if item wasn't found return
		if(temp == null)
			return;
		
		//now we check every node balance factor until root
		int bfactor;
		while(temp.parent != null) {
			//check node balance factor and rotate if necessary
			bfactor = temp.getBalanceFactor();
			if(bfactor == 2) {
				rightRotate(temp);
			}else if(bfactor == -2) {
				leftRotate(temp);
			}
			temp = temp.parent;
		}

	}
	/////////////////////////////


	/////Binary Search Tree delete function
	public BTNode treeDelete(int data) {
		BTNode dnode = treeSearch(root,data);
		if(dnode == null) {
			System.out.println(data+" Wasn't Found on this AVL Tree");
			return dnode;
		}

		BTNode y;
		if(dnode.left == null || dnode.right == null)
			y = dnode;
		else y = treeSuccessor(dnode);

		BTNode x;
		if(y.left != null)
			x = y.left;
		else x = y.right;

		if(x != null)
			x.parent = y.parent;

		if(y.parent == null)
			root = x;
		else if( y == y.parent.left)
			y.parent.left = x;
		else y.parent.right = x;

		if(y != dnode)
			dnode.setData(y.getData());

		return y;
	}
	///////////////////

	/////Binary Search Tree insert function
	public BTNode treeInsert(int data) {
		BTNode newNode = new BTNode(data);
		BTNode y = null;
		BTNode x = this.root;
		while(x!=null) {
			y=x;
			if(newNode.getData()<x.getData())
				x = x.left;
			else x=x.right;
		}

		newNode.parent = y;

		if (y==null) {
			this.root = newNode;
		}else if(newNode.getData()<y.getData())
			y.left = newNode;
		else y.right = newNode;

		return newNode;
	}
	///////////////////////////////////////////

	public BTNode getRoot() {
		return root;
	}

	public void setRoot(BTNode node) {
		root = node;
	}
	
	// inOrder Print function
	public void printInOrder(BTNode node){
		if(node!=null) {
			printInOrder(node.left);
			System.out.print(node.getData()+" ");
			System.out.println("Balance Factor: "+node.getBalanceFactor());
			printInOrder(node.right);
		}
	}

	//left rotate function
	public void leftRotate(BTNode node) {
		BTNode y = node.right;
		node.right = y.left;
		if(y.left != null) {
			y.left.parent = node;
		}
		y.parent = node.parent;
		if(node.parent == null)
			root = y;
		else if(node == node.parent.left)
			node.parent.left = y;
		else node.parent.right = y;
		y.left = node;
		node.parent = y;
	}
	///////

	//right rotate function
	public void rightRotate(BTNode node) {
		BTNode y = node.left;
		node.left = y.right;
		if(y.right != null) {
			y.right.parent = node;
		}
		y.parent = node.parent;
		if(node.parent == null)
			root = y;
		else if(node == node.parent.right)
			node.parent.right = y;
		else node.parent.left = y;
		y.right = node;
		node.parent = y;
	}
	//////////

	//BST search
	public BTNode treeSearch(BTNode node, int key) {
		if(node == null || node.getData() == key)
			return node;
		if(key < node.getData())
			return treeSearch(node.left,key);
		else 
			return treeSearch(node.right,key);
	}
	/////////////
	///Tree minimum function
	public BTNode treeMinimum(BTNode node) {
		while(node.left != null)
			node = node.left;
		return node;
	}
	///////////////////
	///BST successor function
	public BTNode treeSuccessor(BTNode node) {
		if(node.right != null)
			return treeMinimum(node.right);
		BTNode y = node.parent;
		while(y != null && node == y.right) {
			node = y;
			y = y.parent;
		}
		return y;
	}
	///////////////////////////
}


///////////Binary Tree Node class////////////
class BTNode{
	private int data;
	BTNode left;
	BTNode right;
	BTNode parent;


	public BTNode(int data) {
		this.data = data;
		left = null;
		right = null;
		parent = null;
	}

	public int getData() {
		return data;
	}
	public void setData(int d) {
		data = d;
	}
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
		String msg = data+" ";
		return msg;
	}
}
/////////////////////////////////////////////////////////