package _98_��֤BST;

public class Solution2 {
	/**
	 * Ҫ��ÿ����check��Ӧ���ǣ������������ڵ�<mid<����������С�ڵ㣡
	 * ������EZ����Solution3��
	 */
	public boolean isValidBST(TreeNode root) {
		//base
		if(root==null) {
			return true;
		}
		//��check���
		if(root.left!=null) {
			if(root.left.val>=root.val) {
				return false;
			}
			//�������������ڵ�
			TreeNode node = root.left;
			while(node.right!=null) {
				node = node.right;
			}
			if(node.val>=root.val) {
				return false;
			}
		}
		//��check�ұ�
		if(root.right!=null) {
			if(root.right.val<=root.val) {
				return false;
			}
			//������������С�ڵ�
			TreeNode node = root.right;
			while(node.left!=null) {
				node = node.left;
			}
			if(node.val<=root.val) {
				return false;
			}
		}
		//�ݹ�check
		return isValidBST(root.left)&&isValidBST(root.right);
    }
}
