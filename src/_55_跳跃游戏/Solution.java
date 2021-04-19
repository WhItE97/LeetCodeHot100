package _55_��Ծ��Ϸ;

/**
 * ��Ŀ��
 * ����һ���Ǹ��������� nums �������λ������� ��һ���±� ��
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * �ж����Ƿ��ܹ��������һ���±ꡣ
 */
public class Solution {
	/**
	 * self˼·1.
	 * dfs(�о��ᳬʱ..)
	 * ���������������±�len-1
	 * 
	 * �ٷ���⡾̰���㷨��
	 * ̰�ģ�ÿһ��������һ���ֲ����ŵ�ѡ�����յĽ������ȫ�����š�ע��Ŷ������һ���������ʣ���ʵֻ��һ��������ӵ��������ʡ�
	 * ��Ŀ����ת��Ϊ��Ҫ����nums.length-1���Ժ�
	 * selfʵ�֣�
	 * dfsÿ�ξ���������ģ��в�ͨ�ٻ��ˣ������ϴ�����һ����WRONG.����ֻ���Ż����dfs..74/75��ʱ�ˣ���real̰��at Solution2��
	 */
	public boolean canJump(int[] nums) {
		dfs(nums,0);
		return flag;
    }
	boolean flag = false;
	public void dfs(int[] nums,int posi) {
		//��������
		if(flag) {
			return ;
		}
		if(posi>=nums.length-1) {
			flag = true;
			return;
		}
		
		for(int i=nums[posi];i>0;i--) {
			dfs(nums,posi+i);
		}
	}
}
