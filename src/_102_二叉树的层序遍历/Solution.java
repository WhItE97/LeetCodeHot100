package _102_二叉树的层序遍历;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if(root==null) {
			return res;
		}
		int presize = 1;//记录每一层的size，以便分层输出【不用分成两个的，可以精简成一个，见Solution2】
		int nextsize = 0;//记录下一层的size
		List<Integer> route = new ArrayList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			presize--;
			route.add(tmp.val);
			if(tmp.left!=null) {
				queue.offer(tmp.left);
				nextsize++;
			}
			if(tmp.right!=null) {
				queue.offer(tmp.right);
				nextsize++;
			}
			if(presize==0) {
				res.add(new ArrayList<>(route));
				route.clear();
				presize = nextsize;
				nextsize = 0;
			}
		}
		return res;
    }
}
