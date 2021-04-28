package _102_¶þ²æÊ÷µÄ²ãÐò±éÀú;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
public class Solution2 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new LinkedList<>();
		if(root==null) {
			return res;
		}
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> route = new LinkedList<>();
			int curSize = queue.size();
			for(int i=0;i<curSize;i++) {
				TreeNode tmp = queue.poll();
				route.add(tmp.val);
				if(tmp.left!=null) {
					queue.offer(tmp.left);
				}
				if(tmp.right!=null) {
					queue.offer(tmp.right);
				}
			}
			res.add(route);
		}
		return res;
    }
}
