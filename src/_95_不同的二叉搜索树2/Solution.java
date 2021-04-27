package _95_不同的二叉搜索树2;

import java.util.List;
import java.util.ArrayList;
/**
 * 题目：
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 */
public class Solution {
	/**
	 * self思路：【没想到怎么实现】
	 * dfs
	 * BST left<mid<right；所以dfs从1~n为根的所有情况！
	 * 每次选择好一个“根”后，都会把剩下节点划分成两个集合！递归dfs！
	 * HDP.怎么结束？self：dfs中先把左边的插完，每次左边的插完了，再插右边的，并且针对左边的每一种情况，dfs右边的所有情况（求笛卡尔积）
	 * 
	 * 官方思路self实现：【还是没写出来...】
	 * 【既然不知道从上到下怎么结束，那就从下到上拼接树枝啊！】
	 * 先递归拆分直到1个节点，再组合
	 * 
	 * 力扣windliang回溯：
	 * 【HDP1.每一层递归要给上一级返回什么？怎么返回？：以List形式返回上一层交给自己计算的可能的所有子树结构！】
	 * 【HDP2.每一层要做什么？划分自己的左右子树，递归求他们的所有可能子树结构，通过2个List获取到所有可能的左右子树结构后，两个for计算笛卡尔积】
	 * 【ATT.start>end的情况别忘了返回一个有null的List！不然后续无法进入笛卡尔积的计算了！】
	 * 1.遍历所有节点做根节点的情况
	 * 2.如果i做根，则左子树区间[1,i-1]，右子树区间[i+1,n]
	 * 3.所以需要进一步求出左子树区间的所有组合和右子树区间的所有组合，再双重循环组合连接到i的左右。
	 * 4.所以需要递归进入每个左右子树的区间，并且左右子树要返回一个可能的树结构的List<TreeNode>，以供i计算左右子树的笛卡尔积
	 */
	public List<TreeNode> generateTrees(int n) {
		if(n<1) {
			return new ArrayList<TreeNode>();
		}
		return dfs(1,n);
    }
	
	public List<TreeNode> dfs(int start,int end) {
		List<TreeNode> res = new ArrayList<>();
		//base
		if(start>end) {
			res.add(null);
			return res;
		}
		
		if(start==end) {
			res.add(new TreeNode(start));
			return res;
		}
		//1.遍历start到end所有节点分别做根节点的情况
		for(int i=start;i<=end;i++) {
			List<TreeNode> leftnodes = dfs(start,i-1);
			List<TreeNode> rightnodes = dfs(i+1,end);
			
			//2.遍历i做根的所有可能子树结构，并写入res返回给上一层
			for(TreeNode leftnode:leftnodes) {
				for(TreeNode rightnode:rightnodes) {
					TreeNode tmproot = new TreeNode(i);
					tmproot.left = leftnode;
					tmproot.right = rightnode;
					res.add(tmproot);
				}
			}
		}
		
		//3.返回res给上一级
		return res;
	}
}
