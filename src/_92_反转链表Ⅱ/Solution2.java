package _92_反转链表Ⅱ;

public class Solution2 {
    /**
	 * 【稳定一次遍历！头插法！】
	 * 思路：
	 * pre永远指向子链表的前一个，curr指向子链表第一个元素（然后curr也一直固定指这个元素！）
	 * 每轮把curr后面的挪到子链表的开头，循环次数通过for(right-left)=curr后面要往前插入的节点个数来确定【画图理解指针的变换步骤！】
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode pre = dummy;
		//1.找到不变的pre
		for(int i=1;i<left;i++) {
			pre = pre.next;
		}
		//2.curr指向子链表的首个元素（即之后的最后一个元素），开始每次头插一个
		ListNode curr = pre.next;
		for(int i=left;i<right;i++) {//头插次数=right-left
			ListNode next = curr.next;
			curr.next = next.next;
            ListNode prenext = pre.next;
			pre.next = next;
			next.next = prenext;
		}
		return dummy.next;
    }
}
