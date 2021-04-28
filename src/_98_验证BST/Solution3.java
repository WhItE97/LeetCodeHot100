package _98_��֤BST;

public class Solution3 {
	/**
	 * �ٷ����1����O(N)��
	 * ��һ�α����ĵݹ飡
	 * ˼·��
	 * �ݹ��жϵ�ǰ�ڵ��val������ĳ��(l,r)�����ڣ���ΪBST ������<root<��������
	 * 1.��ʼroot�����½�=MAX_VALUE��MIN_VALUE
	 * 2.�������ĵݹ������Ͻ�=root.val;�������ĵݹ����½�=root.val
	 * ...�ݹ�
	 */
	public boolean isValidBST(TreeNode root) {
		//base
		if(root==null) {
			return true;
		}
		return validBST(root.left,Long.MIN_VALUE,root.val)&&validBST(root.right,root.val,Long.MAX_VALUE);//��������������int�ı߽�ֵ��..��
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
