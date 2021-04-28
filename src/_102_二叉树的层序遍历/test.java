package _102_¶þ²æÊ÷µÄ²ãÐò±éÀú;

import java.util.List;
public class test {
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
		
		Solution2 s = new Solution2();
		List<List<Integer>> res = s.levelOrder(node1);
		for(List<Integer> ls:res) {
			System.out.println(ls);
		}
	}
}
