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
		boolean retVal = false;
		if (o instanceof BinaryTree<?>) {
			BinaryTree<T> other = (BinaryTree<T>) o;
			retVal = this.root.equals(other.root);
		}
		return retVal;
	}

	public BinaryTree<T> deepCopy() {
		BinaryTreeNode<T> newRoot = root.deepCopy();
		BinaryTree<T> newTree = new BinaryTree<T>(newRoot);
		return newTree;
	}

	// This method should be in BinaryTree.java and
	// not in BinaryTreeNode.java
	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t,
			boolean left) {
		// Create OWN (deep) copy of node 'newRoot', tree 't', 
		// and calling tree 'this'
		BinaryTreeNode<T> thisNewRoot = newRoot.deepCopy();
		BinaryTree<T> callingTree = this.deepCopy();
		BinaryTree<T> passingTree = t.deepCopy();
		if (left) {  //determine which tree goes on the left and the right
			thisNewRoot.setLeft(callingTree.root);
			thisNewRoot.setRight(passingTree.root);
		} else {
			thisNewRoot.setLeft(passingTree.root);
			thisNewRoot.setRight(callingTree.root);
		}
		// return a tree with thisNewRoot as it's root 
		// remember: BinaryTree<T> return type
		return new BinaryTree<T>(thisNewRoot);
	}

	public int size() {
		int size = 0;
		if (this.root != null) {
			size = root.size();
		}
		return size;
	}

	public int height() {
		int height = 0;
		if (root != null) {
			height = root.height();
		}
		return height;
	}

	public boolean full() {
		boolean retVal = true;
		if (this.root != null) {
			retVal = root.full();
		}
		return retVal;
	}

	public void mirror() {
		if (root != null) {
			root.mirror();
		}
	}

	public String inOrder() {
		if (root != null) {
			return root.inOrder();
		} else {
			return null;
		}
	}

}
