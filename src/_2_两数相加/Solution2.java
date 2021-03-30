package _2_两数相加;

public class Solution2 {
	/**
	 * 官方题解self实现：【2ms 100%】
	 * 从链表头开始，一一相加，给个进位boolean
	 * 【TRICK 1.】注意如果谁短了，就默认补0继续做加法即可
	 * 【ATT 1.如果最后一位产生进位，不要忘了在开头再追加一个1】
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode hair = new ListNode(0);
		ListNode node = hair;
		int carry = 0;//表示进位
		//只要有一个没结束，就不要停止加和
		while(l1!=null||l2!=null) {
			int tmp = 0;
			//如果都非空
			if(l1!=null&&l2!=null) {
				tmp = l1.val + l2.val;
				l1 = l1.next;//【WRONG POINT. 不要忘了修改l1和l2指针！】
				l2 = l2.next;
			}
			//如果有且只有一个为空
			else {
				tmp = (l1==null)?l2.val:l1.val;
				if(l1==null) {
					l2 = l2.next;
				}
				else {
					l1 = l1.next;
				}
			}
			tmp += carry;//加上上一轮的进位
			carry = (tmp>9)?1:0;//更新这一轮的进位
			tmp %= 10;
			node.next = new ListNode(tmp);
			node = node.next;
		}
		//最后要检查carry是否还有，有的话就在末尾追加一个1节点
		if(carry==1) {
			node.next = new ListNode(1);
		}
		return hair.next;
    }
}
