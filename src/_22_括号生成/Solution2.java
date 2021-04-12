package _22_��������;

import java.util.List;
import java.util.ArrayList;
public class Solution2 {
	/**
	 * ����liweiwei1419˼·����1ms 96%��
	 * dfs����>int left:������ʣ������int right:������ʣ����
	 * dfs��
	 * 1.�������� left==0&&right==0
	 * 2.dfs���̣�ֻҪleft>0���ͻ�����ѡleft������һ��dfs��rightͬ��
	 * ���Լ��������һ��������ûд������HDP���ڣ�����dfs����ѡ��׶Σ���Ϊ��2��part����
	 * ��1.���������ţ�����if(left>0)��part��2.���ǰ���Ѿ�dfs��������������������š����������ŵ��������
	 * ��ATT.���������Ų���Ҫright>0������������right>left��˵����ǰ�ַ��������Ÿ���>�����ţ�����
	 */
	public List<String> generateParenthesis(int n) {
		int left = n;
		int right = n;
		dfs(left,right);
		return res;
    }
	
	List<String> res = new ArrayList<>();
	StringBuilder sb = new StringBuilder();
	public void dfs(int left,int right) {
		System.out.println("now sb="+sb.toString());
		//��������
		if(left==0&&right==0) {
			res.add(sb.toString());
			return;
		}
		//dfs
		if(left>0) {
			//��ѡ��
			sb.append('(');
			//dfs
			dfs(left-1,right);
			//����ѡ��
			sb.delete(sb.length()-1,sb.length());
		}
		if(right>0&&right>left) {
			//��right��ѡ��
			sb.append(')');
			//dfs
			dfs(left,right-1);
			//����ѡ��
			sb.delete(sb.length()-1, sb.length());
		}
	}
}
