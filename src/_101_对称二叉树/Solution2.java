package _101_对称二叉树;

import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
public class Solution2 {
	/**
	 * self思路2：【有问题！没考虑到某一层为null,3,null,3这种情况！这种非对称，但是也会被我判断为对称！】
	 * 迭代写法【见Solution3】
	 * bfs
	 * 1.对每一层：如果某层队列size==奇数，则必不对称（except for root）！
	 * 否则记录下每一层的从左至右的节点值，然后for循环从两头往中间match，一个不match则立马return false
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
			//检查本层是否对称
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
	
	//实现对某层的节点值（通过list保存）从两头向中间match的boolean判断
	public boolean symmetric(List<Integer> list) {
		for(int i=0;i<list.size()/2;i++) {
			if(list.get(i)!=list.get(list.size()-1-i)) {
				return false;
			}
		}
		return true;
	}
}
