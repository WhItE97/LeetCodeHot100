package _19_ɾ������ĵ�����n���ڵ�;

/**
 * ��Ŀ��
 * ����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣
 * ���ף����ܳ���ʹ��һ��ɨ��ʵ����
 * �����н�����ĿΪ sz
 * 1 <= sz <= 30
 * 1 <= n <= sz
 */
public class Solution {
	/**
	 * self˼·����1ms 20%..�����Ż����Լ������ͷ�ڵ����ۣ����鷳�ģ���һ��αͷ������Solution2��
	 * ˫ָ��
	 * 1.preָ����rightָ���߳�nλ֮����ͬ��Ų����ATT.Ҫ��pre��¼��ɾ���ڵ��pre�������ŷ������ɾ������
	 * 2.��rightָ�����һ���ڵ㣬ɾ��pre��next�ڵ�
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode right = head;
		ListNode pre = head;
		for(int i=0;i<n;i++) {
			right = right.next;
		}
		//��ATT sp�����ɾ������ͷ�ڵ㣬��ֱ��return head.next(��������2�������1.ֻ��һ���ڵ�ɾͷ�ڵ㣬return null��2.�ж���ڵ�ɾͷ�ڵ㣬return �ڶ����ڵ�)
		if(right==null) {
			return head.next;
		}
		//��������ʼͬ���ƶ�
		while(right.next!=null) {
			pre = pre.next;
			right = right.next;
		}
		//�ƶ����ɾ��pre��next
		pre.next = pre.next.next;
		return head;
    }
}
