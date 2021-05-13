package _148_排序链表;

public class Solution2 {
	/**
	 * O(NlogN)时间+O(1)空间【主要记for里面的思路吧..自己的代码写的也挺乱的...】
	 * 自底向上，通过for实现一开始以len=1排序，然后len=2，然后len=4...直到len>=list.len
	 */
	public ListNode sortList(ListNode head) {
		ListNode dummy = new ListNode(0,head);
		ListNode tmp = head;//用于求链表长度
		int listlen = 0;
		while(tmp!=null) {
			listlen++;
			tmp = tmp.next;
		}
		for(int len=1;len<listlen;len<<=1) {//每次merge的len都要double
			//【HDP.官方思路】
			//1.prev和next记录本轮merge的两段的前一个节点和后一个节点（用于merge该两段后，将result接回原链表）
			//2.curr记录当前节点，用于分割list1和list2&&作为结束条件的判断
			//3-1.head1 = curr;通过curr先找到list1的末尾节点，然后记录下head2=list1末尾节点.next;然后【将curr.next置空（别忘了）】！
			//3-2.curr=head2(将curr移动到head2);通过curr找到list2的末尾节点，记录下next=list2末尾节点.next,然后将其置空！
			//4.merge list1和list2
			//5.pre.next=result;result.next=next;
			//6.更新prev=result.last,curr=prev.next;
			ListNode prev = dummy;
			ListNode curr = dummy.next;
			
			while(curr!=null) {
				ListNode head1 = curr;
				for(int i=1;i<len&&curr!=null&&curr.next!=null;i++) {//【HDP.curr可能不够该轮len那么长！要考虑这种情况！】
					curr = curr.next;
				}//now curr指向list1的最后一个节点了
				ListNode head2 = (curr==null)?null:curr.next;//【HDP.curr可能不够该轮len那么长！要考虑这种情况！】
				curr.next = null;
				curr = head2;
				
				for(int i=1;i<len&&curr!=null;i++) {//【HDP.curr可能不够该轮len那么长！要考虑这种情况！】
					curr = curr.next;
				}//now curr指向list2的最后一个节点了
				ListNode next = null;
				if(curr!=null) {
					next = curr.next;//保存next
					curr.next = null;
				}
				
				ListNode result = merge(head1,head2);
				
				//连回原链表
				//1.prev的连接
				prev.next = result;
				//2.next的连接
				//找到result的尾节点
				while(result.next!=null) {
					result = result.next;
				}
				result.next = next;
				
				//更新prev和curr，进入下一轮
				prev = result;
				curr = prev.next;
			}
		}
		
		return dummy.next;
    }
	//返回merge后的链表的头结点
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
