package _55_��Ծ��Ϸ;

public class Solution2 {
	/**
	 * ��������¼Carl˼·��
	 * ĳλ��=3������1or2or3������������������ν���ؼ����ڿ����ĸ��Ƿ�Χ��
	 * so����һ��Ҫ��ȷÿ�ξ���ѡ����������һ�ֱ�����ȡ���������Χ���ɣ�
	 * ̰�ģ�ÿһ��������һ���ֲ����ŵ�ѡ�����յĽ������ȫ�����š�ע�⣬����һ���������ʣ���ʵֻ��һ��������ӵ��������ʡ�
	 * ��Ŀ����ת��Ϊ������������Զλ���Ƿ񳬹������һλ��
	 */
	public boolean canJump(int[] nums) {
		int furthest = 0;
		for(int i=0;i<nums.length-1;i++) {//���һλû��Ҫ����farthest��
			if(furthest<i) {
				//˵����ǰ�ڵ㲻�ɴ�
				break;
			}
			furthest = Math.max(furthest, i+nums[i]);
		}
		return furthest>=nums.length-1;
	}
}
