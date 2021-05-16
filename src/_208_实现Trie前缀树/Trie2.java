package _208_实现Trie前缀树;

/**
 * 官方题解self实现：【速度和自己写的Trie也没啥区别..主要就是不用再每次都去遍历List找该轮次的字符（还可能找不到，需要boolean flag）】
 * 本题string只由小写英文字母组成，所以可以不用动态变化的list，而用长度为26的数组
 */
public class Trie2{
	Trie2[] children;
	boolean end;//表示该节点是否是某个单词的终止节点
    /** Initialize your data structure here. */
    public Trie2() {
    	children = new Trie2[26];
    	end = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Trie2 node = this;
    	for(int i=0;i<word.length();i++) {
    		char tmp = word.charAt(i);
    		int index = tmp-'a';
    		if(node.children[index]==null) {//说明不存在该字符，需要插入
    			node.children[index] = new Trie2();
    			node = node.children[index];
    		}
    		else {//存在该字符，则移动当前node到该字符
    			node = node.children[index];
    		}
    	}
    	node.end = true;//设置结束位置
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Trie2 node = this;
    	for(int i=0;i<word.length();i++) {
    		char tmp = word.charAt(i);
    		int index = tmp-'a';
    		if(node.children[index]==null) {
    			return false;
    		}
    		//else match成功，进入下一个字符的match
    		node = node.children[index];
    	}
    	//根据结束时的节点是否是end节点，判断是否正好match（不少，也不多）
    	return node.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Trie2 node = this;
    	for(int i=0;i<prefix.length();i++) {
    		char tmp = prefix.charAt(i);
    		if(node.children[tmp-'a']==null) {
    			return false;
    		}
    		node = node.children[tmp-'a'];
    	}
    	return true;
    }
}
