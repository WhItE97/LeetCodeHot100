package _78_�Ӽ�;

import java.util.List;
import java.util.ArrayList;
/**
 * ��Ŀ��
 * ����һ���������� nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
 * �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
 * ע�⣺
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums �е�����Ԫ�� ������ͬ
 */
public class Solution {
	/**
	 * self˼·��
	 * �������鳤�ȣ���0~nums.length-1����dfs
	 */
	public List<List<Integer>> subsets(int[] nums) {
		//�������п��ܵ�����size
		for(int i=0;i<=nums.length;i++) {//��ATT POINT.������==nums.lengthҲ�ǿ��Եģ���
			dfs(nums,i,0);
		}
		return res;
    }
	
	
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> route = new ArrayList<>();
	//size:����dfs��Ŀ�����鳤��
	//k:����ѡȡԪ�ص���ʼ�±�
	public void dfs(int[] nums,int size,int k) {
		//1.��������
		if(route.size()==size) {
			//��Ϊ����k��־��ʼλ�ã�����һ�������ظ���������ȥ��
			res.add(new ArrayList<Integer>(route));
			return;
		}
		//2.dfs
		for(int i=k;i<nums.length;i++) {
			//1.��ѡ��
			route.add(nums[i]);
			//2.dfs
			dfs(nums,size,i+1);//��ATT POINT.����ݹ���i+1������k+1����
			//3.ȡ��ѡ��
			route.remove(route.size()-1);
		}
	}
}
