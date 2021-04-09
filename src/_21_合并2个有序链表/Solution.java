package _21_合并2个有序链表;

/**
 * 题目：
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution {
	/**
	 * self思路：
	 * 直接merge就vans
	 * TRICK：dummy伪头节点
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		while(l1!=null&&l2!=null) {
			if(l1.val<l2.val) {
				node.next = l1;
				l1 = l1.next;
			}
			else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		//如果l1还没结束
		if(l1!=null) {
			node.next = l1;
		}
		//如果l2还没结束
		if(l2!=null) {
			node.next = l2;
		}
		return dummy.next;
    }
}
