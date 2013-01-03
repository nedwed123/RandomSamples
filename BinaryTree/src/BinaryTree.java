import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Vector;


class BinaryTree {
	
	
	public void binarySearchTreeMethods(Vector<Integer> keys) {
		BinarySearchTree bst = new BinarySearchTree(null);
		for (int key: keys) {
			bst.addKey(key);
		}
		
		Node root = bst.getRoot();
		
		System.out.println("inorder traversal");
		bst.traverse();
		
		bst.assignNodeHeight(root);
		bst.setTreeHeight();
		
		//bst.assignNodeDepth(root);

		System.out.println("inorder traversal: ");
		bst.traverse();
		
		System.out.println("preorder traversal: ");
		bst.preorderTraversal(root);
		
		System.out.println("level order traversal: ");
		bst.levelOrderTraversal();
		System.out.println();
		
		System.out.println("pretty print tree: ");
		bst.prettyPrint();
		System.out.println();
		
		//generate two random keys for lowest common ancestor from tree
		Random randomGenerator = new Random();
		int randIdx = randomGenerator.nextInt(keys.size());
		int key1 = keys.elementAt(randIdx);
		randIdx = randomGenerator.nextInt(keys.size());
		int key2 = keys.elementAt(randIdx);
		
		System.out.println("LCA key1: "+ key1 + " LCA key2: " + key2);
		System.out.println("LCA bst: " 
							+ bst.bstLCA(key1, key2).getKey());
		System.out.println("LCA bottom up: " 
				+ bst.bottomUpLCA(root, key1, key2).getKey());
		System.out.println("LCA parent: " + bst.lcaUseParent(key1, key2).getKey());
		
		
	} 
	
	
	public static void main(String[] args) {
		
		BinaryTree bTree = new BinaryTree();
		
		Vector<Integer> keys = new Vector<Integer>();
		
		//parse commandline line by line to get keys
		//open up standard input
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    try {
			String line = "";
    		while((line = br.readLine()) != null) {
	    		keys.add(Integer.parseInt(line));
	        }
    	} catch (IOException ioe) {
	         System.out.println("IO error: " + ioe.getMessage());
    	}
	    
	    bTree.binarySearchTreeMethods(keys);
	    
	}
	
}