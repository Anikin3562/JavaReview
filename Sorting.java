import java.util.Random;
public class Sorting{

	public static void main(String[] args){

		// Sorting: Arranging a group of items into a defined order based on some criteria
		// Many different sorting algorithms exist
		// Sequential Sorts: require n^2 comparisons to sort n elements.
		// Logarithmic Sorts: Require nlogn comparisons to sort n elements

		// Selection Sort
		// Order a list of values by repetitively putting a particular value in its final position. 
		// Process: 
		// 1. Find smallest value in list
		// 2. switch it with value in the first position
		// 3. Find the next smallest value in the list
		// 4. Switch it with the value in the second position
		// 5. Repeat until all values are in their proper place. 

		// Algorithm essentially maintains two subarrays in a given array. 
		// 1. The subarray which is already sorted. 
		// 2. The remaining subarray, which is unsorted. 
		// In every iteration, the min element from the unsorted subarray is picked and moved into the sorted subarray. 

		int[] unsorted = {5,7,3,2,6,1,4,18,54,0,9};

		selectionSort(unsorted);

		for(int e: unsorted){
			System.out.print(e + ", ");
		}
		System.out.println();


		// Insertion Sort: 
		// Orders values by repetitively inserting a particular value into a sorted subset of the list. 
		// Process: 
		// Consider the first item to be a sorted sub-list of length 1
		// Insert the second item into the sorted sub-list, shifting the first item if needed. 
		// Insert the third item into the sorted sub-list, shifting the other items as needed. 
		// Repeat until all values have been inserted into their proper positions. 

		int[] unsorted2 = {5,7,3,2,6,1,4,18,54,0,9};
		insertionSort(unsorted2);

		for(int e: unsorted2)
			System.out.print(e + ", ");
		System.out.println();

		int[] unsorted3 = {5,7,3,2,6,1,4,18,54,0,9};
		bubbleSort(unsorted3);

		for(int e: unsorted3)
			System.out.print(e + ", ");
		System.out.println();

		// Merge Sort
		// Merge sort orders values by recursively dividing the list in half until each sub-list has one element, then merging
		// More specifically: 
		// Divide the list into two roughly equal parts
		// Recursively divide each part in half, continuing until a part contains only one element
		// Process: 
		// 1. Divide list into two roughly equal parts
		// 2. Recursively divide each part in half, continuing until a part contains only one element 
		// 3. merge the two parts into one sorted list. 
		// 4. Continue to merge parts as the recursion continues 
		// Merging is O(n), Dividing is O(logn)
		// As such, merge-sort is O(nlogn)

		int[] unsorted4 = {5,7,3,2,6,1,4,18,54,0,9};
		mergeSort(unsorted4,0,unsorted4.length-1); // -1 due to zero-based indexing.

		for(int e: unsorted4)
			System.out.print(e + ", ");
		System.out.println();

		// Quick Sort
		// Fastest known sorting algorithm in practice
		// Average case is O(nlogn), worse case is O(n^2) but is exceedingly uncommon.
		// Also employs divide and conquer strategy.

		// Merge sort is stable, but not in place (O(n) space comeplexity). 
		// Quick sort is not stable , but is in place (no auxillary array required, O(1) space complexity).

		// Method: 
		// Divides array into two parts (not necessarily halves)
		// An element of the array is chosen as a pivot (can be any element)
		// Elements are then arranged such that: 
		// The pivot is in its final position in the sorted array
		// Elements in positions before pivot are less than the pivot (order doesn't matter)
		// Elements in positions after the pivor are greater than the pivot (order doesn't matter) 

		// Steps: 
		// 1. Pick element from the list to be the pivot
		// 2. Reorder the list so that elements before pivot are less than it and vice versa for elements greater than the pivot.
		// 3. Recursively sort both sub-lists
		// Base Case: Lists of size zero or one. 

		// Worst Case running time: 
		// Occurs when we pick a pivot that is either the maximum or minimum of the list.
		// One sub array will have size n-1, and the other size 0.
		// Running time is n + (n-1) + ... + 2 + 1
		// Which is O(n^2)

		// We rely on picking good pivots to achieve best performance. 
		// We want to choose a pivot such that the partitions are of roughly equal size. 
		// We can choose the first/last element to be the pivot, but this is 50/50 at best.
		// We can randomly choose a pivot, but random number generation can be expensive. 

		// Ideally, we use the median of the array but finding the median is expensive. 
		// As such, we can just use a few elements to guess the median e.g. median of 3.

		int[] unsorted5 = {5,9,3,2,6,1,4,18,54,0,7};
		QuickSort(unsorted5, 0, unsorted5.length-1);

		for(int e: unsorted5)
			System.out.print(e + ", ");
		System.out.println();

	}

