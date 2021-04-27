package _96_不同的二叉搜索树;

/**
 * 题目：
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class Solution {
	/**
	 * self思路：
	 * dp...没d出来
	 * 【官方dp思路】
	 * 1.【CORE BASE:res=Σ以i为根节点的BST的棵数】——>【HDP1.以某个i为根节点的BST棵数=F(i,n)】
	 * 2.【HDP2.设G(k)=长度为k的序列能构成的不同BST数目】=>res = G(n)
	 * 3.for 以i为根节点的BST有：【HDP3.左子树包含(1~i-1)，右子树包含(i+1~n)】；
	 * 以i为根节点的BST总共有：【HDP4.左子树的所有可能性G(i-1)与右子树的所有可能性G(n-i)的笛卡尔积=G(i-1)*G(n-i)】
	 * 4.G(0)=1;G(1)=1
	 * 5.把3中以i为根节点的BST的所有可能BST数 表示为 F(i,n)则【F(i,n) = G(i-1)*G(n-i)】
	 * 6.要建立G(n)的【转移方程】
	 * 【G(n) = ΣF(i,n)(i=1,2,...,n) = G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)】
	 * 所以G(n)需要base G(1)~G(n-1)，所以自底向上求
	 */
	public int numTrees(int n) {
		int[] g = new int[n+1];
		g[0] = 1;
		g[1] = 1;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				g[i] += g[j-1]*g[i-j];
			}
		}
		return g[n];
    }
}
