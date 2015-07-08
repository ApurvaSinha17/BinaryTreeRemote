package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

/*
 *				1
 * 		2				5		
 * 	3		4		6		7	
 */

public class Size {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createFullBinaryTree();
		System.out.println("Size: "+size(rootNode));
	}
	
	// recursive method
	private static int size(BinaryTreeNode node){
		
		if(node == null)
			return 0;
		
		return 1 + size(node.getLeftNode()) + size(node.getRightNode());
	}

}
