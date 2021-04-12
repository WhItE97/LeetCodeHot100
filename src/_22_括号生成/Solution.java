package _22_��������;

import java.util.List;
import java.util.Deque;
import java.util.LinkedList;
/**
 * ��Ŀ��
 * ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
 * 1 <= n <= 8
 */
public class Solution {
	/**
	 * self˼·����WRONG.û��ͨ��д��̫�����ˡ�������û�������ź�������ʣ����Ŀָ���д������д����Solution2��
	 * 2��ջ��һ��װ�����ţ�һ��װ�����š���������ų�ջ��k�������ſ���ѡ���0~k������>dfs
	 */
	public List<String> generateParenthesis(int n) {
		Deque<Character> st1 = new LinkedList<>();
		Deque<Character> st2 = new LinkedList<>();
		for(int i=0;i<n;i++) {
			st1.push('(');
			st2.push(')');
		}
		dfs(st1,st2);
		return res;
    }
	
	List<String> res = new LinkedList<>();
	StringBuilder sb = new StringBuilder();
	
	public void dfs(Deque<Character> st1,Deque<Character> st2) {
		//1.��������
		if(st1.isEmpty()&&st2.isEmpty()) {
			res.add(sb.toString());
			return;
		}
		//2.dfs
		int gap = st2.size()-st1.size();
		System.out.println("gap="+gap);
		if(gap<0) {//1.˵�������ű������Ż����ˣ��ز�����
			return;
		}
		else if(gap==0) {//2.˵���������ŵ�ǰǰ��Ķ�match������һ�ֱ������������
			//(1)��ѡ��
			sb.append(st1.pop());
			//(2)dfs
			dfs(st1,st2);
			//(3)����ѡ��
			sb.delete(sb.length()-1, sb.length());
			st1.push('(');
		}
		else {//3.�����ű������Ŷ࣬�����������ж���֧·����ѡ(������������ŵ�ջ�Ѿ����ˣ������ŵ�ջ�ͱ���ȫ���ˣ�)
			for(int i=(st1.isEmpty())?1:0;i<=gap;i++) {
				//(1)��ѡ��
				for(int j=0;j<i;j++) {
					sb.append(st2.pop());
				}
				//(2)dfs
				dfs(st1,st2);
				//(3)����ѡ��
				sb.delete(sb.length()-i, sb.length());
				for(int j=0;j<i;j++) {
					st2.push(')');
				}
			}
		}
	}
}
