package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

/*
 *						1
 * 			2						5		
 * 	3				4			6		7	
 * 		8
 * 
 * Result: 3
 */
public class Depth {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		System.out.println("Depth: "+depth(rootNode));
	}
	
	//recursive method
	private static int depth(BinaryTreeNode node){
		
		if(node == null)
			return 0;
		
		int leftCount = depth(node.getLeftNode());
		int rightCount = depth(node.getRightNode());
		
		if(leftCount > rightCount)
			return 1 + leftCount;
		else
			return 1 + rightCount;
	}

}
