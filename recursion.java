
public class recursion{

	public static void main(String[] args){

		// Recursion: Function calling itself to fulfill purpose

		// We're essentially using the definition of a concept to definit itself
		// E.g. Consider a list of numbers: 24,88,40,37
		// Defining this in terms of itself, a list is either a number or a number *comma* list

		// We can recursively simulate the entire list:
	//List: number comma List
		//  24      ,     88,40,37
		//  88      ,     40,37
		//  40      ,     37
		//  37

		// All recursive functions must have non-recursive terminating condition to prevent infinite recursion. 
		// non-recursive part is referred to as "base case"

		// Recursion in math
		// Factorial: n! = 1 * 2 * 3 * ... * n-1 * n
		// Recursively: 1! = 1 (Base Case)
		//				N! = N * (N-1)!
		// We're defining factorial in terms of another factorial until the base case is reached
		// Then, the results will cascade back to determine other cases. 

		System.out.println(factorial(5));
		System.out.println(factorialEnhanced(5));

		// Every possible chaine of recursive calls must eventually reach a base case otherwise infinite recursion will occur.
		// Each recursive call should be defined so that it makes progress towards a base case. 
	
		System.out.println(sumRecursive(5));

		// Binary Search: Easy and highly efficient recursive algorithm/
		// Search a sorted array by repeatedly dividing the search interval in half. 
		// E.g. compare target to middle element in list, if greater search top half of list otherwise search bottom half. 
		// Size of list is halved each recursive call (O(logn) complexity)
	

		int[] sortedList = {1,2,3,4,5,6};

		System.out.println(binarySearch(sortedList, 5, 0, sortedList.length-1));
		System.out.println(binarySearch(sortedList, 9, 0, sortedList.length-1));

		// We cannot do binary search with LL as we require random access.
		// LL do not support random access; we can only traverse forward or backwards one element at a time. 
		

		// Recursion vs Iteration: 
		// Not always better to use recursion. 
		// E.g. sum of 1 to N can be done in constant time (n*(n+1)/2)	
		// Iterative versions are usually easier to understand. 	

		// All recursive solutions necessarily have a corrseponding iterative solution. 
		// Sometimes, the iterative solution is better. 

		// Direct vs. Indirect Recursion
		// A method invoking itself is considered to be direct recursion
		// A method could invoke another method, which invokes another, etc. until the original method is invoked again.
		// This is known as indirect recursion, which is much more difficult to trace and work with. 

		// Towers of Hanoi
		// Puzzle made up of three vertical pegs, and several disks that slide onto the pegs. 
		// Disk are of varying size, initially placed on one peg with the largest disk on the bottom and increasingly smaller disks on the top. 

		// Goal is to move all of the disks from one peg to another following these rules:
		// 1. Only one disk can be moved at a time. 
		// 2. A disk cannot be placed on top ofa smaller disk.
		// 3. All disks must be on some peg (except for the one in transit)

		// ToH solution can be expressed recursively. 
		// To move N disks to the destination peg: 
		// 1. Move the topmost N-1 disks from the original peg to the extra peg. 
		// 2. Move the largest disk from the original peg to the destination peg. 
		// 3. Move the N-1 disks from the extra peg to the destination peg. 
		// Base case occurs when a peg contains only one disk. 

		// Recursive solution is simple and elegant to express, but takes exponential time (O^2n)
		// Iterative solution is much more efficient, but also more complex to define and program. 

		 TowersOfHanoi towers = new TowersOfHanoi(4);
		 towers.solve();

		// To determine order of a recursive method, we multiply the order of the body by the number of times the recursive method is called. 
		// 
	}

	public static int factorial(int n){
		if(n <= 1)
			return 1; 

		return n * factorial(n-1);
	}

	public static int factorialEnhanced(int n){

		return n <= 1 ?  1 :  n*factorial(n-1); 
	}

	public static int sumRecursive(int n){

		return n == 1 ? 1 : n+sumRecursive(n-1);
	}

	// Returns index of element if found, or -1 if not found. 
	public static int binarySearch(int[] arr, int target, int left, int right){

		if(right >= left){
			int mid = (left+right)/2;

			if(arr[mid] == target)
				return mid; 

			// Search bottom half of list
			if(arr[mid] > target){
				return binarySearch(arr, target, left, mid-1);
			}
			// Search top half of list
			else{
				return binarySearch(arr, target, mid+1, right);
			}
		}

		// Element not present in array. 
		return -1; 
	}
}