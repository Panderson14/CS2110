/*
 * @author Patrick Anderson psa5dg
 * Homework 4
 * Lab 102
*/

public class BinaryTree<T> {
	
	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof BinaryTree) {
			
			@SuppressWarnings("unchecked")
			BinaryTree<T> a = (BinaryTree<T>) o;
			if (!this.root.equals(null) && !a.getRoot().equals(null)) {
				if (this.root.equals(a.getRoot())) {
					return true;
				}
			}
			if (this.root.equals(null) && a.getRoot().equals(null)) return true;
		}
		return false;
	}

	public BinaryTree<T> deepCopy() {
		BinaryTree<T> a = new BinaryTree<T>();
		a.setRoot(this.root);
		return a;
	}

	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t,
			boolean left) {
		BinaryTree<T> a = new BinaryTree<T>();
		a.setRoot(newRoot);
		if (left) {
			a.getRoot().setLeft(this.root);
			a.getRoot().setRight(t.getRoot());
			return a;
		}
		a.getRoot().setRight(this.root);
		a.getRoot().setLeft(t.getRoot());
		return a;
	}
	
	public int size(){
		return this.root.size() + 1;
	}
	
	public int height(){
		return 0;
	}
	
	public boolean full(){
		return false;
	}
	
	public void mirror(){
		//To do
	}
	
	public String inOrder(){
		return "";
	}
}
