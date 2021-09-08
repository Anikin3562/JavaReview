
public class LinkedList{

	Node head; // head of list

	public static void main(String[] args){

		LinkedList myList = new LinkedList(); 
		
		System.out.println(myList.isEmpty());

		myList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		/*
			Three nodes have been allocated dynamically. 
			We have references to these three as head, second, and third. 
		*/ 

		myList.head.next = second; 

		/*
			First node now refers to second; both are linked. 

		*/

		second.next = third; 

		/*
			Now next second node refers to third. All three nodes are linked.

			third.next is already null (by default). 
		*/

		System.out.println(myList.isEmpty());
		myList.printList();
		System.out.println(myList.getSize()); 
	
		myList.insertAtFront(0);
		myList.printList();

		myList.insertAfter(myList.head, 1);
		myList.printList();

		myList.insertAtEnd(4);
		myList.printList();

		System.out.println(myList.search(3));
		System.out.println(myList.search(5));

		System.out.println(myList.countOccurences(1));
		System.out.println(myList.countOccurences(5));

		myList.sortedInsert(3);
		myList.printList();
		myList.sortedInsert(5);
		myList.printList();

		myList.delete(3);
		myList.printList();

		myList.delete(0);
		myList.printList();

		myList.delete(1);
		myList.printList();
	}

	public boolean isEmpty(){

		return(this.head == null); 
	}

	public void printList(){
		Node current = this.head; 
		
		while(current != null){
			System.out.print(current.data + " -> ");
			current = current.next; 
		}	
		System.out.println("null");
	}

	public int getSize(){
		int size = 0;
		Node current = this.head; 

		while(current != null){
			size++; 
			current = current.next; 
		}

		return size; 
	}

	public void insertAtFront(int d){
		
		Node newNode = new Node(d); // Create new node for data

		newNode.next = this.head; // newNode's neighbour will be the current head (since we're inserting at the front)

		this.head = newNode; // Since we're pointing to the previous head, we can now assign the head to reference the newNode (which is at the front of the LL) 

	}

	public void insertAfter(Node givenNode, int d){

		if(givenNode == null){
			System.out.println("The given node cannot be null!");
			return; 
		}

		Node newNode = new Node(d);
		newNode.next = givenNode.next; // We're inserting the new node in *after* the given node. 
		givenNode.next = newNode;  // given node's next will be the new node, and new node's next will be whatever given node's next was.
	}

	public void insertAtEnd(int d){

		Node newNode = new Node(d);

		Node current = this.head; 

		while(current.next != null)
			current = current.next; 
		
		// current.next is null at this point. 
		current.next = newNode; 
		return; 

	}

	public boolean search(int d){

		Node curr = this.head; 

		while(curr != null){

			if(curr.data == d)
				return true; 
			
			curr = curr.next;	
		}

		return false; 
	}

	public int countOccurences(int d){

		Node curr = this.head; 
		int counter = 0; 

		while(curr != null){

			if(curr.data == d)
				counter++;

			curr = curr.next; 
		}

		return counter; 
	}

	public void sortedInsert(int d){

		Node newNode = new Node(d);

		if(this.head == null){
			this.head = newNode; 
			return; 
		}

		else if(this.head.data >= newNode.data){
			newNode.next = this.head; 
			this.head = newNode; 
		}
		else{
			Node curr = this.head; 

			while(curr.next != null && curr.next.data < newNode.data){
				curr = curr.next; 
			}
			// Now we insert element here, as it's either the correct place in the list (next node's data is larger) or it is the largest (next node is null)
			newNode.next = curr.next; 
			curr.next = newNode; 
		}


	}

	public void delete(int d){

		if(this.head == null){
			System.out.println("Nothing to delete!");
			return;
		}

		else if(this.head.data == d){
			this.head = this.head.next; 
		}

		else{
			Node curr = this.head; 
			Node prev = null; 

			while(curr != null && curr.data != d){
				prev = curr; 
				curr = curr.next; 
			}
			// Here when either curr is null or curr.data is d

			if(curr == null){
				System.out.println("Deletion key not found in list.");
				return; 
			}

			// Otherwise, we've found the key - Just switch previous node's next to current node's next.
			prev.next = curr.next; 

		}
	}




}