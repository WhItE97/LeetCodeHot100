package _2_�������;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��Ŀ��
 * �������� �ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ��� ���� �ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
 * ���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
 * ����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
 */
public class Solution {
	/**
	 * self˼·����11ms 20%..������..��ϸ���Ⱑ..���������ͷ��ʼ����������ͷ���Ǹ�λ��������ֱ��һһ��Ӽ���..��Solution2��
	 * 1.��l1��l2��ȡ����ѹջ���ٳ�ջ��ÿλ*10^k
	 * 2.�������֮�ͣ���д��һ��������
	 * 3.��ATTӦ�ÿ���Խ�磿->��Stringװ���֡�
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String num1 = getNum(l1);
		String num2 = getNum(l2);
		String sum = getSum(num1,num2);
		System.out.println("getSum������sum="+sum+",sum.char1="+(sum.charAt(0)-48));
		ListNode hair = new ListNode(0);
		ListNode node = hair;
		for(int i=sum.length()-1;i>=0;i--) {
			node.next = new ListNode(sum.charAt(i)-48);
			node = node.next;
			System.out.println("node.val="+node.val);
		}
		return hair.next;
    }
	
	//��String��ʽ�����������������
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
	//��������String�����֣���ͺ���String����
	public String getSum(String s1,String s2) {
		int l1 = s1.length()-1;
		int l2 = s2.length()-1;
		StringBuilder ret = new StringBuilder();
		boolean carry = false;//�Ƿ��н�λ
		while(l1>=0&&l2>=0) {
			//��ĩβ��ǰ��ÿ����һλ�ĺ�
			int n1 = Integer.parseInt(s1.substring(l1, l1+1));
			int n2 = Integer.parseInt(s2.substring(l2, l2+1));
			int res = n1+n2;
			if(carry) {//��͵�ʱ��Ҫ�ж���û�н�λ
				res += 1;
			}
			//Ȼ��ʼ�жϱ����Ƿ������λ
			if(res>=10) {
				carry =true;
			}
			else {
				carry = false;
			}
			//Ȼ��ѱ��ֽ��������String�Ŀ�ͷ
			System.out.println("����sum��n1="+n1+",n2="+n2+",res="+res+",carry="+carry);
			ret.insert(0, res%10);
			System.out.println("����sum����������ret��ͷλ�ú�ret="+ret.toString());
			l1--;
			l2--;
		}
		//�ٰѳ��ȸ�����Ǹ���ǰ׺�����������ҲҪע���ж����޽�λ
		if(l1>=0) {
			String pre = null;
			//������н�λ
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
			//������н�λ
			if(carry) {
				pre = getSum(s2.substring(0, l2+1),"1");
			}
			else {
				pre = s2.substring(0,l2+1);
			}
			return pre+ret.toString();
		}
		else {//����λ��һ��
			//��WRONG POINT.����Ҫ����carry��ֱ�Ӽ��ڿ�ͷ����
			if(carry) {
				ret.insert(0, 1);
			}
			return ret.toString();
		}
	}
}
