package recursiveTraversal;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

/*
 * Result: 3 4 2 6 7 5 1
 */
public class PostOrderTraversal {

	public static void main(String[] args) {
		
		//BinaryTreeNode rootNode = BinaryTreeCreate.createFullBinaryTree();
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		traverse(rootNode);
	}
	
	private static void traverse(BinaryTreeNode node){
		
		if(node == null)
			return;
		else{
			traverse(node.getLeftNode());
			traverse(node.getRightNode());
			System.out.print(node.getData()+" ");
		}
	}

}
