package _2_两数相加;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Solution {
	/**
	 * self思路：【11ms 20%..弱智了..仔细读题啊..明明链表从头开始遍历，而开头都是个位！！所以直接一一相加即可..见Solution2】
	 * 1.对l1和l2采取：先压栈，再出栈，每位*10^k
	 * 2.求出两数之和，再写回一个新链表
	 * 3.【ATT应该考虑越界？->用String装数字】
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String num1 = getNum(l1);
		String num2 = getNum(l2);
		String sum = getSum(num1,num2);
		System.out.println("getSum结束，sum="+sum+",sum.char1="+(sum.charAt(0)-48));
		ListNode hair = new ListNode(0);
		ListNode node = hair;
		for(int i=sum.length()-1;i>=0;i--) {
			node.next = new ListNode(sum.charAt(i)-48);
			node = node.next;
			System.out.println("node.val="+node.val);
		}
		return hair.next;
    }
	
	//以String形式返回链表所代表的数
	public String getNum(ListNode node) {
		Deque<Integer> st = new LinkedList<>();
		while(node!=null) {
			st.push(node.val);
			node = node.next;
		}
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		System.out.println("getNum="+sb.toString());
		return sb.toString();
	}
	//输入两个String的数字，求和后以String返回
	public String getSum(String s1,String s2) {
		int l1 = s1.length()-1;
		int l2 = s2.length()-1;
		StringBuilder ret = new StringBuilder();
		boolean carry = false;//是否有进位
		while(l1>=0&&l2>=0) {
			//从末尾向前，每轮求一位的和
			int n1 = Integer.parseInt(s1.substring(l1, l1+1));
			int n2 = Integer.parseInt(s2.substring(l2, l2+1));
			int res = n1+n2;
			if(carry) {//求和的时候还要判断有没有进位
				res += 1;
			}
			//然后开始判断本轮是否产生进位
			if(res>=10) {
				carry =true;
			}
			else {
				carry = false;
			}
			//然后把本轮结果存入结果String的开头
			System.out.println("本轮sum，n1="+n1+",n2="+n2+",res="+res+",carry="+carry);
			ret.insert(0, res%10);
			System.out.println("本轮sum结束，插入ret的头位置后ret="+ret.toString());
			l1--;
			l2--;
		}
		//再把长度更大的那个的前缀插进来，但是也要注意判断有无进位
		if(l1>=0) {
			String pre = null;
			//如果还有进位
			if(carry) {
				System.out.println("s1.subString="+s1.substring(0, l1+1));
				pre = getSum(s1.substring(0, l1+1),"1");
			}
			else {
				pre = s1.substring(0,l1+1);
			}
			return pre+ret.toString();
		}
		if(l2>=0) {
			String pre = null;
			//如果还有进位
			if(carry) {
				pre = getSum(s2.substring(0, l2+1),"1");
			}
			else {
				pre = s2.substring(0,l2+1);
			}
			return pre+ret.toString();
		}
		else {//两个位数一样
			//【WRONG POINT.还是要考虑carry！直接加在开头！】
			if(carry) {
				ret.insert(0, 1);
			}
			return ret.toString();
		}
	}
}
