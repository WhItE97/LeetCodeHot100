package _98_验证BST;

public class Solution3 {
	/**
	 * 官方题解1：【O(N)】
	 * 仅一次遍历的递归！
	 * 思路：
	 * 递归判断当前节点的val必须在某个(l,r)区间内（因为BST 左子树<root<右子树）
	 * 1.初始root的上下界=MAX_VALUE和MIN_VALUE
	 * 2.左子树的递归则有上界=root.val;右子树的递归有下界=root.val
	 * ...递归
	 */
	public boolean isValidBST(TreeNode root) {
		//base
		if(root==null) {
			return true;
		}
		return validBST(root.left,Long.MIN_VALUE,root.val)&&validBST(root.right,root.val,Long.MAX_VALUE);//【被测试用例卡int的边界值了..】
    }
	
	public boolean validBST(TreeNode root,long l,long r) {
		if(root==null) {
			return true;
		}
		if(root.val<=l||root.val>=r) {
			return false;
		}
		return validBST(root.left,l,root.val)&&validBST(root.right,root.val,r);
	}
}
