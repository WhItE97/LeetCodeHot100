package _101_对称二叉树;

/**
 * 题目：
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Solution {
	/**
	 * self思路1：
	 * 递归
	 * 【CON】太久没写了，判断条件改了几次才覆盖完全！
	 * 1.首先两个节点可能都null，这种情况返回true！
	 * 2.然后如果 有且只有 一个为null，返回false！
	 * 3.都非null，则比val！
	 */
	public boolean isSymmetric(TreeNode root) {
		//base
		if(root==null) {
			return true;
		}
		return symmetric(root.left,root.right);
    }
	
	public boolean symmetric(TreeNode left,TreeNode right) {
		//【WRONG POINT2.都null也是可以的！】
		if(left==null&&right==null) {
			return true;
		}
		//【WRONG POINT.别忘了判空！】
		else if((left==null&&right!=null)||(left!=null&&right==null)) {
			return false;
		}
		else if(left.val!=right.val) {
			return false;
		}
		else {
			return symmetric(left.left,right.right)&&symmetric(left.right,right.left);
		}
	}
}
