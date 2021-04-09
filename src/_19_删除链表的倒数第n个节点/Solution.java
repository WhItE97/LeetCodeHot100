package _19_删除链表的倒数第n个节点;

/**
 * 题目：
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 1 <= n <= sz
 */
public class Solution {
	/**
	 * self思路：【1ms 20%..可以优化！自己这里对头节点讨论，蛮麻烦的！加一个伪头撒！见Solution2】
	 * 双指针
	 * 1.pre指针在right指针走出n位之后再同步挪动【ATT.要用pre记录待删除节点的pre！这样才方便后续删除！】
	 * 2.当right指到最后一个节点，删除pre的next节点
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode right = head;
		ListNode pre = head;
		for(int i=0;i<n;i++) {
			right = right.next;
		}
		//【ATT sp】如果删除的是头节点，则直接return head.next(这里会出现2种情况：1.只有一个节点删头节点，return null；2.有多个节点删头节点，return 第二个节点)
		if(right==null) {
			return head.next;
		}
		//接下来开始同步移动
		while(right.next!=null) {
			pre = pre.next;
			right = right.next;
		}
		//移动完后删除pre的next
		pre.next = pre.next.next;
		return head;
    }
}
