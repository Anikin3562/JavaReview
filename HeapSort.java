
public class HeapSort{

	int heapSize = 0;

	public static void main(String[] args){

		int[] arr = {0, 16, 4, 7, 1, 12, 19, 2, 8, 14, 13, 6, 9};

		HeapSort sort = new HeapSort(arr.length-1);

		sort.heapSort(arr);

		for(int e: arr)
			System.out.print(e + ", ");
		System.out.println();

	}

	HeapSort(int size){
		this.heapSize = size; 
	}

	// Returns index of left child 
	public int leftChild(int i){
		return 2*i; 
	}

	// Returns index of right child
	public int rightChild(int i){
		return 2*i + 1; 
	}

	public void Heapify(int[] arr, int i){
			
		int l = leftChild(i);
		int r = rightChild(i);
		

		int largest;
		int temp; 
		//System.out.println(l);
		if(l <= heapSize && arr[l] > arr[i])
			largest = l; 
		
		else 
			largest = i; 

		if(r <= heapSize && arr[r] > arr[largest])
			largest = r; 

		if(largest != i){
			temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp; 

			Heapify(arr, largest);
		}

	}

	public void buildHeap(int[] arr){
		int start = (int) Math.floor(arr.length/2);
		
		for(int i = start; i >= 1; i--){
			Heapify(arr,i);
		}
	}

	public void heapSort(int[] arr){
		buildHeap(arr);
		int temp;
		 

		for(int i = arr.length-1; i >= 2; i--){
			temp = arr[1]; // Root
			arr[1] = arr[i];
			arr[i] = temp; 
			this.heapSize--; 
			Heapify(arr,1);
		}


	}
	// Heap Sort: Comparison based sorting technique for Binary Heap Structure
	// Similar to selection sort, where we find max element and place it in its proper position. 

	// We repeat teh same process for remaining elements

	// First we organize data into heap
	// Then we repeatedly perform "remove root" and "Heapify" to sort the data.

	// Procedures on Heap
	// Build Heap
	// Heap Sort
	// Heapify

	// Heapify: 
	// Picks largest child key and compares it to parent key (max-heap)
	// If parent key is larger, then heapify quits, otherwise it swaps the parent key with the largest child key. 
	// Parent now becomes larger than its children to satisfy max-heap property. 

	/*
		Heapify(A,i)
			l = left(i)
			r = right(i)

			if l <= heapSize and A[l] > A[i]
				largest = l
			else
				largest = i

			if r <= heapSize and A[r] > A[largest]
				largest = r

			if largest != i
				swap(A[i], A[largest])
				Heapify(A,largest)

	*/

	// We can use the procedure Heapify in a bottom-up fashion to convert an array A[1..n] into a heap.
	// Since the elements in the subarray A[n/2 + 1 .. n] are all leaves
	// the procedure BuildHeap goes through the remaining nodes of the tree and runs Heapify on each one. 
	// The bottom-up order of processing node guarantees that the subtree roted at children are a heap before Heapify is run at their parent. 

	/*
		Buildheap(A)
			heapsize = length(A)
			for i = floor(length[A]/2) down to 1
				Heapify(A,i)
	*/ 

	// We're essentially just performing bubble-up at each index i starting from floor(A.length/2)
	// and checking that the max-heap property is satisfied after swapping parent/child as well. 

	// The heap sort algorithm starts by using BuildHeap to build a heap on the input array.
	// Since the maximum element is always stored at the root A[1], it can be put into
	// its correct final position by exchanging with A[n] (last element in A)
	// If we now discard node n from the heap, then the remaining elements can be made into a heap. 
	// Note: new element at root may violate heap property, so we need to restore it.

	/*
		Heapsort(A)
			BuildHeap(A)
			for i = length(A) down to 2
				swap(A[1], A[i])
				heapsize = heapsize -1
				Heapify(A,1)
	*/

	// Overall Idea: 
	// Build max-heap from array
	// Swap the root (max element) with the last element in array
	// "Discard" last node by decreasing heap size
	// Call Heapify on the new root
	// Repeat this process until only one node remains. 
	
	// Heapsort Algorithm consists of two phases: 
	// 1. Build heap from an arbitrary array
	// 2. Use the heap tree to sort the data

	// To sort elements in decreasing order, use min-heap
	// To sort elements in increasing order, use max-heap

	// Time Analysis: 
	// Build Heap Algorithm will run in O(n) time. 
	// There are n-1 calls to Heapify, each call requires O(logn) time. 

	// HeapSort program combines buildheap and heapify, therefore it has running time of O(nlogn)

	// Quicksort is typically faster, duo to better cache  behaviour and other factors, but Heapsort
	// avoids worst case of O(n^2)

	// Quicksort also requires auxillary storage space, making it no strictly in place.

	// Thus, heapsort is still used in some systems with real-time constraints (e.g. can't afford O(n^2) worst case)
	// Heapsort is typically better than mergesort, as it has O(1) auxillary space requirement vs Mergesort's O(n)

	// Heapsort is typically quicker than mergesort.
	// Merge sort is simpler to understand than heap sort and is stable (equal elements maintain original (unsorted) order in sorted array)

	// Merge sort can easily be adapted to linked lists and very large lists stored on slow to access media such as disk storage or network attached storage.

	// Applications: 
	// When we want to know the task that has largest priority given a large number of things to do
	// E.g. Interval scheduling - we have a list of certain tasks with start and finish times and we want to do as many tasks as possible
	
	// HeapSort algorithm is non-recursive - best space efficiency
	// 




}