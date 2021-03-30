package _1_����֮��;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ŀ��
 * ����һ���������� nums ��һ������Ŀ��ֵ target�������ڸ��������ҳ� ��ΪĿ��ֵ ���� ���� ���������������ǵ������±ꡣ
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ���ڴ��ﲻ���ظ����֡�
 * ����԰�����˳�򷵻ش𰸡�
 */
public class Solution {
	/**
	 * self˼·����0ms 100%��
	 * ע�⵽1.��������2.Ҫ���ص����±�
	 * ���Բ��ܸ����������˫ָ��search
	 * change˼·:
	 * HashMap->ÿ����һ��������ѯmap���Ƿ���ں����͵���target�ģ�������򷵻��������±ꣻelse��ѵ�ǰ(��ֵ���±�)��kv�Դ���map
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			//�����жϵ�ǰmap����û�кͱ���Ԫ���������target��
			if(map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			else {//���û�У���ѱ��ֵ�Ԫ�طŽ�map
				map.put(nums[i],i);
			}
		}
		return new int[] {};
    }
}
