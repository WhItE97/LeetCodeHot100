package _104_��������������;

public class Solution2 {
	/**
	 * dfs˼·��
	 * dfsֱ�������Ӷ�Ϊ�գ������Ⱥ�maxdepth�Ƚ�ȡmax
	 */
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		dfs(root,1);
		return maxdepth;
    }
	int maxdepth = 0;
	public void dfs(TreeNode node,int depth) {
		//1.��������
		if(node.left==null&&node.right==null) {
			maxdepth = Math.max(depth, maxdepth);
			return ;
		}
		
		//2.dfs
		for(int i=0;i<2;i++) {
			if(i==0&&node.left!=null) {//���ӵݹ�
				dfs(node.left,depth+1);
			}
			if(i==1&&node.right!=null) {//���ӵݹ�
				dfs(node.right,depth+1);
			}
		}
	}
}
