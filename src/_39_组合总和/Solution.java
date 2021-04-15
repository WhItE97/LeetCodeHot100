package _39_����ܺ�;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 * ��Ŀ��
 * ����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 * candidates �е����ֿ����������ظ���ѡȡ��
 * ˵�����������֣����� target���������������⼯���ܰ����ظ�����ϡ� 
 */
public class Solution {
	/**
	 * self˼·����31ms 5%...��
	 * 1.��sort candidates
	 * 2.���target���Ӵ�Сdfs����candidates�е�ֵ
	 * 
	 * 1.dfs��������:target==0
	 * 2.dfs��ѡ�С��target������Ԫ�أ�ATT.ѡ��֮������ѡ��
	 * 
	 * ��HDP����(1,2,3)����>6��(1,1,1,1,2)��(1,1,1,2,1)��ȥ��
	 * ��self�����������������route[]�����ƴ�ӳ�String�ӽ�HashSet�����HashSet���Ѿ����ڣ�˵����Ч������ӽ�res
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		//��WRONG POINT��������һ��ʼҪ�ȶ�candidates���򣬷�������֦
		Arrays.sort(candidates);
		dfs(candidates,target);
		return res;
    }
	
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> route = new ArrayList<>();
	Set<String> check = new HashSet<>();
	public void dfs(int[] candidates,int target) {
		//1.��������
		if(target==0) {
			//��ȥ�أ���
			StringBuilder sb = new StringBuilder();
			List<Integer> tmp = new ArrayList<>(route);
			Collections.sort(tmp);
			for(int i=0;i<tmp.size();i++) {
				sb.append(tmp.get(i));
			}
			if(!check.contains(sb.toString())) {
				check.add(sb.toString());
				res.add(new ArrayList<Integer>(route));
			}
			return ;
		}
		//2.dfs
		for(int i=0;i<candidates.length;i++) {
			//ATT.check��֦�������Ԫ���Ѿ�����target�ˣ�ʣ�µ�ȫ��û�б�Ҫ�ٳ�����
			if(candidates[i]>target) {
				break;
			}
			//1.��ѡ��
			route.add(candidates[i]);
			//2.dfs
			dfs(candidates,target-candidates[i]);
			//3.����ѡ��
			route.remove(route.size()-1);
		}
	}
}
