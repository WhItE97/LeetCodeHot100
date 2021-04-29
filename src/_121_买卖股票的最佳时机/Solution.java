package _121_买卖股票的最佳时机;

/**
 * 题目：
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Solution {
	/**
	 * self思路：【O(N)】
	 * 一轮遍历，维护一个i以前的min，每轮用price[i]-min去和max取max
	 */
	public int maxProfit(int[] prices) {
		int min = prices[0];
		int maxprofit = 0;
		for(int i=1;i<prices.length;i++) {
			maxprofit = Math.max(maxprofit, prices[i]-min);
			min = Math.min(min, prices[i]);
		}
		return maxprofit;
    }
}
