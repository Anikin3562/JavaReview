import java.util.*; 

@SuppressWarnings("unchecked")
public class TestingGraph{

	public static void main(String[] args){
		java.util.LinkedList<Integer>[] list;

		list = new java.util.LinkedList[5];

		for(int i = 0; i < 5; i++){
			list[i] = new java.util.LinkedList<Integer>();
		}

		list[0].push(1);
		list[0].push(2);
		list[0].push(3);

		for(int i: list[0]){
			System.out.println(i);
		}

		list[1].addFirst(1);
		list[1].addFirst(2);
		list[1].addFirst(3);

		for(int i: list[1]){
			System.out.println(i);
		}

		PriorityQueue<int[]> pQ = new PriorityQueue<int[]>();

		int[] arr0 = {0, 5};
		int[] arr1 = {1, 15};
		int[] arr2 = {2, 2};
		int[] arr3 = {3, 4};
		int[] arr4 = {4, 8};

		PriorityQueue<int[]> heap = new PriorityQueue(2, (a, b) -> ((int[])a)[1] - ((int[])b)[1]);

		heap.add(arr0);
		heap.add(arr1);
		heap.add(arr2);
		heap.add(arr3);
		heap.add(arr4);

		System.out.println("Front of PriorityQueue: " + heap.peek()[0]);

		arr0[1] = 1; 

		System.out.println("Front of PriorityQueue: " + heap.peek()[0]);

		Set<Integer> s = new HashSet<Integer>(); 

		s.add(1);
		s.add(2);

		System.out.println(s.contains(3));


	}
}