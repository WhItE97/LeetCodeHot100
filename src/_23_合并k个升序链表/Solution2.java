package _23_�ϲ�k����������;

import java.util.PriorityQueue;
import java.util.Comparator;
public class Solution2 {
	/**
	 * ���ⷨ2.���ȶ��С���HDP.PriorityQueueĬ���ǣ�С���ѣ�ÿ��poll��С�ģ���
	 * ˼·��
	 * ά��һ�����ȶ��У���ÿ�������head���ŵ�������ȶ����У�ÿ��ȡһ����С�ģ�Ȼ��ȡ���Ժ������ָ�����
	 */
	//��1.��Ҫ�����Զ�����ıȽ�������
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
		PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);//��2.HDP������[�Զ���������ȶ���]����ʹ��[�Զ���Ƚ���]�Ĺ��췽�����������ȶ��У���
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		for(int i=0;i<lists.length;i++) {
			if(lists[i]==null) {//��WRONG POINT��С�İ���null�ͱ���밡��
				continue;
			}
			queue.offer(lists[i]);
		}
		while(!queue.isEmpty()) {
			ListNode tmp = queue.poll();
			node.next = tmp;
			node = node.next;
			//��Ҫ�ѱ��ֳ��ӵ��������һ���ڵ�����С����
			tmp = tmp.next;
			if(tmp!=null) {
				queue.offer(tmp);
			}
		}
		return dummy.next;
    }
}
