package _19_删除链表的倒数第n个节点;

public class Solution2 {
	/**
	 * 双指针优化思路：
	 * 【TRICK】创建一个伪头以便处理删除的是头节点！【0ms 100%！】
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode right = pre;
		//先挪n次right
		for(int i=0;i<n;i++) {
			right = right.next;
		}
		while(right.next!=null) {
			pre = pre.next;
			right = right.next;
		}
		//最后直接删除pre的next
		pre.next = pre.next.next;
		return dummy.next;
    }
}
