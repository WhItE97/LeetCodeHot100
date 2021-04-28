package _98_验证BST;

import java.util.Deque;
import java.util.LinkedList;
public class Solution4 {
	/**
	 * 【best】官方题解2：
	 * 【BST——>中序遍历LDR！】中序遍历的结果必定是从小到大的有序序列
	 * 所以中序遍历，每访问一个节点，都和上一个节点值pre比较，必须严格递增！
	 */
	public boolean isValidBST(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		Integer pre = null;
		//LDR所以先要找最左
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
