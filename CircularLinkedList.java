// Do all of this later

public class CircularLinkedList{

	Node head;

	public static void main(String[] args){

		CircularLinkedList myList = new CircularLinkedList();

		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		myList.head = first; 

		first.next = second; 
		second.next = third; 
		third.next = myList.head;  

		myList.printList();

		myList.insertAfter(third, 4);

		myList.printList();

		myList.delete(1);

		myList.printList();

		myList.delete(3);

		myList.printList();

		myList.insertAfter(myList.head, 3);

		myList.printList();

		myList.delete(2);

		myList.printList();

		myList.delete(3);

		myList.printList();

		myList.insertAfter(myList.head, 5);

		myList.printList();
	}

	public void printList(){
		Node curr = this.head; 
		Node stoppingPt = this.head; 

		do{
			System.out.print(curr.data + "->");
			curr = curr.next; 

		}while(curr != stoppingPt);

		System.out.println("repeat");
	}

	public void insertAfter(Node prev, int d){
		
		if(prev == null) return; 
		
		Node newNode = new Node(d);

		newNode.next = prev.next; 
		prev.next = newNode;

	}

	public void delete(int d){
		Node curr = this.head; 
		Node prev = this.head; 

		if(this.head.data == d){
			// New Head
			curr = curr.next; 
			while(curr.next != this.head){
				curr = curr.next; 
			} 
			// curr is node which points to head
			this.head = this.head.next; 
			curr.next = this.head;  

			return; 
		}

		// Otherwise
		do{

			if(curr.data == d){
				prev.next = curr.next; 
				return; 
			}

			prev = curr; 
			curr = curr.next;

		}while(curr != this.head);

	}




}