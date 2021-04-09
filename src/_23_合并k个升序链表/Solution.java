package _23_合并k个升序链表;

/**
 * 题目：
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Solution {
	/**
	 * self思路：【1ms 100%】
	 * 归并思想进行merge，【IMP时间复杂度的计算】【第一轮合并k/2组链表，每一组时间代价是2n；第二轮合并k/4组链表，每一组时间代价是4n——>共logk轮——>时间复杂度=nklogk】
	 * 首先对ListNode数组进行拆分，拆成一条一条的再merge
	 * 【写起来还不够熟练】
	 * 1.split(ListNode[] lists,int start,int end)用来递归拆分，只要start还<end，就继续拆分；
	 * 并且每次拆分后都要记录下返回值leftNode和rightNode！获取到该轮leftNode和rightNode后，要把该两个Node merge起来return回去！
	 * 2.merge(ListNode left,ListNode right)只负责merge2个有序链表并return回去
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		//base
		if(lists.length==0) {
			return null;
		}
		return split(lists,0,lists.length-1);
    }
	
	public ListNode split(ListNode[] lists,int start,int end) {
		if(start<end) {
			int mid = (start+end)/2;
			ListNode left = split(lists,start,mid);
			ListNode right = split(lists,mid+1,end);
			return merge(left,right);
		}
		else if(start==end) {
			return lists[start];
		}
		else {
			return null;
		}
	}
	
	public ListNode merge(ListNode left,ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		while(left!=null&&right!=null) {
			if(left.val<right.val) {
				node.next = left;
				left = left.next;
			}
			else {
				node.next = right;
				right = right.next;
			}
			node = node.next;
		}
		node.next = (left==null)?right:left;
		return dummy.next;
	}
}
