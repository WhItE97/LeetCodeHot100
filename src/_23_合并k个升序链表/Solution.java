package _23_�ϲ�k����������;

/**
 * ��Ŀ��
 * ����һ���������飬ÿ�������Ѿ����������С�
 * ���㽫��������ϲ���һ�����������У����غϲ��������
 */
public class Solution {
	/**
	 * self˼·����1ms 100%��
	 * �鲢˼�����merge����IMPʱ�临�Ӷȵļ��㡿����һ�ֺϲ�k/2������ÿһ��ʱ�������2n���ڶ��ֺϲ�k/4������ÿһ��ʱ�������4n����>��logk�֡���>ʱ�临�Ӷ�=nklogk��
	 * ���ȶ�ListNode������в�֣����һ��һ������merge
	 * ��д����������������
	 * 1.split(ListNode[] lists,int start,int end)�����ݹ��֣�ֻҪstart��<end���ͼ�����֣�
	 * ����ÿ�β�ֺ�Ҫ��¼�·���ֵleftNode��rightNode����ȡ������leftNode��rightNode��Ҫ�Ѹ�����Node merge����return��ȥ��
	 * 2.merge(ListNode left,ListNode right)ֻ����merge2����������return��ȥ
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		//base
		if(lists.length==0) {
			return null;
		}
		return split(lists,0,lists.length-1);
    }
	
	public ListNode split(ListNode[] lists,int start,int end) {
		if(start<end) {
			int mid = (start+end)/2;
			ListNode left = split(lists,start,mid);
			ListNode right = split(lists,mid+1,end);
			return merge(left,right);
		}
		else if(start==end) {
			return lists[start];
		}
		else {
			return null;
		}
	}
	
	public ListNode merge(ListNode left,ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		while(left!=null&&right!=null) {
			if(left.val<right.val) {
				node.next = left;
				left = left.next;
			}
			else {
				node.next = right;
				right = right.next;
			}
			node = node.next;
		}
		node.next = (left==null)?right:left;
		return dummy.next;
	}
}
