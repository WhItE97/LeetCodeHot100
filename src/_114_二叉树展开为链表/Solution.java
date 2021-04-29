package _114_������չ��Ϊ����;

/**
 * ��Ŀ��
 * ����������ĸ���� root �����㽫��չ��Ϊһ��������
 * չ����ĵ�����Ӧ��ͬ��ʹ�� TreeNode ������ right ��ָ��ָ����������һ����㣬������ָ��ʼ��Ϊ null ��
 * չ����ĵ�����Ӧ��������� ������� ˳����ͬ��
 * ���ף������ʹ��ԭ���㷨��O(1) ����ռ䣩չ���������
 */
public class Solution {
	/**
	 * self˼·��
	 * ��forÿһ���ڵ㣺1.�����left��˵���������һ���Ǹ�left������Ҫ������rightָ��left����󣨼�left�������½�λ�ã�2.�����left��������Ķ���
	 * �Ӹ�node��ʼ����һ��rightָ�뱣������ָ��node.right��Ȼ��Ѹ�rightƴ�ӵ������node.left�������½ǣ�Ȼ���node.rightָ�������
	 * ����node=node.right;right = node.right
	 * ѭ��������node!=null
	 */
	public void flatten(TreeNode root) {
		//base
		if(root==null) {
			return;
		}
		TreeNode node = root;
		while(node!=null) {
			if(node.left!=null) {
				TreeNode right = node.right;//��ATT POINT!��
				//1.�ҵ�����ӵ������½ǣ���rightƴ����ȥ
				TreeNode tmp = node.left;
				while(tmp.right!=null) {
					tmp = tmp.right;
				}
				tmp.right = right;
				//2.��node������ӻ����Ҷ��ӣ�������ָ���ÿ�
				node.right = node.left;
				node.left = null;
				//3.����node��right
				node = node.right;
				right = node.right;
			}
			else {//node.left==null,����ֱ�ӽ�����һ��
				node = node.right;
			}
		}
    }
}
