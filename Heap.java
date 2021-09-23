import java.util.*;
public class Heap{

	int heapSize = 0; 
	ArrayList<Integer> heap;

	int heapOccupied = 0; 

	public static void main(String[] args){

		Heap heap = new Heap(100);

		heap.addElement(5);
		heap.addElement(7);
		heap.addElement(9);
		heap.printHeap();

		//System.out.println(heap.peek());

		heap.addElement(3);
		heap.printHeap();

		//System.out.println(heap.peek());


		heap.addElement(2);
		heap.printHeap();

		//System.out.println(heap.peek());

		heap.addElement(6);
		heap.printHeap();

		System.out.println("Testing remove");
		heap.remove();
		heap.printHeap();

		heap.remove();
		heap.printHeap();

		heap.remove();
		heap.printHeap();

		heap.remove();
		heap.printHeap();

		heap.remove();
		heap.printHeap();

		heap.remove();
		heap.printHeap();

		/*
		heap.addElement(5);
		heap.addElement(7);
		heap.addElement(9);
		heap.printHeap();
		*/
		
		int[] arr = {5,7,3,2,4,6,1};

		heap.addElement(5);
		heap.addElement(7);
		heap.addElement(3);
		heap.addElement(2);
		heap.addElement(4);
		heap.addElement(6);
		heap.addElement(1);
		heap.printHeap();

		heap.remove();
		heap.printHeap();

		heap.remove();
		heap.printHeap();

		heap.remove();
		heap.printHeap();

		heap.remove();
		heap.printHeap();

		heap.remove();
		heap.printHeap();
		


	}

	Heap(int size){
		this.heapSize = size; 
		this.heap = new ArrayList<Integer>();
		this.heapOccupied = 0; 
		// Initializing values to null
		for(int i = 1; i < this.heapSize; i++){
			heap.add(null); 
		}
	}

	public void printHeap(){

		if(this.heapOccupied < 1){
			System.out.println("Heap is empty!");
			return;
		}

		if(this.heapOccupied == 1){
			System.out.println(this.heap.get(1));
			return; 
		}

		for(int i = 1; i < heapSize-1; i++){
			
			if(this.heap.get(i) == null){
				break; 
			}

			System.out.print(this.heap.get(i) + ", ");
		}
		System.out.println();
	}

	public int peek(){

		return this.heap.get(1); // Min value is always at root
	}

	public void addElement(int e){

		int eIndex = 0;
		int temp;
		int pIndex; 
		// Root starts at index 1 to simplify things
		for(int i = 1; i < heapSize; i++){
			if(heap.get(i) == null){
				heap.set(i,e);
				eIndex = i;  
				this.heapOccupied++;
				break; 
			}
		}

		
		// Element is placed is next open position, now we have to compare with parents
		// to maintain min-heap property. 
		//System.out.println(eIndex);
		//System.out.println((int) Math.floor(eIndex/2));
		while(eIndex > 1){

			pIndex = (int) Math.floor(eIndex/2);

			// Checking value of parent
			if(this.heap.get(pIndex) > e){

				// Swap with parent
				temp = heap.get(pIndex);
				heap.set(pIndex, e);
				heap.set(eIndex,temp); 

				// Update eIndex
				eIndex = pIndex;
			}

			else{ 
				// Element e is in its proper place
				return; 
			}

		}

	}

	// Remove min from heap
	public int remove(){


		int root = this.heap.get(1);

		if(this.heapOccupied == 1){
			this.heap.set(1, null);
			this.heapOccupied--;
			return root; 
		}

		// This is the element that will begin as the root's replacement
		int lastElement = this.heap.get(this.heapOccupied);
		int smallestChildIndex; // Index of parent node's smallest child.
		int temp; 
		int currIndex = 1; // Index of lastElement node as we trace it through the heap. 

		int leftChildIndex = 0; // Index of root node's left  
		int rightChildIndex = 0; // and right children.

		// Removing lastElement from its original position. 
		this.heap.set(this.heapOccupied, null);
		this.heapOccupied--; // We removed one element
		this.heap.set(1, lastElement); // Moving lastElement to root position

		// If there is only one element remaining in the heap
		if(this.heapOccupied <= 1){
			return root;
		}

		// At each iteration of loop, we check if lastElement is greater than its children; we swap its value with the child whose value is minimal.
		//System.out.println("heap size: " + this.heapOccupied);
		while(leftChildIndex < this.heapOccupied && rightChildIndex < this.heapOccupied){
			
			leftChildIndex = 2 * currIndex; 
			rightChildIndex = leftChildIndex + 1;

			//System.out.println(leftChildIndex);
			//System.out.println(rightChildIndex);

			if(rightChildIndex > this.heapOccupied)
				smallestChildIndex = leftChildIndex;
			
			else
				smallestChildIndex = (this.heap.get(leftChildIndex) > this.heap.get(rightChildIndex)) ? rightChildIndex : leftChildIndex;  

			// Swap with smallest child
			temp = this.heap.get(currIndex);
			this.heap.set(currIndex, this.heap.get(smallestChildIndex));
			this.heap.set(smallestChildIndex, temp);
			
			//System.out.print("Heap after rearrangement: ");
			//this.printHeap();

			currIndex = smallestChildIndex;

		}


		return root;  

	}

