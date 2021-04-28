package _98_—È÷§BST;

import java.util.Deque;
import java.util.LinkedList;
public class InorderTraversal {
	public static void traverse(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		while(!stack.isEmpty()||node!=null) {
			while(node!=null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			System.out.print(node.val+" ");
			node = node.right;
		}
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		traverse(node1);
	}
}
