package _92_��ת�����;

public class Solution2 {
    /**
	 * ���ȶ�һ�α�����ͷ�巨����
	 * ˼·��
	 * pre��Զָ���������ǰһ����currָ���������һ��Ԫ�أ�Ȼ��currҲһֱ�̶�ָ���Ԫ�أ���
	 * ÿ�ְ�curr�����Ų��������Ŀ�ͷ��ѭ������ͨ��for(right-left)=curr����Ҫ��ǰ����Ľڵ������ȷ������ͼ���ָ��ı任���裡��
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode pre = dummy;
		//1.�ҵ������pre
		for(int i=1;i<left;i++) {
			pre = pre.next;
		}
		//2.currָ����������׸�Ԫ�أ���֮������һ��Ԫ�أ�����ʼÿ��ͷ��һ��
		ListNode curr = pre.next;
		for(int i=left;i<right;i++) {//ͷ�����=right-left
			ListNode next = curr.next;
			curr.next = next.next;
            ListNode prenext = pre.next;
			pre.next = next;
			next.next = prenext;
		}
		return dummy.next;
    }
}
