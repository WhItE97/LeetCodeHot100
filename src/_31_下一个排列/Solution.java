package _31_下一个排列;

/**
 * 题目：
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class Solution {
	/**
	 * self思路：【WRONG】
	 * 从后向前遍历，left指向左边的，right指向右边的，找到第一对nums[left]<nums[right]的【不对..12543——>理应是13245】，进行交换；然后return即可
	 * 如果找到left越界还没找到，就说明已经是最大的数，直接把数组反序即可。
	 * 
	 * self修正思路：【WRONG 213/265】
	 * 1.从后向前遍历，用min记录找到的当前最小值，minindex记录其下标；
	 * 2.找到第一个小于该min值的target，将其与min交换【还是有缺陷，只A了188/265，没考虑到2,3,1这种找不到比1小的的情况，所以需要迭代把min设置为3进入下一轮search】
	 * ——>【还是不得行213/265..大体对了，还有个细节没注意到！即：找左边的数的时候，不应该是找左边的一个较小数，其还应该有个限制条件“该较小数尽量靠右！”，见Solution2】
	 * 3.最后还需要把[targetindex+1,minindex]的数从小到大排列起来
	 */
	public void nextPermutation(int[] nums) {
		//base
		if(nums.length<2) {
			return;
		}
		nextSearch(nums,nums.length-1);
    }
	//minstart用于记录本轮从哪个位置开始找min，以应对2,3,1这种情况
	public void nextSearch(int[] nums,int minstart) {
		int minindex = minstart;
		int min = nums[minindex];
		int targetindex = -1;
		for(int i=minindex-1;i>=0;i--) {
			//从后往前找到第一个比min小的
			if(nums[i]<min) {
				//找到后先交换二者
				int tmp = nums[i];
				nums[i] = nums[minindex];
				nums[minindex] = tmp;
				//再记录交换target的下标
				targetindex = i;
				break;
			}
		}
		//如果没找到，要分情况【（WRONG）说明已经是max，直接reverse数组】
		if(targetindex==-1) {
			if(minstart>1) {//1.如果迭代的minstart还没到头，则迭代找
				nextSearch(nums,minstart-1);
			}
			else {//2.迭代的minstart到头了，说明整个数组都是降序的了，则直接reverse
				for(int i=0;i<nums.length/2;i++) {
					int tmp = nums[i];
					nums[i] = nums[nums.length-1-i];
					nums[nums.length-1-i] = tmp;
				}
			}
		}
		//如果找到了，则还需要把[targetindex+1,nums.length-1]的数组从小到大排好
		//这里我用快排
		else {
			int left = targetindex+1;
			int right = nums.length-1;
			quicksort(nums,left,right);
		}
	}
	
	public void quicksort(int[] arr,int start,int end) {
		//结束条件
		if(start>=end) {
			return;
		}
		int pivot = arr[start];
		int left = start;
		int right = end;
		while(left<right) {
			//先从右边找到一个比pivot小的
			while(arr[right]>=pivot&&right>left) {
				right--;
			}
			if(right>left) {
				arr[left] = arr[right];
			}
			//再从左边找一个比pivot大的
			while(arr[left]<=pivot&&right>left) {
				left++;
			}
			if(right>left) {
				arr[left] = arr[right];
			}
		}
		//最后把pivot插进去
		arr[left] = pivot;
		//递归
		quicksort(arr,start,left);
		quicksort(arr,left+1,end);
	}
}
