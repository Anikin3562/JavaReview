
public class DoublyLinkedList{

	D_Node head; 

	public static void main(String[] args){

		DoublyLinkedList myList = new DoublyLinkedList();

		myList.head = new D_Node(1);
		D_Node second = new D_Node(2);
		D_Node third = new D_Node(3);

		myList.head.next = second; 
		second.next = third; 

		second.prev = myList.head; 
		third.prev = second; 

		myList.printList();

		myList.insertAfter(second, 2);
		myList.printList();

		//System.out.println(second.prev.data);
		//System.out.println(second.next.data);
		//System.out.println(third.prev.data);
		//System.out.println(third.prev.prev.data);

		myList.insertAtFront(0);
		myList.printList();

		System.out.println(myList.head.data);
		System.out.println(myList.head.next.data);
		System.out.println(myList.head.next.prev.data);

		myList.insertAtEnd(4);
		myList.printList();

		myList.insertBefore(second, 1);
		myList.printList();

		myList.delete(1);
		myList.printList();

		myList.delete(1);
		myList.printList();

		myList.delete(1);
		myList.printList();

		myList.delete(2);
		myList.printList();

		myList.insertAfter(myList.head, 1);
		myList.printList();

	}

	public void insertAfter(D_Node prev, int d){

		if(prev == null){
			System.out.println("Given previous node cannot be null!");
			return; 
		}

		D_Node newNode = new D_Node(d);

		newNode.next = prev.next; 

		prev.next = newNode; 

		newNode.prev = prev;

		if(newNode.next != null)
			newNode.next.prev  = newNode; 
	}

	public void printList(){
		D_Node current = this.head; 
		
		while(current != null){
			System.out.print(current.data + " -> ");
			current = current.next; 
		}	

		System.out.println("null");
	}

	public void insertAtFront(int d){

		D_Node front = this.head; 
		D_Node newNode = new D_Node(d);

		// Just need to adjust links
		newNode.next = front; 
		front.prev = newNode;

		this.head = newNode; 


	}

	public void insertAtEnd(int d){
		// TODO
		D_Node curr = this.head; 
		D_Node newNode = new D_Node(d);

		while(curr.next != null){
			curr = curr.next; 
		}

		curr.next = newNode; 
		newNode.prev = curr;  

	}

	public void insertBefore(D_Node node, int d){
		// TODO
		D_Node newNode = new D_Node(d);
		D_Node curr = this.head; 

		while(curr != null && curr != node){
			curr = curr.next; 
		}
		if (curr == null) return; 
		
		// curr == node
		newNode.prev = curr.prev;
		curr.prev.next = newNode; 
		curr.prev = newNode;
		newNode.next = curr; 

	}

	public void delete(int d){
		// TODO
		
		D_Node curr = this.head; 

		while(curr != null && curr.data != d){
			curr = curr.next; 
		}

		if(curr == null) return; 

		// Unlinking curr
		curr.prev.next = curr.next; 
		curr.next.prev = curr.prev; 


	}
}