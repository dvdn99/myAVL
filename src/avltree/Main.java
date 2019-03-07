package avltree;


public class Main {

	public static void main(String[] args) {
		AVLTree t1 = new AVLTree();

		//test line

		t1.avlInsert(5);
		t1.avlInsert(1);
		t1.avlInsert(19);
		t1.avlInsert(3);
		t1.avlInsert(8);
		t1.avlInsert(22);
		t1.avlInsert(10);
		
		//print avl tree in order
		t1.printInOrder(t1.getRoot());
		
		//searching node & printing overriding toString()
		BTNode node = t1.treeSearch(t1.getRoot(), 22);
		System.out.println();
		System.out.println(node);
		
		//deleting some elements
		t1.avlDelete(55);  //trying to delete a non-exist element
		t1.avlDelete(8);
		t1.avlDelete(1);
		t1.avlDelete(19);
		//t1.avlDelete(22);
		//t1.avlDelete(10);
		t1.printInOrder(t1.getRoot());
		
	}

}
