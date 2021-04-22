package _101_对称二叉树;

import java.util.LinkedList;
import java.util.Deque;
public class Solution3 {
	/**
	 * 官方正确迭代写法：
	 * 【树的递归——>迭代：多通过队列！】
	 * 【HDP在于：如果两个节点match了，下一轮改把谁和谁比？】
	 * 【IMP：如果left和right match，显然下轮要比较的应该是left.left和right.right比，left.right和right.left比，所以我们送进队列也就按这样的顺序送就行了！】
	 */
	public boolean isSymmetric(TreeNode root) {
		//base
		if(root==null) {
			return true;
		}
		Deque<TreeNode> queue = new LinkedList<>();
		if(root.left!=null) {
			queue.add(root.left);
		}
		if(root.right!=null) {
			queue.add(root.right);
		}
		while(!queue.isEmpty()) {
			TreeNode tmp1 = queue.poll();
			TreeNode tmp2 = queue.poll();
			if(tmp1==null&&tmp2==null) {
				continue;
			}
			else if((tmp1==null&&tmp2!=null)||(tmp1!=null&&tmp2==null)) {
				return false;
			}
			else if(tmp1.val!=tmp2.val) {
				return false;
			}
			//如果本轮俩节点match，则进入下一步，【把A的左子和B的右子排一起，B的右子和A的左子排一起（镜像的CORE HDP）】送入队列比较
			//【JAVA ELE：LinkedList可以插入多个null！所以没必要判断！】
			queue.offer(tmp1.left);
			queue.offer(tmp2.right);
			queue.offer(tmp1.right);
			queue.offer(tmp2.left);
		}
		return true;
    }
}
