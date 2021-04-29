package _114_二叉树展开为链表;

/**
 * 题目：
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
public class Solution {
	/**
	 * self思路：
	 * 【for每一个节点：1.如果有left，说明其链表后方一定是该left，则需要把他的right指向left的最后（即left的最右下角位置）2.如果无left，则无需改动】
	 * 从根node开始，用一个right指针保存其右指针node.right，然后把该right拼接到左儿子node.left的最右下角；然后把node.right指向左儿子
	 * 更新node=node.right;right = node.right
	 * 循环条件：node!=null
	 */
	public void flatten(TreeNode root) {
		//base
		if(root==null) {
			return;
		}
		TreeNode node = root;
		while(node!=null) {
			if(node.left!=null) {
				TreeNode right = node.right;//【ATT POINT!】
				//1.找到左儿子的最右下角，把right拼接上去
				TreeNode tmp = node.left;
				while(tmp.right!=null) {
					tmp = tmp.right;
				}
				tmp.right = right;
				//2.把node的左儿子换到右儿子，并将左指针置空
				node.right = node.left;
				node.left = null;
				//3.更新node和right
				node = node.right;
				right = node.right;
			}
			else {//node.left==null,可以直接进入下一轮
				node = node.right;
			}
		}
    }
}
