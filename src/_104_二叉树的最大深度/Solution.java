package _104_二叉树的最大深度;

import java.util.Queue;
import java.util.LinkedList;
public class Solution {
	/**
	 * self思路：
	 * bfs遍历求深度
	 */
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 0;
		while(!queue.isEmpty()) {
			int curSize = queue.size();
			for(int i=0;i<curSize;i++) {
				TreeNode tmp = queue.poll();
				if(tmp.left!=null) {
					queue.offer(tmp.left);
				}
				if(tmp.right!=null) {
					queue.offer(tmp.right);
				}
			}
			depth++;
		}
		return depth;
    }
}
