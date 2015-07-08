package recursiveTraversal;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

/*
 * Result: 1 2 3 4 5 6 7
 */
public class PreOrderTraversal {

	public static void main(String[] args) {
		
		//BinaryTreeNode rootNode = BinaryTreeCreate.createFullBinaryTree();
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		traverse(rootNode);
	}
	
	private static void traverse(BinaryTreeNode node){
		
		if(node == null)
			return;
		else{
			System.out.print(node.getData()+" ");
			traverse(node.getLeftNode());
			traverse(node.getRightNode());
		}
		
	}

}

