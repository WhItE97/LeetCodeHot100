package _101_�Գƶ�����;

/**
 * ��Ŀ��
 * ����һ����������������Ƿ��Ǿ���ԳƵġ�
 * ���ף�
 * ��������õݹ�͵������ַ���������������
 */
public class Solution {
	/**
	 * self˼·1��
	 * �ݹ�
	 * ��CON��̫��ûд�ˣ��ж��������˼��βŸ�����ȫ��
	 * 1.���������ڵ���ܶ�null�������������true��
	 * 2.Ȼ����� ����ֻ�� һ��Ϊnull������false��
	 * 3.����null�����val��
	 */
	public boolean isSymmetric(TreeNode root) {
		//base
		if(root==null) {
			return true;
		}
		return symmetric(root.left,root.right);
    }
	
	public boolean symmetric(TreeNode left,TreeNode right) {
		//��WRONG POINT2.��nullҲ�ǿ��Եģ���
		if(left==null&&right==null) {
			return true;
		}
		//��WRONG POINT.�������пգ���
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
