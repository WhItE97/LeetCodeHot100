package _79_单词搜索;

/**
 * 题目：
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Solution {
	/**
	 * self思路：
	 * 遍历board找到所有word的起点字符，然后在该起点位置进行dfs。一旦搜索成功，立刻结束。
	 */
	public boolean exist(char[][] board, String word) {
		//base
		if(word.length()>board.length*board[0].length) {
			return false;
		}
		char[] ch = word.toCharArray();
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(flag) {
					return true;
				}
				if(board[i][j]==ch[0]) {
					dfs(board,ch,1,i,j);
				}
			}
		}
		return flag;
    }
	boolean flag = false;//每次搜索前先检查flag，如果已经==true，则没必要再继续搜索
	//ch[]:word的char array
	//k:当前要去match的ch中字符下标
	//(x,y)当前board的下标
	//【ATT.因为一个格子不能重复选取，所以每次选择某格后，都要把该格子变为'-'】
	public void dfs(char[][] board,char[] ch,int k,int x,int y) {
		//1.结束条件
		if(k==ch.length) {
			flag = true;
			return ;
		}
		
		//2.dfs当前(x,y)的上下左右，尝试去match word的下标k的字符
		for(int i=0;i<4;i++) {
			if(i==0&&(x-1)>=0) {//上
				if(board[x-1][y]==ch[k]) {
					//做选择
					board[x-1][y] = '-';
					//dfs
					dfs(board,ch,k+1,x-1,y);
					//撤销选择
					board[x-1][y] = ch[k];
				}
			}
			else if(i==1&&(x+1)<board.length) {//下
				if(board[x+1][y]==ch[k]) {
					board[x+1][y] = '-';
					dfs(board,ch,k+1,x+1,y);
					board[x+1][y] = ch[k];
				}
			}
			else if(i==2&&(y-1)>=0) {//左
				if(board[x][y-1]==ch[k]) {
					board[x][y-1] = '-';
					dfs(board,ch,k+1,x,y-1);
					board[x][y-1] = ch[k];
				}
			}
			else if(i==3&&(y+1)<board[0].length) {//右
				if(board[x][y+1]==ch[k]) {
					board[x][y+1] = '-';
					dfs(board,ch,k+1,x,y+1);
					board[x][y+1] = ch[k];
				}
			}
		}
	}
}
