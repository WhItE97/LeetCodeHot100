package _56_�ϲ�����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
	/**
	 * �ٷ���⡾base�����������˵����򣡡���O(NlogN)��
	 * ��������������б���merge
	 * ��HDP�����ʵ�������ά�����base��˵�����
	 * selfʵ�֣�
	 * ��Ҫ�Լ�ʵ��һ��comparator��
	 */
	public int[][] merge(int[][] intervals) {
		//��IMP REC.Comparator�ӿڵķ������������������Ԫ�ص����ͣ���
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a,int[] b) {
				return a[0]-b[0];
			}
		});
		//�ź�������һ��merge����
		List<int[]> res = new ArrayList<>();
		res.add(intervals[0]);
		for(int i=1;i<intervals.length;i++) {
			//���Ƚ�merge����ϸ�ڣ�1.���������˵�����������һ��������Ҷ˵�Ƚϣ��ж������غ�
			//2.(1)������غϣ���merge�����Ҷ˵�=max{�������Ҷ˵㣬�������Ҷ˵�}�������·Ż�List
			//(2)������غϣ���ֱ�Ӱ�������add��List
			int ll = res.get(res.size()-1)[0];
			int lr = res.get(res.size()-1)[1];
			int rl = intervals[i][0];
			int rr = intervals[i][1];
			if(lr<rl) {//���غ�
				res.add(intervals[i]);
			}
			else {//���غ�
				res.set(res.size()-1, new int[] {ll,Math.max(lr, rr)});
			}
		}
		//��resת�ط���ֵ����ʽreturn����IMP API��List��toArray()�������÷�REC.list.toArray(new int[list.size()]);��
		return res.toArray(new int[res.size()][]);
    }
}
