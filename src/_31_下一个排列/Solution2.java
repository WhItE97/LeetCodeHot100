package _31_下一个排列;

public class Solution2 {
	/**
	 * 力扣Imageslr思路：【1ms 98%】
	 * 【画折线图理解】
	 * 1.理论分析：
	 * 希望得到的下一个排列比当前大，则需要将前面的一个较小数和后面的一个较大数swap，则高位数字变大从而数字变大；
	 * 【ATT】我们还希望下一个数的增幅尽可能小！so：①在尽可能靠右的低位进行swap②将一个尽可能小的“大数”与前面的“小数”进行交换
	 * ③但是只是单纯的swap并不能保证是第一个大于它本身的排列——>还需要把swap的高位以后的所有数字排列成升序！
	 * 【CORE POINT.自己的用例只通过213/265的原因就在这儿！】我们要【从后向前】找到【第一个】【相邻升序对】；
	 * 并且【不是直接swap他们】，这个升序对只是说明这里【有个低点】【一定可以抬高（保底就他俩swap）！】；
	 * 但是我们还是要尽量swap【比低点大】的【最小数字】，所以要从低点位置向后搜索出【刚好比他大的那一个来swap】
	 * 2.算法步骤：
	 * （1）从后向前找到第一个相邻升序对left和right
	 * （2）从[right,end]找一个刚好大于left的，和left位置的进行swap
	 * （3）把left位置之后的数组按升序sort
	 */
	public void nextPermutation(int[] nums) {
		int right = nums.length-1;
		int left = right-1;
		//1.从后向前找到第一个相邻升序对
		while(left>=0&&nums[left]>=nums[right]) {//【WRONG POINT】升序对！所以持平对不得行！记得取等！
			left--;
			right--;
		}
		if(left<0) {//说明没找到升序对，已经是max，直接reverse即可
			for(int i=0;i<nums.length/2;i++) {
				int tmp = nums[i];
				nums[i] = nums[nums.length-1-i];
				nums[nums.length-1-i] = tmp;
			}
			return ;//【WRONG POINT】reverse后别忘了结束！
		}
		//2.从left之后的元素里，找一个刚好大于他的
		int targetindex = right;
		for(int i=right;i<nums.length;i++) {
			if(nums[i]>nums[left]&&nums[i]<nums[targetindex]) {
				targetindex = i;
			}
		}
		//然后swap该两个位置
		int tmp = nums[left];
		nums[left] = nums[targetindex];
		nums[targetindex] = tmp;
		//3.把[right,end]排序成升序
		quicksort(nums,right,nums.length-1);
    }
	
	public void quicksort(int[] nums,int start,int end) {
		//结束条件
		if(start>=end) {
			return;
		}
		int pivot = nums[start];
		int left = start;
		int right = end;
		while(left<right) {
			//先从右边找一个比pivot小的
			while(left<right&&nums[right]>=pivot) {
				right--;
			}
			if(left<right) {
				nums[left] = nums[right];
			}
			//再从左边找一个比pivot大的
			while(left<right&&nums[left]<pivot) {
				left++;
			}
			if(left<right) {
				nums[right] = nums[left];
			}
		}
		nums[left] = pivot;
		quicksort(nums,start,left);
		quicksort(nums,left+1,end);
	}
}
