package _62_不同路径;

/**
 * 题目：
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class Solution {
	/**
	 * self思路：
	 * dfs..【37/62就超时了..见Solution2】
	 */
	public int uniquePaths(int m, int n) {
		dfs(0,0,m,n);
		return routes;
    }
	
	/**
	 * x,y为当前机器人所在坐标
	 * m,n为网格size
	 */
	int routes = 0;
	public void dfs(int x,int y,int m,int n) {
		//1.结束条件
		if(x>m||y>n) {
			return ;
		}
		if(x==m&&y==n) {
			routes++;
			return ;
		}
		
		//dfs
		for(int i=0;i<2;i++) {
			if(i==0) {//向右
				dfs(x,y+1,m,n);
			}
			else {//向下
				dfs(x+1,y,m,n);
			}
		}
	}
}