	// Time Complexity: O(n^2)
	// Auxillary Space: O(1)
	// In Place: Yes, extra space is not required to sort. 
	public static int[] selectionSort(int[] arr){

		int j = 0; 
		int temp = 0; 
		int indexMin = 0;

		for(int i = 0; i < arr.length-1; i++){
			
			j = i; // i+1 is slightly more correct
			indexMin = i; 
			
			while(j < arr.length){

				if(arr[j] < arr[indexMin])
					indexMin = j;

				j++; 
			}
			temp = arr[i];
			arr[i] = arr[indexMin];
			arr[indexMin] = temp;  
 	
		}
		return arr;
	}
	// Time Complexity: O(n^2)
	// Auxillary Space: O(1)
	// In Place: Yes, extra space is not required to sort. 
	// Note: Insertion sort is used when number of elements is small. It can
	// also be useful when input array is almost sorted (relatively few elements misplaced)
	// in complete big array. 
	// {2,3,5,6,7,1,4,18,54,0,9}
	public static int[] insertionSort(int[] arr){

		for(int i = 1; i < arr.length; i++){

			int key = arr[i];
			int j = i-1; 

			while(j >= 0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key; 

		}

		return arr;
	}
	// Time Complexity: O(n^2)
	// Auxillary Space: O(1)
	// In Place: Yes, extra space is not required to sort. 
	public static int[] bubbleSort(int[] arr){
		int temp = 0; 
		for(int i = 0; i < arr.length-1; i++){

			for(int j = 1; j < arr.length-i; j++){ // Last i elements already in place

				if(arr[j-1] > arr[j]){
					// Swap
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp; 
				}

			}
		}
		return arr;
	}

	public static void mergeSort(int arr[], int low, int high){

		if(low == high)
			return; 

		int mid = (low+high)/2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge(arr, low, mid, high);
	}

	// Divide and Conquer 
	// Recursive, Stable
	// Not in-place (we need auxillary arrays)
	// O(n) space complexity, O(nlogn) time complexity
	public static void merge(int[] arr, int lowIndex, int midIndex, int highIndex) {
		
		int leftSize = midIndex - lowIndex +1;
		int rightSize = highIndex - midIndex;

		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];

		for(int i = 0; i < leftSize; i++){
			leftArray[i] = arr[lowIndex+i]; // 0...midIndex
		}

		for(int i = 0; i < rightSize; i++){
			rightArray[i] = arr[midIndex+i+1]; // minIndex+1...highIndex
		}

		int i = 0, j = 0, k = lowIndex; // k used  to track where we are in arr.

		while(i < leftSize && j < rightSize){
			if(leftArray[i] < rightArray[j]){
				arr[k] = leftArray[i];
				i++;
				k++;
			}
			else{
				arr[k] = rightArray[j];
				j++;
				k++; 
			}
		}

		// Making sure all values are added to arr, even if i/j finishes before j/i
		while(i < leftSize){
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		while(j < rightSize){
			arr[k] = rightArray[j];
			j++;
			k++;
		}

	}

	public static void QuickSort(int[] arr, int start, int end){

		if(start < end){ // Base Case

			int pIndex = partition(arr, start, end);
			QuickSort(arr, start, pIndex-1);
			QuickSort(arr, pIndex+1, end);

		}
	}

	public static int partition(int[] arr, int start, int end){
		int pivot = arr[end]; // Taking pivot to be the last element in the array. 

		int pIndex = start; // Initializing pivot index to be start of array.
		
		int temp = 0; 

		for(int i = start; i < end; i++){

			if(arr[i] <= pivot){

				// Swap
				temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp; 

				pIndex++;
			}
		}

		// Swapping pivot to be at pIndex (pivotIndex)
 		temp = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end] = temp; 

		return pIndex;
	}

}