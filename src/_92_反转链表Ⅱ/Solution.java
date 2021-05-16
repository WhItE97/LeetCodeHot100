package _92_��ת�����;

public class Solution {
	/**
	* 2021/5/16
	* self˼·��
	* �ȱ��������ҵ�����ת�������pre,head��tail,post;Ȼ���head��tail��������з�ת���ٽ���ת�������ӻ�ԭ����
	* ��self˼·����ԣ�����һֱ��Сbug���ٷ�2trick��1.ʹ��dummy��������ͷ���ķ�ת 
	* 2.���õ�pre,head,tail,post֮,��head��tail��ԭ�����п���(�������ֱ�Ӳ�����������׳���)��
	*/
	public ListNode reverseBetween(ListNode head, int left, int right) {
        //base
        if(left==right){
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;

        //1.�ҵ��ĸ��ؼ��ڵ�
        ListNode pre = dummy;
        for(int i=1;i<left;i++){
            pre = pre.next;
        }
        ListNode nhead = pre.next;
        ListNode ntail = nhead;
        for(int i=left;i<right;i++){
            ntail = ntail.next;
        }
        ListNode post = ntail.next;

        //2.�Ͽ���������pre��post������
        pre.next = null;
        ntail.next = null;
        
        //3.��ת����
        ListNode node = reverse(nhead,ntail);
        pre.next = node;
        while(pre.next!=null){
            pre = pre.next;
        }
        pre.next = post;
        return dummy.next;
    }

    public ListNode reverse(ListNode head,ListNode tail){
        //base
        if(head==tail){
            return head;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head.next = null;
        return pre;
    }
}
