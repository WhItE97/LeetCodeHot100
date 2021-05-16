package _208_ʵ��Trieǰ׺��;

/**
 * �ٷ����selfʵ�֣����ٶȺ��Լ�д��TrieҲûɶ����..��Ҫ���ǲ�����ÿ�ζ�ȥ����List�Ҹ��ִε��ַ����������Ҳ�������Ҫboolean flag����
 * ����stringֻ��СдӢ����ĸ��ɣ����Կ��Բ��ö�̬�仯��list�����ó���Ϊ26������
 */
public class Trie2{
	Trie2[] children;
	boolean end;//��ʾ�ýڵ��Ƿ���ĳ�����ʵ���ֹ�ڵ�
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
    		if(node.children[index]==null) {//˵�������ڸ��ַ�����Ҫ����
    			node.children[index] = new Trie2();
    			node = node.children[index];
    		}
    		else {//���ڸ��ַ������ƶ���ǰnode�����ַ�
    			node = node.children[index];
    		}
    	}
    	node.end = true;//���ý���λ��
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
    		//else match�ɹ���������һ���ַ���match
    		node = node.children[index];
    	}
    	//���ݽ���ʱ�Ľڵ��Ƿ���end�ڵ㣬�ж��Ƿ�����match�����٣�Ҳ���ࣩ
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
