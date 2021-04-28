package _98_��֤BST;

/**
 * ��Ŀ��
 * ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
 */
public class Solution {
	/**
	 * self˼·����74/77 ��˼·�������..û�п��ǵ�������һ�㣻��root=120,right=140,right.left=130,right.left.left=119����Ͳ�����root��������ȫ��������
	 * ����>һ�㲻�����Ǿ͸ĳ�while������Solution2��
	 * ��ÿ���ڵ��У�left<mid<right���ң�1.parent>left.right;2.parent<right.left
	 * �ݹ����нڵ㼴��
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
			if(root.left.right!=null) {
				if(root.left.right.val>=root.val) {
					return false;
				}
			}
		}
		//��check�ұ�
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
		//�ݹ�check
		return isValidBST(root.left)&&isValidBST(root.right);
    }
}
