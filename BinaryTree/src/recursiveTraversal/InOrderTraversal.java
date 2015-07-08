package recursiveTraversal;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

/*
 * Result: 3 2 4 1 6 5 7
 */
public class InOrderTraversal {

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
			System.out.print(node.getData()+" ");
			traverse(node.getRightNode());
		}
	}
}
