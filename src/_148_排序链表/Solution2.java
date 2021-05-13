package _148_��������;

public class Solution2 {
	/**
	 * O(NlogN)ʱ��+O(1)�ռ䡾��Ҫ��for�����˼·��..�Լ��Ĵ���д��Ҳͦ�ҵ�...��
	 * �Ե����ϣ�ͨ��forʵ��һ��ʼ��len=1����Ȼ��len=2��Ȼ��len=4...ֱ��len>=list.len
	 */
	public ListNode sortList(ListNode head) {
		ListNode dummy = new ListNode(0,head);
		ListNode tmp = head;//������������
		int listlen = 0;
		while(tmp!=null) {
			listlen++;
			tmp = tmp.next;
		}
		for(int len=1;len<listlen;len<<=1) {//ÿ��merge��len��Ҫdouble
			//��HDP.�ٷ�˼·��
			//1.prev��next��¼����merge�����ε�ǰһ���ڵ�ͺ�һ���ڵ㣨����merge�����κ󣬽�result�ӻ�ԭ����
			//2.curr��¼��ǰ�ڵ㣬���ڷָ�list1��list2&&��Ϊ�����������ж�
			//3-1.head1 = curr;ͨ��curr���ҵ�list1��ĩβ�ڵ㣬Ȼ���¼��head2=list1ĩβ�ڵ�.next;Ȼ�󡾽�curr.next�ÿգ������ˣ�����
			//3-2.curr=head2(��curr�ƶ���head2);ͨ��curr�ҵ�list2��ĩβ�ڵ㣬��¼��next=list2ĩβ�ڵ�.next,Ȼ�����ÿգ�
			//4.merge list1��list2
			//5.pre.next=result;result.next=next;
			//6.����prev=result.last,curr=prev.next;
			ListNode prev = dummy;
			ListNode curr = dummy.next;
			
			while(curr!=null) {
				ListNode head1 = curr;
				for(int i=1;i<len&&curr!=null&&curr.next!=null;i++) {//��HDP.curr���ܲ�������len��ô����Ҫ���������������
					curr = curr.next;
				}//now currָ��list1�����һ���ڵ���
				ListNode head2 = (curr==null)?null:curr.next;//��HDP.curr���ܲ�������len��ô����Ҫ���������������
				curr.next = null;
				curr = head2;
				
				for(int i=1;i<len&&curr!=null;i++) {//��HDP.curr���ܲ�������len��ô����Ҫ���������������
					curr = curr.next;
				}//now currָ��list2�����һ���ڵ���
				ListNode next = null;
				if(curr!=null) {
					next = curr.next;//����next
					curr.next = null;
				}
				
				ListNode result = merge(head1,head2);
				
				//����ԭ����
				//1.prev������
				prev.next = result;
				//2.next������
				//�ҵ�result��β�ڵ�
				while(result.next!=null) {
					result = result.next;
				}
				result.next = next;
				
				//����prev��curr��������һ��
				prev = result;
				curr = prev.next;
			}
		}
		
		return dummy.next;
    }
	//����merge��������ͷ���
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
