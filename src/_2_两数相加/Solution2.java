package _2_�������;

public class Solution2 {
	/**
	 * �ٷ����selfʵ�֣���2ms 100%��
	 * ������ͷ��ʼ��һһ��ӣ�������λboolean
	 * ��TRICK 1.��ע�����˭���ˣ���Ĭ�ϲ�0�������ӷ�����
	 * ��ATT 1.������һλ������λ����Ҫ�����ڿ�ͷ��׷��һ��1��
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode hair = new ListNode(0);
		ListNode node = hair;
		int carry = 0;//��ʾ��λ
		//ֻҪ��һ��û�������Ͳ�Ҫֹͣ�Ӻ�
		while(l1!=null||l2!=null) {
			int tmp = 0;
			//������ǿ�
			if(l1!=null&&l2!=null) {
				tmp = l1.val + l2.val;
				l1 = l1.next;//��WRONG POINT. ��Ҫ�����޸�l1��l2ָ�룡��
				l2 = l2.next;
			}
			//�������ֻ��һ��Ϊ��
			else {
				tmp = (l1==null)?l2.val:l1.val;
				if(l1==null) {
					l2 = l2.next;
				}
				else {
					l1 = l1.next;
				}
			}
			tmp += carry;//������һ�ֵĽ�λ
			carry = (tmp>9)?1:0;//������һ�ֵĽ�λ
			tmp %= 10;
			node.next = new ListNode(tmp);
			node = node.next;
		}
		//���Ҫ���carry�Ƿ��У��еĻ�����ĩβ׷��һ��1�ڵ�
		if(carry==1) {
			node.next = new ListNode(1);
		}
		return hair.next;
    }
}
