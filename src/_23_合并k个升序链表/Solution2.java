package _23_合并k个升序链表;

import java.util.PriorityQueue;
import java.util.Comparator;
public class Solution2 {
	/**
	 * 【解法2.优先队列】【HDP.PriorityQueue默认是：小根堆！每次poll最小的！】
	 * 思路：
	 * 维护一个优先队列，把每个链表的head都放到这个优先队列中，每次取一个最小的；然后将取了以后的链表指针后移
	 */
	//【1.先要定义自定义类的比较器！】
	static Comparator<ListNode> comparator = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode n1,ListNode n2) {
			return n1.val-n2.val;
		}
	};
	public ListNode mergeKLists(ListNode[] lists) {
		//base
		if(lists.length==0) {
			return null;
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);//【2.HDP！！！[自定义类的优先队列]必须使用[自定义比较器]的构造方法来构造优先队列！】
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		for(int i=0;i<lists.length;i++) {
			if(lists[i]==null) {//【WRONG POINT】小心啊，null就别插入啊！
				continue;
			}
			queue.offer(lists[i]);
		}
		while(!queue.isEmpty()) {
			ListNode tmp = queue.poll();
			node.next = tmp;
			node = node.next;
			//还要把本轮出队的链表的下一个节点输入小根堆
			tmp = tmp.next;
			if(tmp!=null) {
				queue.offer(tmp);
			}
		}
		return dummy.next;
    }
}
