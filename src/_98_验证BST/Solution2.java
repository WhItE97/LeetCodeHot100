package _98_验证BST;

public class Solution2 {
	/**
	 * 要对每个根check的应该是：左子树的最大节点<mid<右子树的最小节点！
	 * 【不够EZ，见Solution3】
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
			//找左子树的最大节点
			TreeNode node = root.left;
			while(node.right!=null) {
				node = node.right;
			}
			if(node.val>=root.val) {
				return false;
			}
		}
		//再check右边
		if(root.right!=null) {
			if(root.right.val<=root.val) {
				return false;
			}
			//找右子树的最小节点
			TreeNode node = root.right;
			while(node.left!=null) {
				node = node.left;
			}
			if(node.val<=root.val) {
				return false;
			}
		}
		//递归check
		return isValidBST(root.left)&&isValidBST(root.right);
    }
}
