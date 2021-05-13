package _148_��������;

/**
 * ��Ŀ��
 * ���������ͷ��� head ���뽫�䰴 ���� ���в����� ���������� ��
 * ������� O(nlogn) ʱ�临�ӶȺͳ������ռ临�Ӷ��£����������������
 */
public class Solution {
	/**
	 * self˼·��
	 * O(NlogN)����>�鲢
	 * ����û�뵽��ô����split..��ֻ���뵽������������Ⱥ���ȡ�е�WRONG!����ָ��!��
	 * 
	 * �ٷ����selfʵ�֣���ʱ��O(NlogN)���ǿռ�����ջ�ݹ�ﵽ��O(logN)...O(1)�ռ��Solution2��
	 * ����ָ�룡һ����2����һ����1����
	 * ���Ǵ�������HDP��
	 * 1.�ݹ�split��ʱ�򣬲�ɵ��ڵ��������next�ÿգ���������ĵ��ڵ㣡����merge�����⣨���ܳɻ�ɶ�ģ�
	 * 2.split���������е�Ĵ������׳����⣨��ȡ���е�ȡΪ���ε�head��ÿ��split��tailȡΪ��list�ĵ�һ�����ɴ�Ԫ�أ�
	 */
	public ListNode sortList(ListNode head) {
		return mergeSort(head,null);
    }
	//��HDP.��split��ʱ�򣬲𵽵��ڵ��ʱ�򣬱��뽫��next�ÿգ���Ϊ�Ѿ��ݹ������ˣ�ԭ����ָ���û���ˣ���Ȼ����merge���鷳��
	//ȡtailΪnull���������Ͳ�����������������tail�ˣ�����������Ӧ�����head.next==tail��˵���Ѿ�����ĩβ�ˣ�
	public ListNode mergeSort(ListNode head,ListNode tail) {
		if(head==null) {
			return null;
		}
		if(head.next == tail) {
			head.next = null;//���Լ�һֱ����ĵ������һ������������һ���Ĵ�����
			return head;
		}
		else{//˵�������Լ�����֡�HHHDDDPPP.����Ĳ��������е�Ĵ��룬�����״�->����õ��Ľ��slowָ��ڶ���Ŀ�ͷ����
			ListNode slow = head;
			ListNode fast = head;
			while(fast!=tail) {//��1.����ѭ��������fast�Ƿ񵽴�tail��
				slow = slow.next;
				fast = fast.next;
				if(fast!=tail) {//��2.����fast��һ��ѭ���е�2��next��Ҫ�𿪣�ʱ��check fast�Ƿ񵽴�tail����
					fast = fast.next;
				}
			}
			ListNode list1 = mergeSort(head,slow);
			ListNode list2 = mergeSort(slow,tail);
			return merge(list1,list2);
		}
	}
	
	//��Ϊ�ڵݹ�split��ʱ�򣬾��Ѿ���ÿ�����ڵ��next����Ϊnull�ˣ�����merge��ʱ��ֻ��care����list���Ƿ��ߵ�null����>�����ж�������list�Ƿ��������
	//���ǵ����������޹������merge
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
