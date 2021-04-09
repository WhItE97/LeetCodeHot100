package _23_合并k个升序链表;

import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		n1.next = n3;
		n3.next = n5;
		n5.next = n8;
		//
		n2.next = n4;
		//
		n6.next = n7;
		//
		ListNode n9 = null;
		ListNode[] lists = new ListNode[] {n9};
		Solution2 s = new Solution2();
		ListNode res = s.mergeKLists(lists);
		while(res!=null) {
			System.out.print(res.val+" ");
			res = res.next;
		}
//		PriorityQueue<Integer> queue = new PriorityQueue<>();
//		queue.offer(2);
//		queue.offer(5);
//		queue.offer(3);
//		while(!queue.isEmpty()) {
//			System.out.println(queue.poll());
//		}
	}

}
