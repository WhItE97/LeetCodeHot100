package _645_1tonȱ1���ظ�1��;

public class Solution {
	public int[] findErrorNums(int[] nums) {
		/**
		* self O(N)˼·����3ms 65%��
		* �ӵ�0λ����ӦԪ��1����ʼ���Ѹ�λ��Ԫ�ؽ��������Ӧ�±��λ�ã���Ԫ��k~�±�k-1��
		* 1.�����k-1λ�Ѿ���k���ظ�����¼�ظ�����
		* 2.���ظ�����λ��Ϊ-1����¼-1��λ��index��������һλ��ʼ��������
		* 3.ÿ������nums[i]=-1����¼-1���±꣬Ȼ����Ե�������������һ�ֵ���
		* 4.ÿ�ν���������һ��=-1���򽻻������index��
		*/
        int repeat = -1;
        int index = -1;
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=(i+1)){//1.��ǰλ���ϵ�Ԫ�غ��±겻��Ӧ
            	if(nums[i]==-1){//1.1.nums[i]==-1�������±��break
                    index = i;
                    break;
                }
                if(nums[nums[i]-1]==nums[i]){//1.2.��ǰԪ�ض�Ӧ��λ���Ѿ�����ͬԪ�أ����ҵ�repeat�����õ�ǰԪ��Ϊ-1������index��Ȼ�������һ�����ıȽ�
                    repeat = nums[i];
                    nums[i] = -1;
                    index = i;
                    break;
                }
                else {//1.3.��ǰԪ�صĹ���λ�������Ų��������Ǹ��±��Ԫ��
                	if(nums[nums[i]-1]==-1) {//1.3.1.����Է���-1���򽻻������index
                		nums[nums[i]-1] = nums[i];
                		nums[i] = -1;
                		index = i;
                	}
                	else {//1.3.2.����Է���-1��������swap
                		int temp = nums[nums[i]-1];
                		nums[nums[i]-1] = nums[i];
                		nums[i] = temp;
                	}
                }
            }
        }
        return new int[]{repeat,index+1};
    }
}
