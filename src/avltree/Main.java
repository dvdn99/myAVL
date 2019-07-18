/*
*  AVL Tree code
*
*  Author: David Novizky :)
*
*
*
* */



package avltree;


public class Main {

	public static void main(String[] args) {
		AVLTree myTree = new AVLTree();

		//test line
		System.out.println("\nTesting AVL Tree \n");

		myTree.avlInsert(5);
		myTree.avlInsert(1);
		myTree.avlInsert(19);
		myTree.avlInsert(3);
		myTree.avlInsert(8);
		myTree.avlInsert(22);
		myTree.avlInsert(10);
		
		//print avl tree in order
		System.out.println("In Order Print: ");
		myTree.printInOrder(myTree.getRoot());
		
		//searching node & printing overriding toString()
		Node node = myTree.treeSearch(myTree.getRoot(), 22);
		System.out.println();
		System.out.println(node + " Found!");
		
		//deleting some elements
		myTree.avlDelete(55);  //trying to delete a non-exist element
		myTree.avlDelete(8);
		myTree.avlDelete(1);
		myTree.avlDelete(19);
		//myTree.avlDelete(22);
		//myTree.avlDelete(10);

		//print avl tree in order
		System.out.println("\nIn Order Print after some deletions: ");
		myTree.printInOrder(myTree.getRoot());
		
	}

}
