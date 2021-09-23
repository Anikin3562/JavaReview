
public class BinaryTree{ 

	TreeNode root; 

	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();

		tree.addNode(1,"1");
		tree.addNode(5,"5");
		tree.addNode(3, "3");

		System.out.println(tree.min());
		System.out.println(tree.search(5).key);

		tree.preorderTraversal(tree.root);
		System.out.println();
		tree.inorderTraversal(tree.root);
		System.out.println();
		tree.postorderTraversal(tree.root);
		System.out.println();

		tree.remove(1);
		tree.inorderTraversal(tree.root);
		System.out.println();


		
	}

	public void addNode(int key, String name){
		TreeNode newNode = new TreeNode(key, name);

		// First Node of Tree
		if(root == null)
			root = newNode; 

		else{
			TreeNode focus = root;
			TreeNode parent; 
			
			while(true){
				parent = focus;

				if(key < focus.key){
					focus = focus.leftChild; 

					// if focus is null, then newNode is the leftChild of the parent. 
					if(focus == null){
						parent.leftChild = newNode; 
						return;
					}
				}
				else{
					focus = focus.rightChild; 

					if(focus == null){
						parent.rightChild = newNode; 
						return; 
					}
				}
			}	
		}
	}

	public int min(){
		TreeNode curr = this.root; 

		while(curr.leftChild != null){
			curr = curr.leftChild;
		}

		return curr.key; 
	}

	public TreeNode search(int key){
		TreeNode focus = this.root; 

		while(focus.key != key){
			
			if(key < focus.key){
				// Traverse left subtree
				focus = focus.leftChild; 
			}
			else{
				// Traverse right subtree
				focus = focus.rightChild; 
			}

			if(focus == null){
				return null; 
			}
		}

		return focus; 
	}

	public void preorderTraversal(TreeNode focus){

		if(focus == null) return; 

		System.out.print(focus.key + ", ");
		preorderTraversal(focus.leftChild);
		preorderTraversal(focus.rightChild);


	}

	public void inorderTraversal(TreeNode focus){

		if(focus == null) return; 

		
		inorderTraversal(focus.leftChild);
		System.out.print(focus.key + ", ");
		inorderTraversal(focus.rightChild);
	}

	public void postorderTraversal(TreeNode focus){

		if(focus == null) return; 

		
		postorderTraversal(focus.leftChild);
		postorderTraversal(focus.rightChild);
		System.out.print(focus.key + ", ");
	}

	// This approach is inaccurate, because we end up ignoring the root
	// of subtrees which could violate the BST condition further down the line. 
	/*public static boolean isBST(TreeNode node){
		
		if(node == null)
			return true; 

		if(node.data >= node.leftChild.data && node.data < node.rightChild.data){
			return isBST(node.left) && isBST(node.right);
		}

		// If above conditional isn't meant at some point, then entire tree isn't a BST.
		return false; 
	}*/

	public boolean remove(int key){
		TreeNode focusNode = root; 
		TreeNode parent = root; 

		boolean isItLeft = true; 

		while(focusNode.key != key){
			parent = focusNode;

			if(key < focusNode.key){
				isItLeft = true; 
				focusNode = focusNode.leftChild; 
			}
			else{
				isItLeft = false; 
				focusNode = focusNode.rightChild; 
			} 
			if(focusNode == null){
				return false; 
			}
		}

		// Case 1: Deletion of a lead node
		if(focusNode.leftChild == null && focusNode.rightChild == null){

			// If BST only contains root, we just delete the root. 
			if(focusNode == root)
				root = null; 

			// If it is to the left of the parent
			else if(isItLeft)
				parent.leftChild = null; 

			// If it is to the right of the parent
			else
				parent.rightChild = null; 
		}

		// Node to be deleted has a left child
		else if(focusNode.rightChild == null){

			if(focusNode == root)
				root = focusNode.leftChild; 

			else if(isItLeft)
				parent.leftChild = focusNode.leftChild; 

			else
				parent.rightChild = focusNode.leftChild; 
		}

		// Node to be deleted has a right child
		else if(focusNode.leftChild == null){

			if(focusNode == root)
				root = focusNode.rightChild; 

			else if(isItLeft)
				parent.leftChild = focusNode.rightChild; 

			else
				parent.rightChild = focusNode.rightChild; 
		}

		// Node to be deleted has two children. 
		else{
			TreeNode replacement = getReplacementNode(focusNode);

			if(focusNode == root)
				root = replacement; 
			

			else if(isItLeft)
				parent.leftChild = replacement; 

			else
				parent.rightChild = replacement; 
		}

		return true; 
	}

	// Gets min value in right subtree (e.g. next smallest value)
	public TreeNode getReplacementNode(TreeNode replacedNode){
		TreeNode replacementParent = replacedNode; 
		TreeNode replacement = replacedNode;

		TreeNode focusNode = replacedNode.rightChild; 


		while(focusNode != null){
			replacementParent = replacement; 

			replacement = focusNode; 

			focusNode = focusNode.leftChild; 
		}

		if(replacement != replacedNode.rightChild){

			replacementParent.leftChild = replacement.rightChild;  // Setting left child of replacement's parent to be  replacement's right child (Replacement does not have a left child or else it wouldn't be the propper replacement)
			
			replacement.rightChild = replacedNode.rightChild; // Swapping replacement with the node to be replaced 
		}

		return replacement; 
	}

}