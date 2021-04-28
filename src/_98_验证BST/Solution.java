package _98_验证BST;

/**
 * 题目：
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class Solution {
	/**
	 * self思路：【74/77 这思路有问题的..没有考虑到再往下一层；如root=120,right=140,right.left=130,right.left.left=119这里就不满足root的右子树全比他大了
	 * ——>一层不够，那就改成while啊！见Solution2】
	 * 对每个节点有：left<mid<right并且！1.parent>left.right;2.parent<right.left
	 * 递归所有节点即可
	 */
	public boolean isValidBST(TreeNode root) {
		//base
		if(root==null) {
			return true;
		}
		//先check左边
		if(root.left!=null) {
			if(root.left.val>=root.val) {
				return false;
			}
			if(root.left.right!=null) {
				if(root.left.right.val>=root.val) {
					return false;
				}
			}
		}
		//再check右边
		if(root.right!=null) {
			if(root.right.val<=root.val) {
				return false;
			}
			if(root.right.left!=null) {
				if(root.right.left.val<=root.val) {
					return false;
				}
			}
		}
		//递归check
		return isValidBST(root.left)&&isValidBST(root.right);
    }
}
