/*
 * @author Patrick Anderson psa5dg
 * Homework 4
 * Lab 102
*/

public class BinaryTreeNode<T> {
	
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;
	
	public BinaryTreeNode(){
		this(null,null,null);
	}
	
	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}
	
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}
	
	public int size(){
		int size = 0; //the size of the tree
		
		//The size of the tree rooted at this node is one more than the
		//sum of the sizes of its children.
		if(left != null){
			size = size + left.size();
		}
		if(right != null){
			size = size + right.size();
		}
		return size + 1; //add one to account for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	public BinaryTreeNode<T> deepCopy(){
		BinaryTreeNode<T> a = new BinaryTreeNode<T>();	
		a.setData(this.data);
		a.setLeft(this.left);
		a.setRight(this.right);
		return a;
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof BinaryTreeNode) {
			@SuppressWarnings("unchecked")
			BinaryTreeNode<T> a = (BinaryTreeNode<T>) o;
//			if (this.left.equals(a.getLeft()) && this.right.equals(a.getRight()) && this.data.equals(a.getData())) {
//				return true;
//			}
		}
		return false;
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
