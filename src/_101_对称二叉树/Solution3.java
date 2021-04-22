package _101_�Գƶ�����;

import java.util.LinkedList;
import java.util.Deque;
public class Solution3 {
	/**
	 * �ٷ���ȷ����д����
	 * �����ĵݹ顪��>��������ͨ�����У���
	 * ��HDP���ڣ���������ڵ�match�ˣ���һ�ָİ�˭��˭�ȣ���
	 * ��IMP�����left��right match����Ȼ����Ҫ�Ƚϵ�Ӧ����left.left��right.right�ȣ�left.right��right.left�ȣ����������ͽ�����Ҳ�Ͱ�������˳���;����ˣ���
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
			//����������ڵ�match���������һ��������A�����Ӻ�B��������һ��B�����Ӻ�A��������һ�𣨾����CORE HDP����������бȽ�
			//��JAVA ELE��LinkedList���Բ�����null������û��Ҫ�жϣ���
			queue.offer(tmp1.left);
			queue.offer(tmp2.right);
			queue.offer(tmp1.right);
			queue.offer(tmp2.left);
		}
		return true;
    }
}
