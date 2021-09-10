
public class Trees{

	public static void main(String[] args){


		// Tree: 
		// Non-linear data structure
		// Elements organized into hierarchy
		// Comprised of a set of nodes in which elements are stored and edges which connect nodes to eachother. 
		// Each node is located at a particular level. 
		// One root node which is first node of tree. 

		// Nodes at lower level of tree are the children of nodes at the previous level
		// A node can only have one parent, but may have multiple childre. 
		// Root is the only node which has no parent. 

		// A node that has no children is a leaf node
		// Nodes that are not the root and have at least one child are internal nodes

		// A sub-tree is a tree structure that makes up part of another tree
		// We can follow a path through a tree from parent to child. 
		
		// A node is an ancestor of another node if it is above it on the path from the root. 
		// Nodes that can be reached by following a path from the a particular node are the descendants of that node. 

		// The level of a node is the length of the path from the root to the node. 
		// The path length is the number of edges followed to get from the root to the node. 

		// The height of the tree is the length of the longest path from the root to a leaf. 

		// Classifying Trees
		// Important criterion is max number of children any node can have (Order of the tree)
		// General trees have no limit to how many children each node can have.
		// A tree that limits each node to no more than n children is referred to as a n-ary tree.
		// E.g. Trees in which nodes may have at most two children are called binary trees. 

		// Balanced Trees: A tree is balanced if all leaves are one the same level or within on level of eachother. 

		// A balanced n-ary tree with m elements will have height log(n,m)
		// A balanced binary tree with n nodes has a height of log(2,n)

		// Full Tree: An n-ary tree is full if all leaves of the tree are at the same hieght and every non-leaf node has n children.
		// Complete Tree: A tree is complete if it is full, or full to the next-to-last level with all leaves at the bottom level on the left side of the tree.

		// Implementation:
		// An obvious choice for implementing trees is a linked structure
		// Array-based implementations are sometimes useful too. 

		// For full or complete binary trees, we can use an array to represent a tree. 

		// For any element stored in position n:
		// - The element's left child is stored in array position (2n+1)
		// - The element's right child is stored in position 2(n+1)

		// If the represented tree is not complete or relatively complete, this approach can waste large amounts of space. 

		// Tree Traversals
		// For linear structures, the process of iterating through the elements is fairly obvious (forwards or backwards)

		// Four classic ways of traversing nodes of a tree: 
		// - All traversals start at the root of the tree. 
		// - Each node can be thought of as the root of a sub-tree. 

		// Preorder: Visit the root, then traverse subtrees from left to right.
		// Inorder: Traverse the left sub-tree, then visit the root, then traverse right sub-tree. 
		// Postorder: Traverse the sub-trees from left to right, then visit the root. 
		// Level-Order: Visit each node at each level of the tree from top (root) to bottom and left to right. 

		// Recursion simplifies the implementation of tree traversals.
		// E.g.
		// Preorder Pseudocode: 
		// Visit Node
		// Traverse(left child)
		// Traverse(right child)

		// Inorder: 
		// Traverse(left child)
		// Visit node
		// Traverse(right child)

		// Postorder: 
		// Traverse(left child)
		// Traverse(right child)
		// Visit node

		// Level order traversal is more complicated. 
		// It requires the use of other structures (e.g. queue/lists) to create the necessary order. 

		// Special Trees: 
		// Expression Trees: shows relationships among operators and operands in an expression; evaluated from bottom-up, left-right. 
		// Decision Trees: Trees whose nodes represent decision points, and whose children represent options available. 
		// - Leaves are possible conclusions that might be drawn. 
		// - Simple decision tree, with yes/no questions, can be modeled by a binary tree where edges are yes/no.


		// Binary Search Trees (BSTs)
		// A search tree is a tree whose elements are organized to facilitate finding a particular element when needed. 
		// Binary search tree is a binary tree which has the following properties: 
		// 1. left subtree of node contains only nodes with keys lesser than the node's key
		// 2. right subtree of node contains only nodes with keys greater than the node's key. 
		// 3. The left and right subtree each must also be a BST
		// 4. There must not be any duplicate node.

		// Binary Tree Properties: 
		// Degenerate: Height = O(n) for n nodes (Tree massively skewed to one side)
		// Balanced: Height = O(logn) for n nodes (Useful for searches)

		// The properties of BST provide ordering among keys so that operations like search, min, and max can be done very quickly. 
		// If there is nordering, then we'd have to compare every key to search for a given key. 

		// To determine if a particular value exists: 
		// 1. Start at root
		// 2. Compare current node to target node
		// 3. move left if target is less than current node.
		// 4. move right if target is greater than current node. 

		// We eventually find the target or encounter end of path (e.g. not found)

		// A new key is always isnerted at leaf. 
		// We start searching a key from root until we hit a leaf. 
		// Once leaf node is found, the new node is added as right/left child of the leaf node.

		// Algorithm: 
		// 1. Start from root
		// 2. Compare the inserting element with root: 
		// - if less than root, recurse left, otherwise recurse right
		// 3. After reaching end, just insert that node at left (if less than current) else right.

		// Worst case complexity of search and insert operations is O(h), where h is height of BST
		// We may have to travel from root to the deepest leaf node in worst case. 
		// The height of a skewed tree may become n, and the complexity of search and insert may become O(n).

		// Inorder Traversal of BST always produces sorted output. 
		// We can construct a BST with only (preorder + inorder) sequences or (postorder + inorder) sequences

		// Checking if a binary tree is BST or not.
		// For each node , check if left node of it is smaller than the node, and right node of it is greater. 

		// Removing a node from a BST falls into three situations
		// 1. Node to be removed is a leaf (easiest)
		// 2. Node to be removed has one child (pretty easy)
		// 3. Node to be removed has two children (more difficult)

		// We can simply delete the note if it's a leaf
		// If the node has one child, the deleted node is replaced by the child. 

		// If the node being deleted has two children, we must find the inorder successor of the node. 
		// Copy contents of the inorder successor to the node and delete the inorder successor.
		// Inorder Successor: Smallest value in the right sub-tree e.g. the node that contains the next highest value. 

		// Note: Inorder predecessor can also be used 
		// Inorder successor is needed only when right child is not empty. In this particular case, inorder successor can be obtained by finding the minimum value in the right child of the node. 

		// Time Complexity of Deletion: 
		// Worst case is O(h) where h is the height of BST
		// Occurs when we have to travel from root to deepest leaf node; though if tree is skewed worst case may become O(n)

		// If BSTs are balanced, we can avoid worst case performance for insert, find, and remove operations. 
		// Balanced Trees: Subtrees differ in height by at most 1, and are themselves balanced
		// A balanced binary tree with n nodes has height of log(2,n)
		// A very unbalanced tree can have height close to n (making our operations inefficient)

		// AVL Trees: 
		// Binary Tree
		// Has BST properties
		// Is Balanced (AVL Property) e.g. for every node there can be no more than a difference of 1 in the height of the left subtree from the right. 

		// This AVL property ensures that height is always O(logn); it's easy to maintain too.

		// Balance Condition: 
		// For every node, the height of its left subtree and right subtree differ by at most 1. 
		// balance(node) = Math.abs(height(node.left) - height(node.right))
		// -> AVL Condition is: For every node: balance(node) <= 1

		// Calculating Tree Height: 
		// Heigh is max number of edges in path from root to any leaf. 
		// Height(null) = 0
		// Height(a leaf) = ?
		// Height(Tree) = ? 

		// Use recursion
		// Height (a leaf) = 0
		// Height(Tree) = 1 + max(height(A.left), height(A.right))

		// For a binary tree of height h: 
		// Max # of leaves: 2^(h-1)
		// max # of nodes: 2^h -1

		// AVL Trees is just a BST that uses modified add and remove operations to maintain the balance of the trees as operations are performed. 
		// Basic Idea: When nodes are added to / remove from the tree, if the tree becomes unbalanced, repair the tree until balance is restored. 

		// Rebalancing operations are highly efficient (O(1))
		// Overall tree maintaining balance means that add/remove operations stay O(logn)

		// Balance Factor: 
		// For a tree node T, balance factor is height of T's right subtree subtract height of T's left subtree
		// BF(T) = Height(T.right) - Height(T.left)

		// AVL tree maintains blaance factor in each node of 0, 1, or -1 (height of subtrees differ in height by no more than 1)
		// It can be proven that the height of an AVL tree with n nodes is O(logn)

		// Measuring Balance: 
		// For each node, compare the heights of its two subtrees
		// Balanced when difference in height betweeen subtrees is no greater than 1. 

		// Many of the AVL tree operations depend on height. 
		// Height can be recursively computed by walking the tree, but this is slow.
		// Instead, each node can keep track of its subtree height as a field. 

		// For all AVL operations, we assume the tree was balanced before the operation began. 
		// Adding a new node begins the same as with a typical BST, traversing left and right to find the proper location and attaching the new node. 
		// But adding this new node may unbalance the tree by 1. 

		// Consider the lowest node k_2 that has now become unbalanced. 
		// There are four subtree cases where the offending node could be, relative to k2:
		// Left-Left, Left-Right, Right-Left, Right-Right

		// Key Idea: Rotations
		// If a node has become unbalanced in a given direction, rotate it in the opposite direction
		// rotation: swap between parent and left or right child and maintaining proper BST ordering.

		// Right Rotation (Clockwise) -> Fixes Left-Left 
		// left child becomes parent
		// original parent demoted to right child
		// left child's original right subtree (if any) is attached to original parent as left subtree

		// Left Rotation (counter-clockwise) -> Fixes right-right
		// right child becomes parent
		// original parent demoted to left child
		// right child's original left subtree (if any) is attached to original parent as right subtree

		// Problem Cases: 
		// A single right rotation does not fix Left-Right
		// A single left rotation does not fix Right-Left

		// Left-rotate left child of unbalanced node,then right-rotate unbalanced node to fix Left-Right
		// right-rotate right child of unbalanced node, then left-rotate unbalanced node to fix Right-left
		// To fix Left-Right and Right-Left cases, we require these double rotations. 
	}
}