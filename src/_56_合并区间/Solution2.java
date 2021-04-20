package _56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
	/**
	 * 官方题解【base所有区间的左端点排序！】【O(NlogN)】
	 * 对排序后的区间进行遍历merge
	 * 【HDP：如何实现这个二维数组的base左端点排序】
	 * self实现：
	 * 需要自己实现一个comparator！
	 */
	public int[][] merge(int[][] intervals) {
		//【IMP REC.Comparator接口的泛型是排序数组的数组元素的类型！】
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a,int[] b) {
				return a[0]-b[0];
			}
		});
		//排好序后遍历一轮merge即可
		List<int[]> res = new ArrayList<>();
		res.add(intervals[0]);
		for(int i=1;i<intervals.length;i++) {
			//“比较merge”的细节：1.新区间的左端点和链表中最后一个区间的右端点比较，判断有无重合
			//2.(1)如果有重合，则merge，且右端点=max{老区间右端点，新区间右端点}；再重新放回List
			//(2)如果无重合，则直接把新区间add进List
			int ll = res.get(res.size()-1)[0];
			int lr = res.get(res.size()-1)[1];
			int rl = intervals[i][0];
			int rr = intervals[i][1];
			if(lr<rl) {//无重合
				res.add(intervals[i]);
			}
			else {//有重合
				res.set(res.size()-1, new int[] {ll,Math.max(lr, rr)});
			}
		}
		//把res转回返回值的形式return：【IMP API！List有toArray()方法！用法REC.list.toArray(new int[list.size()]);】
		return res.toArray(new int[res.size()][]);
    }
}
