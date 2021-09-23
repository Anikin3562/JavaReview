
public class DoublyCircularLinkedList{

	D_Node head; 

	public static void main(String[] args){

		DoublyCircularLinkedList myList = new DoublyCircularLinkedList();

		D_Node first = new D_Node(1);
		D_Node second = new D_Node(2);
		D_Node third = new D_Node(3);

		myList.head = first;

		myList.head.next = second; 
		second.next = third; 
		third.next = myList.head; 

		myList.head.prev = third;  
		second.prev = myList.head;
		third.prev = second;  

		myList.printList();

		myList.insertAfter(second, 4);
		myList.printList();

		myList.delete(1);
		myList.printList();
		
		myList.delete(4);
		myList.printList();

		myList.insertAfter(myList.head.next, 4);
		myList.printList();

		myList.insertAfter(myList.head.next.next, 5);
		myList.printList();

		myList.insertAtFront(1);
		myList.printList();

		System.out.println(myList.search(5));
		System.out.println(myList.search(9));

		myList.printBackwards();

	}

	public void printList(){
		D_Node curr = this.head; 
		

		do{
			System.out.print(curr.data + "<->");
			curr = curr.next; 

		}while(curr != this.head);

		System.out.println("repeat");
	}

	public void printBackwards(){
		D_Node curr = this.head.prev; 

		do{
			System.out.print(curr.data + "<->");
			curr = curr.prev;
		}while(curr != this.head.prev);
		
		System.out.println("repeat");
	}

	public void insertAfter(D_Node prev, int d){

		if(prev == null) return; 

		D_Node newNode = new D_Node(d);

		newNode.next = prev.next;
		newNode.prev = prev; 

		newNode.next.prev = newNode; 
		prev.next = newNode;

	}

	public void insertAtFront(int d){
		D_Node newNode = new D_Node(d);

		if(this.head == null){
			this.head = newNode; 
			return; 
		} 

		D_Node headPrev = this.head.prev; 
		D_Node prevHead = this.head; 

		this.head = newNode; 
		this.head.next = prevHead;
		this.head.prev = headPrev;

		prevHead.prev = this.head; 
		headPrev.next = this.head; 

	}

	public void delete(int d){

		if(this.head == null) return; 

		D_Node curr = this.head; 

		do{

			if(this.head.data == d){
				D_Node temp = this.head.prev;

				this.head = this.head.next;
				this.head.prev = temp; 

				temp.next = this.head; 

				break;
			}

			else if(curr.data == d){
				// Unlink Curr
				curr.prev.next = curr.next; 
				curr.next.prev = curr.prev; 
				break; 
			}

			curr = curr.next; 

		}while(curr != this.head);

	}

	// Returns true if d found in list
	public boolean search(int d){

		D_Node curr = this.head; 

		do{
			if(curr.data == d) return true; 

			curr=curr.next; 

		}while(curr != this.head);	
	
		return false; 
	}


}