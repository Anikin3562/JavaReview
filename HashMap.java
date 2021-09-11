import java.util.*; 

public class HashMap{

	public ArrayList<String> keys;
	public ArrayList<Integer> values; 

	protected int capacity = 0; 

	public static void main(String[] args){

		HashMap test = new HashMap(11);

		//System.out.println("Keys Length: " + test.keys.size());
		test.put("jwGrade", 85);
		test.put("neenoGrade", 72);
		test.put("billyGrade", 77);
		test.put("camGrade", 65);
		test.put("dawGrade", 90);
		test.put("brizzyGrade", 74);
		test.put("jorgeGrade", 37);
		test.put("spenceGrade", 32);
		//System.out.println("Keys Length: " + test.keys.size());

		//System.out.println(test.values);

		test.get("camGrade");
		test.get("neenoGrade");
		test.get("spenceGrade");
		test.get("billyGrade");
		test.get("jwGrade");
		test.get("dawGrade");
		test.get("jorgeGrade");
		test.get("brizzyGrade");

		System.out.println(test.hash("jwGrade") == test.hash("neenoGrade"));
		System.out.println(test.hash("dawGrade") == test.hash("camGrade"));
		System.out.println(test.hash("brizzyGrade") == test.hash("spenceGrade"));



		System.out.println(test.keys);
	}

	// Constructor
	HashMap(int capacity){
		this.capacity = capacity;

		this.keys = new ArrayList<String>();
		this.values = new ArrayList<Integer>();

		// Initializing all values to null
		for(int i = 0; i < capacity; i++){
			this.keys.add(null); 
			this.values.add(null);
		}

		
	}

	// Hash Function - sum of unicode character values mod array capacity
	public int hash(String key){
		int sum = 0; 

		for(int i = 0; i < key.length(); i++){
			sum += (int)key.charAt(i); 
		}

		return sum % this.capacity; 
	}

	// Quadratic Rehashing
	public int rehash(int previousHash, int inc){
		// i + 1, i + 4, i + 9, ... 
		return (previousHash + (inc*inc)) % this.capacity; 
	}

	public void put(String key, int value){
		int index = hash(key);
		int inc = 0; 

		
		for(String k: this.keys){

			// Slot is open
			if(this.keys.get(index) == null){
				keys.set(index, key); // use .set() to replace rather than push other elements to make room (like .get() does)
				values.set(index, value);
				break; 
			}

			// Slot is not open - need to rehash
			else{
				System.out.println("Rehashing...");
				inc++; 
				System.out.println(key + " has previousHash: " + index);
				index = rehash(index, inc);
				System.out.println(key + " rehashed to: " + index);
			}
		}
	}

	public void get(String key){
		int indexOfValue = hash(key);

		//System.out.println(key + " " + indexOfValue);

		if(keys.get(indexOfValue) != key){

			// Take quadratic steps until we find desired element or null.
			int inc = 0; 
			while(keys.get(indexOfValue) != key){

				if(keys.get(indexOfValue) == null){
					System.out.println("Key not found table.");
					return; 
				}

				inc++; 
				indexOfValue = rehash(indexOfValue, inc);
			}


		}

		System.out.println(values.get(indexOfValue));
		
	}

	// TODO
	public int remove(String key){

	}


}