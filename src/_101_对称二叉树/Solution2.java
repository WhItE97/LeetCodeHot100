package _101_�Գƶ�����;

import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
public class Solution2 {
	/**
	 * self˼·2���������⣡û���ǵ�ĳһ��Ϊnull,3,null,3������������ַǶԳƣ�����Ҳ�ᱻ���ж�Ϊ�Գƣ���
	 * ����д������Solution3��
	 * bfs
	 * 1.��ÿһ�㣺���ĳ�����size==��������ز��Գƣ�except for root����
	 * �����¼��ÿһ��Ĵ������ҵĽڵ�ֵ��Ȼ��forѭ������ͷ���м�match��һ����match������return false
	 */
	public boolean isSymmetric(TreeNode root) {
		//base
		if(root==null) {
			return true;
		}
		Deque<TreeNode> st1 = new LinkedList<>();
		Deque<TreeNode> st2 = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		st1.add(root);
		while(!st1.isEmpty()||!st2.isEmpty()) {
			while(!st1.isEmpty()) {
				TreeNode tmp = st1.poll();
				list.add(tmp.val);
				if(tmp.left!=null) {
					st2.offer(tmp.left);
				}
				if(tmp.right!=null) {
					st2.offer(tmp.right);
				}
			}
			//��鱾���Ƿ�Գ�
			if(!symmetric(list)) {
				return false;
			}
			list.clear();
			while(!st2.isEmpty()) {
				TreeNode tmp = st2.poll();
				list.add(tmp.val);
				if(tmp.left!=null) {
					st1.offer(tmp.left);
				}
				if(tmp.right!=null) {
					st1.offer(tmp.right);
				}
			}
			if(!symmetric(list)) {
				return false;
			}
			list.clear();
		}
		return true;
    }
	
	//ʵ�ֶ�ĳ��Ľڵ�ֵ��ͨ��list���棩����ͷ���м�match��boolean�ж�
	public boolean symmetric(List<Integer> list) {
		for(int i=0;i<list.size()/2;i++) {
			if(list.get(i)!=list.get(list.size()-1-i)) {
				return false;
			}
		}
		return true;
	}
}
