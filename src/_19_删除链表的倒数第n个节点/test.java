package _19_删除链表的倒数第n个节点;

public class test {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode res = new Solution2().removeNthFromEnd(n1, 5);
		while(res!=null) {
			System.out.print(res.val+" ");
			res = res.next;
		}
	}

}
