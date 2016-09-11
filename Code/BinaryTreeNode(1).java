
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
	
	public int size(){
		int size = 0; //the size of the tree (number of nodes in the tree)
		
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
	
	
	public BinaryTreeNode<T> deepCopy(){
		BinaryTreeNode<T> copy = new BinaryTreeNode<T>(this.data);
		BinaryTreeNode<T> newLeft = null;
		BinaryTreeNode<T> newRight = null;
		if(this.left != null){
			newLeft = this.left.deepCopy();
			copy.setLeft(newLeft);
		}
		if(this.right != null){
			newRight = this.right.deepCopy();
			copy.setRight(newRight);
		}
		return copy;
		
	}
	
	
	@Override
	public boolean equals(Object o){
		boolean retVal = false;
		if(o instanceof BinaryTreeNode<?>){
			BinaryTreeNode<T> other = (BinaryTreeNode<T>)o;
			if(!(this.getData().equals(other.getData()))){
				return false;
			}
			boolean leftEqual = false;
			boolean rightEqual = false;
			if((this.getLeft() != null)&&(other.getLeft() != null)){
				leftEqual = this.getLeft().equals(other.getLeft());
			}
			if((this.getLeft() == null)&&(other.getLeft() == null)){
				leftEqual = true;
			}
			if((this.getRight() != null)&&(other.getRight() != null)){
				rightEqual = this.getRight().equals(other.getRight());
			}
			if((this.getRight() == null)&&(other.getRight() == null)){
				rightEqual = true;
			}
			retVal = leftEqual && rightEqual;
		}
		return retVal;
	}
	
	
	public int height(){
		int leftHeight = 0;
		int rightHeight = 0;
		int height = 0;
		
		if(this.left != null){
			leftHeight = this.left.height();
		}
		if(this.right != null){
			rightHeight = this.right.height();
		}
		if(leftHeight > rightHeight){  // select the maximum height
			height = 1 + leftHeight;
		}
		else{
			height = 1 + rightHeight;
		}
		return height;
	}
	
	public boolean full(){
		// apply the formula to determine if the tree is a full binary tree
		if(this.size()==Math.pow(2, this.height())-1){
			return true;
		}else{
			return false;
		}
	}
	
	
	public void mirror(){
		// Localized swap
		BinaryTreeNode<T> temp = this.left;	// temp = left child
		this.setLeft(this.getRight());		// left child = right child
		this.setRight(temp);			// right child = temp (left child)
		
		// Then call mirror on left and right children
		if(this.left != null){
			this.left.mirror();
		}
		if(this.right!= null){
			this.right.mirror();
		}
		
	}
	
	@Override
	public String toString(){
		return data.toString();
	}
	
	public String inOrder(){
		String s = "";
		if(this.left != null){					// left
			s = s + this.left.inOrder();
		}
		s = s + "(" + data.toString() + ")";	// print ("visit" node)
		if(this.right != null){
			s = s + this.right.inOrder();		// right
		}
		
		return s;
		
	}
	

}
