package _19_ɾ������ĵ�����n���ڵ�;

public class Solution2 {
	/**
	 * ˫ָ���Ż�˼·��
	 * ��TRICK������һ��αͷ�Ա㴦��ɾ������ͷ�ڵ㣡��0ms 100%����
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode right = pre;
		//��Ųn��right
		for(int i=0;i<n;i++) {
			right = right.next;
		}
		while(right.next!=null) {
			pre = pre.next;
			right = right.next;
		}
		//���ֱ��ɾ��pre��next
		pre.next = pre.next.next;
		return dummy.next;
    }
}
