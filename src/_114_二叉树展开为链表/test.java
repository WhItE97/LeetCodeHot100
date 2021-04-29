package _114_二叉树展开为链表;

public class test {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node5 = new TreeNode(5);
		node1.right = node2;
		node2.left = node3;
//		node2.left = node4;
//		node2.right = node5;
		
		Solution s = new Solution();
		s.flatten(node1);
		TreeNode node = node1;
		while(node!=null) {
			System.out.print(node.val+" ");
			node = node.right;
		}
	}

}
