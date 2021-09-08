
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

		System.out.println(second.prev.data);
		System.out.println(second.next.data);
		System.out.println(third.prev.data);
		System.out.println(third.prev.prev.data);



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
		// TODO
	}

	public void insertAtEnd(int d){
		// TODO
	}

	public void insertBefore(D_Node node, int d){
		// TODO
	}

	public void delete(int d){
		// TODO
	}
}