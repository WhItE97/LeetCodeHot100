package _4_寻找2个正序数组的中位数;

public class Solution2 {
	/**
	 * 官方题解思路：【best O(log(m+n))】
	 * 两个序列的中位数——>设两个数组分别长m和n
	 * 则有中位数下标=
	 * （1）(m+n)/2					m+n为奇数
	 * （2）(m+n)/2和(m+n)/2-1的平均值	m+n为偶数
	 * 1.则可以转化为，求两个序列的第k小的数（Solution1中的O(1)空间算法：两个指针一位一位挪找第k小——>要实现log就二分啊！又是有序数组！不用一位一位啊！直接一半一半砍！）
	 * 2.“两个序列第k小”——>则每次循环排除k/2个!（排除完后记得更新新的k！）(如k=7；则每次排除k/2=3个，则上下两个序列各取k/2个元素【对应下标k/2-1】进行比较，排除后根据删除元素个数更新k！)
	 * 3.如果
	 * （1）a[k/2-1]<b[k/2-1]:排除a[k/2-1]及其前面的所有！因为比a[k/2-1]小的数最多只有a前面的(k/2-1个【对应下标k/2-2】)加上b前面的k/2-1个<=k-2个—>还没到达要求的第k小，所以放心排除
	 * （2）a[k/2-1]>b[k/2-1]:同理排除b[k/2-1]及其前面的所有
	 * （3）a[k/2-1]==b[k/2-1]:随便归入上面哪一种情况都行（这里的算法实现我选择归入第一种）
	 * 4.一轮排除后：
	 * （假设第一步a[k/2-1]<b[k/2-1]）
	 * （1）a的前k/2-1被排除，则理论上其offset=k/2（即【a从k/2开始算作首元素】！）——>【但是！！ATT.这里可能offset+k/2-1已经越界了！所以排除的个数不一定有这么多！】
	 * （2）并且更新k！【k-= (newindex-offset+1)】——>【ATT.k可能没有减到1半那么多！(可能越界！)所以k的更新要用一个newindex和offset做减法来确定】
	 * （3）循环往复，直到k=1的时候，求第1小，则直接把两个数组的“当前首部（有offset）”进行比较，小的那个就是第一小！
	 * 
	 * self实现思路：
	 * 1.实现一个输入两个数组offset，当前k，递归寻找第k小的子函数
	 * 2.根据m+n的奇偶，决定求1次or2次第k小，然后输入子函数求返回值即可
	 * 
	 * 总结：
	 * 1.思路：①找第k小，则各取k/2个偏移量做下标进行二分的元素排除，②每次排除后，k都会变化！所以注意更新！③k==1为结束条件，直接比两个元素的当前位置元素值，返回小的就是第1小
	 * 2.实现：比较多易错点
	 * （1）奇数和偶数长度就是求1次和2次的区别
	 * （2）进入findKth子函数首先要判断offset有没有越界！如果其中一个越界，则直接返回另一个的第k小(offset+k-1)！
	 * （3）如果offset没有越界，offset+本轮k/2后还要检查第二次有没有越界！如果越界则只能更新newindex=nums.length-1！
	 * （4）findKth(nums1,offset1,nums2,offset2,k)——>k每轮记得更新(k-=(newindex-offset+1))！
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length+nums2.length;
		if(len==0) {
			return 0.0;
		}
		if((len&1)==0) {//说明有偶数个元素，中位数要求两个去均值
			int m1 = findKth(nums1,0,nums2,0,len/2);
			int m2 = findKth(nums1,0,nums2,0,len/2+1);
			return (m1+m2)/2.0;
		}
		else {
			return (double)findKth(nums1,0,nums2,0,len/2+1);
		}
    }
	//因为每一次子函数只求第k小，所以必是int
	//k是第k小，如m+n=5则k=3
	public int findKth(int[] nums1,int n1,int[] nums2,int n2,int k) {
		//【imp①！base！可能offset已经越界！】
		if(n1==nums1.length) {
			return nums2[n2+k-1];
		}
		if(n2==nums2.length) {
			return nums1[n1+k-1];
		}
		//如果没越界，k==1，直接比
		if(k==1) {
			if(nums1[n1]<=nums2[n2]) {
				return nums1[n1];
			}
			else {
				return nums2[n2];
			}
		}
		//【否则还要加上偏移量再比！又可能出现越界！】
		//【imp②！加上k后又可能越界！】
		else {//k！=1：还会进入下一轮递归
			int index1 = Math.min(nums1.length, n1+k/2)-1;
			int index2 = Math.min(nums2.length, n2+k/2)-1;
			if(nums1[index1]<=nums2[index2]) {//抛弃n1的前k/2个
				k -= (index1-n1+1);//【imp③！k不一定真的减了一半多！】
				return findKth(nums1,index1+1,nums2,n2,k);
			}
			else {
				k -= (index2-n2+1);
				return findKth(nums1,n1,nums2,index2+1,k);//抛弃n2的前k/2个
			}
		}
	}
}
