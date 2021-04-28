package _98_��֤BST;

import java.util.Deque;
import java.util.LinkedList;
public class Solution4 {
	/**
	 * ��best���ٷ����2��
	 * ��BST����>�������LDR������������Ľ���ض��Ǵ�С�������������
	 * �������������ÿ����һ���ڵ㣬������һ���ڵ�ֵpre�Ƚϣ������ϸ������
	 */
	public boolean isValidBST(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		Integer pre = null;
		//LDR������Ҫ������
		while(!stack.isEmpty()||node!=null) {
			while(node!=null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			if(pre!=null&&node.val<=pre) {
				return false;
			}
			pre = node.val;
			node = node.right;
		}
		return true;
    }
}
