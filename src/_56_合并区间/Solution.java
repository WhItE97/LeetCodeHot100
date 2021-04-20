package _56_合并区间;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class Solution {
	/**
	 * self思路：【O(NlogN)】
	 * 归并合并，先拆成单个区间，再两两一组合并【没写出来，这里的归并可能两个区间并不能合并，所以返回的可能是一个有两个区间的数组..写起来较麻烦，见Solution2】
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
		//因为不一定能合并成一个！所以要两两一组进行区间合并
		int l = 0;
		int r = 0;
		List<int[]> res = new ArrayList<>();
		while(l<left.length&&r<right.length) {
			//左边的区间更小
			if(left[l][1]>=right[r][0]) {//1.需要merge
				res.add(new int[] {left[l][0]>right[r][0]?right[r][0]:left[l][0],right[r][1]});
				l++;
			}
		}
	}
}
