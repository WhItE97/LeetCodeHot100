package _104_二叉树的最大深度;

public class Solution2 {
	/**
	 * dfs思路：
	 * dfs直到左右子都为空，将长度和maxdepth比较取max
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
		//1.结束条件
		if(node.left==null&&node.right==null) {
			maxdepth = Math.max(depth, maxdepth);
			return ;
		}
		
		//2.dfs
		for(int i=0;i<2;i++) {
			if(i==0&&node.left!=null) {//左子递归
				dfs(node.left,depth+1);
			}
			if(i==1&&node.right!=null) {//右子递归
				dfs(node.right,depth+1);
			}
		}
	}
}
