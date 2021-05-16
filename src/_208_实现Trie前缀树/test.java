package _208_ÊµÏÖTrieÇ°×ºÊ÷;

public class test {

	public static void main(String[] args) {
		Trie2 t = new Trie2();
		System.out.println("insert \"apple\"");
		t.insert("apple");
		System.out.println("**************************");
		System.out.println("insert \"add\"");
		t.insert("add");
		System.out.println("**************************");
		System.out.println("insert \"app\"");
		t.insert("app");
		System.out.println("**************************");
//		System.out.println("insert \"beer\"");
//		t.insert("beer");
//		System.out.println("**************************");
//		System.out.println("insert \"jam\"");
//		t.insert("jam");
//		System.out.println("**************************");
		
//		t.traversal();
		
		

		
		
		System.out.println("search ad="+t.search("ad"));
		System.out.println("**************************");
//		System.out.println(t.root.children.get(0).children.get(1).children.size());
		
		
//		System.out.println("search app="+t.search("app"));
//		System.out.println("**************************");
//		System.out.println("startsWith app="+t.startsWith("app"));
//		System.out.println("**************************");
//		System.out.println("insert \"app\"");
//		t.insert("app");
//		System.out.println("**************************");
//		System.out.println("search app="+t.search("app"));
	}

}
