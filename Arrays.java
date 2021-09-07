
public class Arrays{

	public static void main(String[] args){

		// Arrays are data structures of related items of the same type
		// Remain fixed in size once created. 

		// Index/subscript to access values of array at that point
		// e.g. array[2], array[0], etc.
		// 

		// Values held in array called array alements
		// All elements in an array are of the same type
		// element type can be primitive or object reference

		// We can create arrays of integers, characters, String objects, or a self-defined object

		// The array itself is an object that must be instantiated

		// Note: Index must be an int value or a value that can be promoted to int (byte, short, char).
		// Index cannot be of type long

		// Declaration and Creation
		int c[] = new int[12];

		// Equivalent to
		int c2[];	// Declaration
		c2 = new int[12]; // Creation

		String b[] = new String[100];

		// An array element can be assigned a value, printed, or used in a calcualtion. 
		c[0] = 100; // Assigned index 0 to have value 100.
		System.out.println(c[0]);

		System.out.println(c[0] + 25);

		
		// Alternate Syntax
		// Brackets can be associated with element type or with the array name
		// float[] prices; is equivalent to float prices[];
		// Though the former is more often used.

		int array[] = new int[10]; // Note: Each int is initialized to 0 by default.

		for(int i = 0; i < array.length; i++){
			array[i] = i; 
		}

		System.out.println(array[6]);


		// Initializer Lists
		// Used to fill in array in one step
		// Values enclosed in braces and seperated via comma
		// 'new' operated not required, and size need not be specified. 
		// Can only do this at declaration.
		int[] units = {147, 323, 89, 933};
		char[] letterGrades = {'A', 'B', 'C', 'D', 'F'};

		for(char k: letterGrades){ // Enhanced for-statement
			System.out.println(k);
		}

		System.out.println(factorial(5));

		System.out.println(sumArray(units));

		System.out.println(sumArrayEnhanced(units));
		
		System.out.println(findMin(units));

		System.out.println(isAscending(units));

		int[] asc = {1,2,3,4,5};

		System.out.println(isAscending(asc));

		findTargetSum(asc, 7);
	}

	public static int factorial(int n){
		int res = 1; 

		for(int i = n; i > 0; i--)
			res *= i; 
		

		return res; 
	}

	public static int sumArray(int[] arr){ // Note: Changing the array in the method changes the original since we're passing an object reference. 

		int total = 0; 

		for(int i = 0; i < arr.length; i++){
			total += arr[i];
		}

		return total; 
	}

	public static int sumArrayEnhanced(int[] arr){

		int total = 0; 

		for(int val: arr)
			total += val;

		return total;

	}

	public static int findMin(int[] arr){
		// Returns index of min element
		int minIndex = 0; 

		for(int i = 1; i < arr.length; i++){

			if(arr[i] < arr[minIndex])
				minIndex = i; 
		}	

		return minIndex;
	}

	// Determines if list is sorted in ascending order or not. 
	public static boolean isAscending(int[] arr){
			boolean ascending = true;

			for(int i = 1; i < arr.length; i++){

				ascending = (arr[i-1] <= arr[i]);

				if(!ascending)
					break; 
			}

			return ascending; 
	}

	public static void findTargetSum(int[] arr, int target){

		for(int i = 0; i < arr.length; i++){

			for(int j = i+1; j < arr.length; j++){ // j = i+1 prevents us from using the reverse of two elements we've already found e.g. 5+2 and 2+5

					if((arr[i] + arr[j] == target) && i != j){

						System.out.println("Found pair that matches target: " + arr[i] + " + " + arr[j] + " = " + target);
					}

			}
		}



	}
}