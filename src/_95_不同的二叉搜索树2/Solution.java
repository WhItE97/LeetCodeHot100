package _95_��ͬ�Ķ���������2;

import java.util.List;
import java.util.ArrayList;
/**
 * ��Ŀ��
 * ����һ������ n������������ 1 ... n Ϊ�ڵ�����ɵ� ���������� ��
 */
public class Solution {
	/**
	 * self˼·����û�뵽��ôʵ�֡�
	 * dfs
	 * BST left<mid<right������dfs��1~nΪ�������������
	 * ÿ��ѡ���һ���������󣬶����ʣ�½ڵ㻮�ֳ��������ϣ��ݹ�dfs��
	 * HDP.��ô������self��dfs���Ȱ���ߵĲ��꣬ÿ����ߵĲ����ˣ��ٲ��ұߵģ����������ߵ�ÿһ�������dfs�ұߵ������������ѿ�������
	 * 
	 * �ٷ�˼·selfʵ�֣�������ûд����...��
	 * ����Ȼ��֪�����ϵ�����ô�������Ǿʹ��µ���ƴ����֦������
	 * �ȵݹ���ֱ��1���ڵ㣬�����
	 * 
	 * ����windliang���ݣ�
	 * ��HDP1.ÿһ��ݹ�Ҫ����һ������ʲô����ô���أ�����List��ʽ������һ�㽻���Լ�����Ŀ��ܵ����������ṹ����
	 * ��HDP2.ÿһ��Ҫ��ʲô�������Լ��������������ݹ������ǵ����п��������ṹ��ͨ��2��List��ȡ�����п��ܵ����������ṹ������for����ѿ�������
	 * ��ATT.start>end����������˷���һ����null��List����Ȼ�����޷�����ѿ������ļ����ˣ���
	 * 1.�������нڵ������ڵ�����
	 * 2.���i������������������[1,i-1]������������[i+1,n]
	 * 3.������Ҫ��һ����������������������Ϻ������������������ϣ���˫��ѭ��������ӵ�i�����ҡ�
	 * 4.������Ҫ�ݹ����ÿ���������������䣬������������Ҫ����һ�����ܵ����ṹ��List<TreeNode>���Թ�i�������������ĵѿ�����
	 */
	public List<TreeNode> generateTrees(int n) {
		if(n<1) {
			return new ArrayList<TreeNode>();
		}
		return dfs(1,n);
    }
	
	public List<TreeNode> dfs(int start,int end) {
		List<TreeNode> res = new ArrayList<>();
		//base
		if(start>end) {
			res.add(null);
			return res;
		}
		
		if(start==end) {
			res.add(new TreeNode(start));
			return res;
		}
		//1.����start��end���нڵ�ֱ������ڵ�����
		for(int i=start;i<=end;i++) {
			List<TreeNode> leftnodes = dfs(start,i-1);
			List<TreeNode> rightnodes = dfs(i+1,end);
			
			//2.����i���������п��������ṹ����д��res���ظ���һ��
			for(TreeNode leftnode:leftnodes) {
				for(TreeNode rightnode:rightnodes) {
					TreeNode tmproot = new TreeNode(i);
					tmproot.left = leftnode;
					tmproot.right = rightnode;
					res.add(tmproot);
				}
			}
		}
		
		//3.����res����һ��
		return res;
	}
}
