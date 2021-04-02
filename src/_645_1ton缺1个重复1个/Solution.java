package _645_1ton缺1个重复1个;

public class Solution {
	public int[] findErrorNums(int[] nums) {
		/**
		* self O(N)思路：【3ms 65%】
		* 从第0位（对应元素1）开始，把该位的元素交换到其对应下标的位置（即元素k~下标k-1）
		* 1.如果第k-1位已经是k则重复，记录重复数字
		* 2.把重复数字位设为-1，记录-1的位置index，从其下一位开始继续调整
		* 3.每次遇到nums[i]=-1，记录-1的下标，然后忽略调整它，进入下一轮调整
		* 4.每次交换遇到另一方=-1，则交换后更新index，
		*/
        int repeat = -1;
        int index = -1;
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=(i+1)){//1.当前位置上的元素和下标不对应
            	if(nums[i]==-1){//1.1.nums[i]==-1，更新下标后break
                    index = i;
                    break;
                }
                if(nums[nums[i]-1]==nums[i]){//1.2.当前元素对应的位置已经有相同元素，则找到repeat；设置当前元素为-1，更新index；然后进入下一个数的比较
                    repeat = nums[i];
                    nums[i] = -1;
                    index = i;
                    break;
                }
                else {//1.3.当前元素的归属位置上有着不归属于那个下标的元素
                	if(nums[nums[i]-1]==-1) {//1.3.1.如果对方是-1，则交换后更新index
                		nums[nums[i]-1] = nums[i];
                		nums[i] = -1;
                		index = i;
                	}
                	else {//1.3.2.如果对方非-1，则正常swap
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
