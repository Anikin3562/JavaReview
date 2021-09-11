import java.util.HashMap; 

public class FindFrequency{

	public static void main(String[] args){

		int[] input = {4,1,5,1,7,3,9,5,4,4,3};

		findRepetition(input);
	}

	// Time Complexity: O(n)
	// Space Complexity: O(n)
	// Much better performance with a hashmap than sorting the array first / simple double for loop. 
	public static void findRepetition(int[] input){

		HashMap<Integer, Integer> hm = new HashMap<>();

		for(int i: input){
			if(hm.containsKey(i)){
				hm.put(i, hm.get(i) + 1);
			}
			else{
				hm.put(i,1);
			}
		}

		for(int i: hm.keySet()){
			System.out.println(i + " " + hm.get(i));
		}
	}

}