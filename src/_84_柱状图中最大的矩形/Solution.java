package _84_��״ͼ�����ľ���;

/**
 * ��Ŀ��
 * ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
 * ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������
 */
public class Solution {
	/**
	 * self˼·����O(NlogN) 95/96��ʱ...(������O(N^2)93/96��ʱ)��
	 * ����
	 * 1.��һ�����ҵ�ȫ����Сֵ�㣬����һ���ױ������ľ������
	 * 2.���ݸ���Сֵ�㻮�ֳ�2�Σ���������Сֵ�㣩�ٷֱ�����Сֵ�㣬Ȼ����ױ������ľ����������max���Ƚ�
	 * 3.�ݹ�ֱ���ױ�=1
	 */
	public int largestRectangleArea(int[] heights) {
		split(heights,0,heights.length-1);
		return maxsize;
    }
	
	int maxsize = -1;
	public void split(int[] heights,int start,int end) {
		if(start==end) {
			maxsize = Math.max(maxsize, heights[start]);
			System.out.println("maxsize="+maxsize);
			return ;
		}
		else if(start<end) {
			int min = Integer.MAX_VALUE;
			int minindex = -1;
			for(int i=start;i<=end;i++) {
				if(heights[i]<min) {
					min = heights[i];
					minindex = i;
				}
			}
			maxsize = Math.max(maxsize, min*(end-start+1));
			System.out.println("maxsize="+maxsize);
			split(heights,start,minindex-1);
			split(heights,minindex+1,end);
		}
		else {
			return ;
		}
	}
}
