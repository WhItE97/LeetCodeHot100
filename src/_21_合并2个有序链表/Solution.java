package _21_�ϲ�2����������;

/**
 * ��Ŀ��
 * ��������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
 */
public class Solution {
	/**
	 * self˼·��
	 * ֱ��merge��vans
	 * TRICK��dummyαͷ�ڵ�
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
		//���l1��û����
		if(l1!=null) {
			node.next = l1;
		}
		//���l2��û����
		if(l2!=null) {
			node.next = l2;
		}
		return dummy.next;
    }
}
