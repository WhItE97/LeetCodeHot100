package _92_反转链表Ⅱ;

public class Solution {
	/**
	* 2021/5/16
	* self思路：
	* 先遍历链表找到待翻转子链表的pre,head和tail,post;然后对head到tail的链表进行翻转，再将翻转后的链表接回原链表
	* 【self思路大体对，但是一直有小bug：官方2trick！1.使用dummy避免讨论头结点的翻转 
	* 2.在拿到pre,head,tail,post之,把head到tail和原链表切开！(方便后续直接插回来而不容易出错！)】
	*/
	public ListNode reverseBetween(ListNode head, int left, int right) {
        //base
        if(left==right){
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;

        //1.找到四个关键节点
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

        //2.断开子链表与pre和post的连接
        pre.next = null;
        ntail.next = null;
        
        //3.翻转链表
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