	public static int[] sort(int[] arr){

		// Convert to heap
		Heap sortHeap = new Heap(arr.length+1);
		int sortedArr[] = new int[arr.length];

		for(int i = 0; i < arr.length-1; i++)
			sortHeap.addElement(arr[i]);


		for(int i = 0; i < sortedArr.length-1; i++){

			sortedArr[i] = sortHeap.remove();
			sortHeap.printHeap();

			//System.out.println(sortedArr[i]);
		}

		return sortedArr;
	}
}
	// Prioritization Problems: 
	// Key operations: add an element, get/remove the most important/urgent element

	// Priority Queue: A collection of ordered elements that provides fast access to min/max element
	// Operations: add,peek (returns min/max/highest priority value), remove, isEmpty, clear, size

	// Consider using an unfilled array to implement a priority queue:
	// add: store it in next available index, as in a list.
	// peek: Loop over elements to find minimum element
	// remove: loop over elements ot find min, shift to remove. 
	// Operation Efficiency: add is O(1), peek is O(n) (since we have to loop to find min), remove is O(N) (since we have to shift elements upon removal)

	// Consider using a sorted array to implement priority queue: 
	// add must store in proper index to maintain order
	// minimum element is always at index 0
	// remove still requires us to shift elements.
	// add is O(N), peek is O(1), remove is O(N) since both add and remove require use to shift elements. 

	// What about using a doubly linked list to implement a priority queue
	// add: store it at end of linked list
	// peek: loop over elements to find minimum element
	// remove: loop of elements to find min, unlink to remove
	// add is O(1), but peek and remove require us to iterate over the LL (O(N))

	// Sorted linked list makes adding O(N) (to find proper location), but peek and remove become O(1) (just take first element/unlink element to be removed)

	// BST to implement PQ:
	// add/peek/remove are all O(logn)
	// Good in theory, but tree tends to become unbalanced to the right, making tree height approach N (making operations take O(N))

	// Heaps: 
	// A complete binary tree with vertical ordering.  
	// Complete Tree: Every level is full except possibly at the lowest level (leaves), which must be filled left to right. 

	// Heap Ordering: 
	// if P <= X for every element X with parent P
	// - Parents values are always smaller than those of their children. 
	// - Implies that minimum element is always the root (a "min-heap")
	// - "max-heap" also exists, where highest element is at root (reverse ordering)

	// A binary heap is a complete binary tree which satisfies the heap ordering property. 
	// Ordering can be either min heap or max heap 

	// In a heap, highest/lowest priority element is always stored at the root, hence the name "heap"
	// A heap is not sorted, and can be regarded as partially ordered. 
	// There is no particular relationship among nodes on any given level, even among the siblings. 

	// Heap Height and Runtime:
	// The height of a complete tree is always log N
	// If we implement a priority queue using a heap, we can provide the following run-time guarantees: 
	// add: O(logn), peak: O(1), remove: O(logn)

	// Add operation: 
	// When an element is added to a heap, where should it go?
	// - Must insert new node while maintaining heap properties
	// When an element is added to a heap, it should initially be placed as the rightmost leaf (to maintain completeness)
	// Heap ordering may be violated, so we compare to parent and "bubble up" the tree until it reaches its proper place. 
	// How many bubble-ups are necessary at most?

	// Add Algorithm (min-heap): 
	// Place new element in next available position (to maintain completeness of tree)
	// Compare the new element with its parent: 
	//	if smaller, swap with parent
	// Continue until either new element's parent is smaller/equal to new element
	// or new element reaches root, in which case it is the smallest value in the heap. 

	// Peak Operation: 
	// Trivial, just return the root -> O(1) runtime

	// Remove Operation: 
	// The root is the node to remove
	// When an element is removed from a heap, what should we do? 
	// How do we alter the tree?

	// When the root is removed from a heap, it should initially be replaced by the rightmost leaf (to maintain completeness)
	// - But the heap property becomes broken
	// Solution: Bubble down

	// Bubble Down: To restore heap ordering, the new improper root is shifted ("bubbled") down the tree until it reaches its proper place. 
	// For min-heap, continuously swap with smaller child. 

	// Remove Algorithm: 
	// Place root element in variable to return later
	// Remove the last element in the deepest level and move it to the root. 
	// While the moved element has a greater value than at least one of its children: swap this value with smaller child
	// Return original root 

	// Array Heap implementation: 
	// Though a heap is conceptually a binary tree, since it is a complete tree,when implementing it, we can actually use an array.
	// index of root = 1 (leave 0 empty to simplify math)

	// for any node n at index i: 
	// index of n.left = 2i
	// index of n.right = 2i+1
	// parent index floor(i/2)

	// A heap is useful when you need to remove the object with the highest/lowest priority
	// Commonly used to implement priority queue. 

	// Also used for Heapsort (which uses binary heap to sort an array in O(nlogn) time)
	// Used in graph algorithms such as djikstra's shortest path and prim's minimum spanning tree

	// Many problems can be efficiently solved using heaps: 
	// E.g. K'th largest element in array
	// sort an almost sorted array. 
	// merge K sorted arrays