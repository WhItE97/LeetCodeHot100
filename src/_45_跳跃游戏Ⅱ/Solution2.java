package _45_��Ծ��Ϸ��;

public class Solution2 {
	/**
	 * labuladong��̰���㷨O(N)����
	 * ��CORE��ÿ���ڿ�����Ծ��λ���У�ѡ������Ǳ���Ľ�����Ծ��
	 * eg��nums=[3,1,2,2,5]��0λ�ÿ�����1,2,3�����±꣬��Ȼ�������ĸ�Զ��Ǳ�������±�3��
	 */
	public int jump(int[] nums) {
		int steps = 0;
		int posi = 0;
		while(posi<nums.length-1) {
			//�ͱ���λ��posiѡ������Ǳ������һ��
			int max = -1;
			int nextposi = -1;
			for(int i=1;i<=nums[posi];i++) {
				if((posi+i)>=nums.length-1) {//�����һ������posi+i�����Ѿ�����������β����ô�Ͳ���Ҫ����Ǳ������
					steps++;
					return steps;
				}
				if((posi+i+nums[posi+i])>max) {
					max = posi+i+nums[posi+i];
					nextposi = posi+i;
				}
			}
			//ȷ����һ��λ��nextposi�󣬸��µ�ǰposi�������ܲ���+1
			posi = nextposi;
			steps++;
		}
		return steps;
	}
}
