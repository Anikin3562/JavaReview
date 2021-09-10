
public class Hashtable{

	public static void main(String[] args){

		// We want a data structure that supports fast searcg, insertion, and deletion
		// - We do not usually care about sorting

		// The abstract data type is usually called a Dictionary, Map, or Partial Map
		// E.g. Given phone number return caller's name: key is phone #, element/value is caller's name

		// What's the best way to implement this?
		// Answer is whichever has the best performing Insertion, Deletion, and Search
		// We could use arrays/LL, but they're not that good. 

		// Suppose: 
		// range of keys is 0..m-1
		// Keys are distinct

		// Possible Solution: 
		// Set up an array: array[0..m-1] in which array[i] = x if x is in the array and key[x] = i
		// array[i] = null otherwise

		// This is called a direct-address table, in which the aforementioned operations take O(1) time.

		// Direct addressing works well when the range m of keys is relatively small
		// If keys are 32 bit integers, we will have more than 4 billion entries and even if memory isn't an issue, the time to initialize elements to null may be.

		// Solution: map keys to smaller range 0..p-1
		// Desire is p = O(m)

		// We can use a hash function to map general keys to corresponding indices in a table. 
		// E.g. the last four digits of a SSN 

		// A has function h maps keys of a given type to integers in a fixed interval [0..N-1]
		// E.g. h(x) = x mod N is a hash for integer keys
		// The integer h(x) is called the hash value of key x
		// A hash table for a given key type consists of: 
		// 1. Hash function H
		// 2. Array (referred to as table) of size N
		// When implementing a map with a hash table, the goal is to store item (k,o) at index i = h(k)
		// That is, the hashed value of the key refers to the location of the desired value in the table. 

		// Hash Table
		// The main idea is that, rather than indexing an array directly, we index it through some function h(x) (hash function)
		// array[h(key)] = value

		// What if two keys return the same hash value (as will happen when using modulo)
		// E.g. h(k_2) = h(k_5)
		// This is known as a collision: when the hash function maps two keys to the same location. 

		// Collisions generally cannot be avoided. 
		// We need mechanisms for resolving collisions when they occur. 

		// 1. Chaining: Keep a collection at each key slot
		// 2. Open Addressing: If the current slot is full, use the next open one. 

		// Chaining
		// keys which map to the same spot are put into a LL
		// If we're searching for keys which map to the same spot, we must traverse the LL at that location. 

		// Open Addressing
		// Insertion: if slot is full, try another slot until an open slot is found (probing)
		// Searching: follow same sequence of probes as would be used when inserting the element. 
		// - If we reach an element with correct key, return it
		// - If we reach null pointer, element is not in table. 

		// Open Addressing is good for fixed sets (adding, but no delete) E.g. spell checking

		// The colliding item is placed in a different cell of the table: no dynamic memory, fixed table size. 

		// Load Factor: n/N, where n is the number of items to store and N is the size of the hash table.
		// Clearly, n <= N, or n/N <= 1

		// To get reasonable performance: n/N < 0.5
		// lambda = Load Factor = # elements / array length

		// Where should we place the next element?
		// Randomly would be nice, but we need to be able to access it again.

		// Techniques: Linear Probing, Quadratic Programming, Double Hashing

		// Linear Probing: Handle collisions by placing the colliding item in the next (circularly) available cell
		// Each table cell inspected is referred to as a probe
		// Colliding items lump together, causing future collisions to cause a longer sequence of probes. 

		// Search with Linear Probing: 
		// Consider Hash Table A which uses linear probing

		/*
			get(k)
				start at cell h(k)
				probe consecutive locations until:
					1. An item with key k is found
					2. An empty cell is found 
					3. N cells have been unsuccessfully probed
		*/ 

		// if k is not in the table, we want to find an empty cell as soon as possible e.g. load factor cannot be close to 1
		
		// To handle insertions and deletions, we introduce a special object, called AVAILABLE, which replaced deleted elements

		/*
			remove(k)
				search for entry with key k
				if entry (k,o) is found, we replace it with AVAILABLE and return elemetn o
		*/ 
		// Note: We would have to modify other methods to treat AVAILABLE as NULL

		/*
			put(k,o)
				throw an exception if the table is full
				start at cell h(k)
				
				probe consecutive cells until:
					1. A cell i is found that is empty or AVAILABLE
					2. N cells have been unsuccessfully probed

				store entry (k,o) in cell i
			// f
		*/


		// Hash Table: An array of some fixed size which positions elements according to an algorithm called a hash function/
		// elements -> hash function h(element) -> hash table

		// Idea is that every time we hash an element, there is only one place that it should go. 
		// add, remove, and contains all become O(1)

		// a "hash function" h for int is trivial: store int i at index i (direct mapping)
		// if i >= array.length, store i at index i % array.length
		// h(i) = i % array.length
		// in this case, elements are integers. 

		// We can look up element by applying hash function again.

		// Hash tables have no ordering information -> expensive to sort, getMin, getMax, etc.
		// Collision: When two elements map to the same index in the array.
		// Collision resolutions: Open Addressing (Linear and Quadratic Probing, Double Hashing), Chaining (overlapping element put into LL at collision index)

		// Linear Probing: Put colliding element in next linearly available spot e.g. i+1, i+2, ... (circular)
		// Lookup algorithm becomes slightly modified as we have to move along the array until we find the element or NULL

		// Clustering Problem: 
		// nodes being placed closed together by probing is a problem for hash table's performance
		// e.g. no longer constant time

		// Quadratic Problem: 
		// Primary clustering occurs with linear probing because of the linear probing pattern e.g. place in i+1, i+2, etc.

		// Instead of searching forward in a linear fashion, try to jump far enough out of the current cluster

		// Suppose an element should appear in bin h
		// if bin h is occupied, then check the following sequence of bins:
		// h + 1^2, h+2^2, h+3^2...

		// If one of h+i^2 falls int oa cluster, this does not imply the next one will. 

		// Quadratic Probing: Resolving collisions on slot i by putting the colliding element into slot i+1, i+4, i+9, etc.
		// Note: Still loops circularly if i+x slot > arr.length

		// Even if two bins are initially close, the sequence in which their subsequent bins are checked varies greatly. 
		// Ex. with m=31 bins and checking from 22 and 23 respectively
		//22, 23, 26, 0, 7, 16, 27, 9, 24, 10, 29, 19, 11, 5, 1, 30
		//23, 24, 27, 1, 8, 17, 28, 10, 25, 11, 30, 20, 12, 6, 2, 0

		// Quadratic Probing solves the problem of primary clustering. 
		// Unfortunately, there is a second problem which must be dealt with. 
		// Suppose we have m=8 bins: 1^2 = 1, 2^2 = 4, 3^2 = 1 (8 > largest index so we wrap around to start of array)
		// In this case, we a re checking bin h + 1  twice, having onnly checked one other bin. 

		// There's no guarantee that h + i^2 mod M will cycle through 0,1,...,m-1

		// Solution: 
		// Require that m must be a prime number
		// in this case, h+i^2 mod m for i = 0..(m-1)/2 will cycle through exactly (m+1)/2 values before repeating.
		// Ex. m=13: 0, 1, 4, 9, 16 => 3, 25 => 12, 36 => 10, 49 => 10

		// Quadratic Probing is reasonable if load factor lambda is not close to 1. 

		// Secondary Clustering: 
		// If multiple items hash to the same bit, the same series of checks (i+1, i+4, i+9...) will occur
		// The effect is less significant than that of primary clustering.

		// Double Hashing: 
		// Pick a secondary hash function h2()
		// when hashing item x, resolving collisions on slot i by putting the colliding element into slot:
		// i + h2(x), i + 2*h2(x), i + 3*h2(x)...
		// Note: still important to use prime number of table size, ensuring we will visit all array entries eventually during probing. 

		/*
			double_hash_insert(K)
				if table is full -> error
				probe = h1(k)
				offset = h2(k)

				while(table[probe] is occupied)
					probe = (probe+offset) mod M

				table[probe] = K 
		*/ 

		// Double Hashing shares many of the same disadvanatges as linear probing 
		// Distributes keys more uniformly than linear probing does
		// Note: h2(x) should never return zero, and m should be prime.

		// Choosing a hash function: 
		// Desireable Features: Should distribute keys uniformly into slots, and should not depend on patterns in the data.

		// We want hash function to: 
		// 1. Be simple and fast to compute
		// 2. map equal elements to same index
		// 3. map different elements to different indices
		// 4. have keys distributed evenly among indices

		// Analysis: 
		// Main operation of hash table is lookup
		// performance cost highly depends on load factor n/N

		// Rehashing: increasing the size of hash table's array and re-storing all items into array using hash function.
		// When should we rehash?
		// - When load factor reaches certain level (>= 0.5)
		// - when an insertion fails

		// what is a good hash table array size? How much bigger should it get?
		// To get O(1) average case performance for lookups and adds, need: 
		// 1. good hashCode (distribute items evenly among all bins)
		// 2. load factor that isn't too great (choose table size appropriate to number of items you intend to store)
		// 3. keep rehashing to a minimum (choose largest initial capacity you can reasonably afford)

		// Hash Maps vs Trees
		// BST is much more efficient at search max/minimum values (O(1))
		// Hash Table has better deletion and lookup. 

		// 
	}
}