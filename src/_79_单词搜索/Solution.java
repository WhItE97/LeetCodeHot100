package _79_��������;

/**
 * ��Ŀ��
 * ����һ�� m x n ��ά�ַ����� board ��һ���ַ������� word ����� word �����������У����� true �����򣬷��� false ��
 * ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
 */
public class Solution {
	/**
	 * self˼·��
	 * ����board�ҵ�����word������ַ���Ȼ���ڸ����λ�ý���dfs��һ�������ɹ������̽�����
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
	boolean flag = false;//ÿ������ǰ�ȼ��flag������Ѿ�==true����û��Ҫ�ټ�������
	//ch[]:word��char array
	//k:��ǰҪȥmatch��ch���ַ��±�
	//(x,y)��ǰboard���±�
	//��ATT.��Ϊһ�����Ӳ����ظ�ѡȡ������ÿ��ѡ��ĳ��󣬶�Ҫ�Ѹø��ӱ�Ϊ'-'��
	public void dfs(char[][] board,char[] ch,int k,int x,int y) {
		//1.��������
		if(k==ch.length) {
			flag = true;
			return ;
		}
		
		//2.dfs��ǰ(x,y)���������ң�����ȥmatch word���±�k���ַ�
		for(int i=0;i<4;i++) {
			if(i==0&&(x-1)>=0) {//��
				if(board[x-1][y]==ch[k]) {
					//��ѡ��
					board[x-1][y] = '-';
					//dfs
					dfs(board,ch,k+1,x-1,y);
					//����ѡ��
					board[x-1][y] = ch[k];
				}
			}
			else if(i==1&&(x+1)<board.length) {//��
				if(board[x+1][y]==ch[k]) {
					board[x+1][y] = '-';
					dfs(board,ch,k+1,x+1,y);
					board[x+1][y] = ch[k];
				}
			}
			else if(i==2&&(y-1)>=0) {//��
				if(board[x][y-1]==ch[k]) {
					board[x][y-1] = '-';
					dfs(board,ch,k+1,x,y-1);
					board[x][y-1] = ch[k];
				}
			}
			else if(i==3&&(y+1)<board[0].length) {//��
				if(board[x][y+1]==ch[k]) {
					board[x][y+1] = '-';
					dfs(board,ch,k+1,x,y+1);
					board[x][y+1] = ch[k];
				}
			}
		}
	}
}
