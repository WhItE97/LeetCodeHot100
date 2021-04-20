package _56_�ϲ�����;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ŀ��
 * ������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ��
 * ����ϲ������ص������䣬������һ�����ص����������飬��������ǡ�ø��������е��������䡣
 */
public class Solution {
	/**
	 * self˼·����O(NlogN)��
	 * �鲢�ϲ����Ȳ�ɵ������䣬������һ��ϲ���ûд����������Ĺ鲢�����������䲢���ܺϲ������Է��صĿ�����һ�����������������..д�������鷳����Solution2��
	 */
	public int[][] merge(int[][] intervals) {
		
    }
	
	public int[][] mergeSort(int[][] intervals,int start,int end) {
		if(start==end) {
			return new int[][] {intervals[start]};
		}
		else if(start<end) {
			return null;
		}
		else {
			int mid = (start+end)/2;
			int[][] left = mergeSort(intervals,start,mid);
			int[][] right = mergeSort(intervals,mid+1,end);
			return merge(left,right);
		}
	}
	
	public int[][] merge(int[][] left,int[][] right){
		//base
		if(left==null||right==null) {
			return left==null?right:left;
		}
		//��Ϊ��һ���ܺϲ���һ��������Ҫ����һ���������ϲ�
		int l = 0;
		int r = 0;
		List<int[]> res = new ArrayList<>();
		while(l<left.length&&r<right.length) {
			//��ߵ������С
			if(left[l][1]>=right[r][0]) {//1.��Ҫmerge
				res.add(new int[] {left[l][0]>right[r][0]?right[r][0]:left[l][0],right[r][1]});
				l++;
			}
		}
	}
}
