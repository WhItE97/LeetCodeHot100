package _148_排序链表;

/**
 * 题目：
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 你可以在 O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class Solution {
	/**
	 * self思路：
	 * O(NlogN)——>归并
	 * 但是没想到怎么快速split..（只能想到遍历求出链表长度后再取中点WRONG!快慢指针!）
	 * 
	 * 官方题解self实现：【时间O(NlogN)但是空间由于栈递归达到了O(logN)...O(1)空间见Solution2】
	 * 快慢指针！一个走2步，一个走1步！
	 * 还是存在两个HDP：
	 * 1.递归split的时候，拆成单节点后必须把其next置空！搞成真正的单节点！以免merge出问题（可能成环啥的）
	 * 2.split查找链表中点的代码容易出问题（采取①中点取为后半段的head②每次split的tail取为该list的第一个不可达元素）
	 */
	public ListNode sortList(ListNode head) {
		return mergeSort(head,null);
    }
	//【HDP.在split的时候，拆到单节点的时候，必须将其next置空！因为已经递归拆分完了，原来的指针就没用了！不然后续merge很麻烦】
	//取tail为null这样这样就不用在主函数里先求tail了！所以这里相应的如果head.next==tail就说明已经到达末尾了！
	public ListNode mergeSort(ListNode head,ListNode tail) {
		if(head==null) {
			return null;
		}
		if(head.next == tail) {
			head.next = null;//【自己一直出错的点就在这一步，忽略了这一步的处理！】
			return head;
		}
		else{//说明还可以继续拆分【HHHDDDPPP.这里的查找链表中点的代码，很容易错->这里得到的结果slow指向第二组的开头！】
			ListNode slow = head;
			ListNode fast = head;
			while(fast!=tail) {//【1.结束循环条件：fast是否到达tail】
				slow = slow.next;
				fast = fast.next;
				if(fast!=tail) {//【2.并且fast在一轮循环中的2次next需要拆开！时刻check fast是否到达tail！】
					fast = fast.next;
				}
			}
			ListNode list1 = mergeSort(head,slow);
			ListNode list2 = mergeSort(slow,tail);
			return merge(list1,list2);
		}
	}
	
	//因为在递归split的时候，就已经把每个单节点的next都置为null了！所以merge的时候只用care两条list【是否走到null——>用以判断这两条list是否结束】！
	//就是单纯的两条无关联表的merge
	public ListNode merge(ListNode head1,ListNode head2) {
		ListNode node = new ListNode();
		ListNode dummy = node;

		while(head1!=null&&head2!=null) {
			if(head1.val<head2.val) {
				node.next = head1;
				head1 = head1.next;
			}
			else {
				node.next = head2;
				head2 = head2.next;
			}
			node = node.next;
		}
		
		if(head1!=null) {
			node.next = head1;
		}
		if(head2!=null) {
			node.next = head2;
		}
		return dummy.next;
	}
}
