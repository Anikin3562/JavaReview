
public class LinkedLists{

	public static void main(String[] args){


		// Linked Lists
		// Abstract Data Type

		// Linear Data Structure
		// Elements are not stored at contiguous memory locations, but are linked using pointers. 
		// E.g. (This is the Head) [A] -(Next)> [B] -(Next)> [C] -(Next)> [D] -(Next)> Null 

		// Both Arrays and Linked Lists can used to store linear data of similar types, but they both have their pros and cones.

		// Array is limited by its fixed size upon declaration, and inserting new elements in an array of elements is expensive as
		// we need to create room for the new elements and shift the other elements.
		// E.g. id[] = [1000, 1010, 1050, 2000, 2040] If we want to insert 1005, we need to move all elements after 1000.
		// Deletion is also expensive for the same reason e.g. deleting 1010 requires us to move everything after 1010

		// LL has dynamic size; we don't need to specify how many nodes will be in the list. 
		// LL has easy and fast insertion and deletion since all we need to do is move pointers around. 


		// Drawbacks of LL: 
		// Random access not allowed; we must traverse list from head until we find desired element.
		// Extra memory used to store pointer to next element
		// No locality of reference since LL elements are not at contiguous locations.
		// LL are more complex to code and manage than arrays. 

		// Representation
		// A linked list is a series of connected nodes
		// Each node contains data, and a pointer to the next node in the sequence. 
		// Head: Pointer to first node
		// First node is the head. If the linked list is empty, the value of the head is null.
		// Last node in a LL points to null. 

		// LL States of Interest: 
		// Empty List: head == null
		// List with one element: head -> [32] -> null
		// More than one element: head -> [32] -> [17] -> [5] -> null


		// In Java, a LL can be represented as a class and a Node as a seperate class. 
		// LL class contains a reference of Node class type

		// Constructors: 
		// If no constructor is provided in a class, Java automatically creates a default constructor that doesn't initialize anything. 
		// E.g. Ball b = new Ball(); 

		// Inserting a Node: 
		// Nodes can be inserted in three ways: 
		// 1. At the front of a give list. 
		// 2. After a given node
		// 3. At the end of the linked list. 

		// Adding to front: 
		// The new node is always added before the head of the given Linked List, and the newly added node becomes the new head of the Linked List

		// Adding after Node: 
		// When given pointer to a node, we insert the new node after it. 

		// Adding node at the end: 
		// We have to traverse the list unti lthe end and change the next of last node to new node. 

		// Search for an element in an LL: 
		// Initialize a node pointer, and while that pointer is not null traverse the list searching for target. 

		// Array vs LL
		// Which is better depends on various factors, such as: 
		//	- Most frequent operation performed
		//	- Size of data

		// Cost of Access: 
		// Array: Constant Time O(1)
		// LL: Average Case is O(n) (Since we need to traverse list)
		
		// Memory Requirement: 
		// Array: Fixed Size
		// LL: Dynamic Size, No unused memory, but extra space required for pointer variables. 

		// Cost of inserting elements in the list: 
		// At beginning of Array: O(n) since we need to shift all other elements
		// At beginning of LL: O(1) since all we need to do is rewire a couple pointers.

		// At end of Array: O(1) if array is not full, O(n) if array is full.
		// At end of LL: O(n) since we need to traverse entire list. 

		// At middle of Array: O(n) since we need to shift elements
		// At middle of LL: O(n) since we need to traverse list

		// Arrays are easier to implement and use

		// Essentially, LL's advantages are its fast insert-at-front time and dynamic size. 


		// Deleting a Node: 
		// Find previous node of node that is to e deleted
		// Change next of previous node (and let automatic garbage collection deal with the rest)

		// Doubly Linked Lists (DLLs)
		// A DLL contains an extra pointer, typically called previous, together with the next pointer and data.
		// Each node points to not only the next node, but also the previous. 
		// Theere are two NULL: first and last nodes in the list. 
		// Advantages: Given a node, it's easy to visit the previous. Convenient to traverse lists backwards. 

		// DLL advantages over LL:
		// DLL can be traversed both forwards and backwards. 
		// The delete operation in DLL is more efficient, if pointer to the node to be deleted is given. 
		// Can quick insert a new node before a given node. 

		// In a LL, to delete a node the point to the previous node is required. To get this previous node, the list should be traversed. 
		// In DLL, we can get the previous node using the previous pointer. 
	
		// Disadvantages over LL
		// Every node of DLL requires extra space for a previous pointer.
		// All operations require an extra pointer to previous to be maintained. 
		// E.g. for insertion, we need to modify the previous pointers together with the next pointers. In following functions for insertions
		// at different positions, we need 1 or 2 extra steps to set the previous pointer. 

		// Adding a node after a given node in a DLL
		// We are given a pointer to a node as prev_node, and the new node is inserted after the given node. 

		// Circular Linked Lists (CLLs): 
		// The last node points to the first node of the list.
		// All nodes form a connected circle. 
		// No NULL at the end. 
		// A CLL can be singly circular or doubly circular.

		// Advantages of CLLs
		// Any node can be a starting point. We can traverse the whole list by starting from any point. We just need to stop when first node is visited again. 
		// Useful for implementation of queue as we don't need to maintain two pointers for front and rear if we use circular linked list. We can maintain a pointer to the 
		// last inserted node and front can always be obtained as next of last. 
		// Circular lists are useful in applications that repeatedly go around the list. 
		// Circular Doubly Linked Lists are use for implementatio of advanced data structures e.g. Fibonacci Heap

		// Stack
		// Linear data structure (Last in First Out (LIFO) e.g. deck of cards)
		// Also is First In Last Out (FILO)
		// Operations: Push, Pop, Top (AKA Peek, returns top of stack), isEmpty
		// All of the aforementioned operations are O(1) time. 

		// We can implement stacks via arrays or linked lists. 
		// Array: Easy to implemented. Memory is saved as pointers are not involved; but stack cannot grow or shrink dynamically. 
		// LL: The LL implementation of stack can grow and shrink dynamically, but requires extra memory for pointers. 

		// Queue: 
		// FIFO (First In First Out)
		// Operations: Enqueue, Dequeue, Front (item at front of queue), Rear(last item in queue)
		// Used in Breadth First Traversal; useful for scenarios such as allocating shared resources among multiple consumers. 
		// E.g. CPU scheduling, Disk Scheduling
		// Can implement using array or LL
		

	}
}