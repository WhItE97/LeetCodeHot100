package _208_实现Trie前缀树;

import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
/**
 * 题目：
 * 1.前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 2.Trie() 初始化前缀树对象。
 * 3.void insert(String word) 向前缀树中插入字符串 word 。
 * 4.boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * 5.boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
/**
 * self思路：【虽然对的，但是因为用的是LinkedList做儿子集合，所以造成了很多代码上的冗余，这里可以抓住单词！——>只有26个字母！所以优化为数组！（见Trie2）】
 * 构建一颗多叉排序树(顺序按照字母对应数值大小)去match
 * 如何实现多叉树？——>self：分支数量还不确定，那就用List去装子节点，并且该List按照节点内的字符值排序
 */
public class Trie {
	Node root;
	
	/** Initialize your data structure here. */
    public Trie() {
    	root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	//1.根据word的字符，对应层序依次查找，一直到某个节点的所有子节点中没有word中下一个待match的字符，则将word中剩下的字符依次插入该分支的树
    	Node node = root;
    	int index = 0;//用于记录match到word的第几个字符
    	while(index<word.length()) {
    		//遍历本节点的所有儿子，查找word的某个字符
    		boolean flag = false;
    		for(int i=0;i<node.children.size();i++) {
    			if(node.children.get(i).val==word.charAt(index)) {
    				node = node.children.get(i);//找到对应节点后先修改node位置
    				index++;//然后开始match word的下一个字符
    				flag = true;//修改flag告诉后续处理"本轮的nodematch到了"
    				break;
    			}
    		}
    		//pro：如何判断没有找到的情况——>flag
    		if(!flag) {//说明本轮节点的所有儿子都没有找到word待match的字符！则可以直接生成新节点并插入！
    			for(int i=index;i<word.length();i++) {
    				node.children.add(new Node(word.charAt(i)));
    				node = node.children.get(node.children.size()-1);
    			}
    			break;
    		}
    		//else本轮找到了，则继续进入下一轮
    	}
    	//将本轮插入的单词的最后一个节点标记为"可结束节点，即node.end = true"
    	System.out.println("insert中标记了"+node.val+"的end为true");
    	node.end = true;
    }
    
    /** Returns if the word is in the trie. */
    //search需要保证：1.能够覆盖word 2.且不能比word更长（这里我选择省空间，如app和apple，我都存在apple分支，但是在第二个p处，我存一个boolean end = true；表示他可以代表一个单词的结束）
    public boolean search(String word) {
    	int index = 0;
    	Node node = root;
    	while(index<word.length()) {
    		boolean flag = false;
    		//从根节点的儿子开始找word[0]，一直递归
    		for(int i=0;i<node.children.size();i++) {
    			if(node.children.get(i).val==word.charAt(index)) {
    				//本字符match到，进入下一个字符
    				node = node.children.get(i);
    				index++;
    				flag = true;
    				break;
    			}
    		}
    		if(!flag) {//说明本轮遍历完都没找到
    			return false;
    		}
    	}
    	//出来说明word全match到了；但是！该树可能还有多余节点！所以要再判断是否完全相等（即树是否也已经无子节点了！）
    	if(node.end == true) {
    		return true;
    	}
    	else {
    		return node.children.size()==0;
    	}
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    //startsWith只需要把prefix覆盖了就行
    public boolean startsWith(String prefix) {
    	int index = 0;
    	Node node = root;
    	while(index<prefix.length()) {
    		boolean flag = false;
    		//从根节点的儿子开始找word[0]，一直递归
    		for(int i=0;i<node.children.size();i++) {
    			if(node.children.get(i).val==prefix.charAt(index)) {
    				//本字符match到，进入下一个字符
    				node = node.children.get(i);
    				index++;
    				flag = true;
    				break;
    			}
    		}
    		if(!flag) {//说明本轮遍历完都没找到
    			return false;
    		}
    	}
    	return true;
    }
    
    public void traversal() {
		Deque<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				Node tmp = queue.poll();
				System.out.print(tmp.val+" ");
				for(int j=0;j<tmp.children.size();j++) {
					queue.add(tmp.children.get(j));
				}
			}
			System.out.println();
		}
	}
}

class Node{
	char val;
	List<Node> children = new LinkedList<>();
	boolean end = false;//用于标记类似：apple和app都插入了，那么app就可以作为一个结束节点！
	
	public Node() {
	}
	
	public Node(char val) {
		this.val = val;
	}
}