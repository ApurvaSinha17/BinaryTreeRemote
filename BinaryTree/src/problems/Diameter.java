package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class Diameter {
	
	private static int diameter = 0;

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		getDiameter(rootNode);
		System.out.println("Diameter: "+diameter);
	}
	
	private static int getDiameter(BinaryTreeNode node){
		
		if(node == null)
			return 0;
		
		int left = getDiameter(node.getLeftNode());
		int right = getDiameter(node.getRightNode());
		if(left + right >= diameter)
			diameter = left + right + 1;
		return Math.max(left, right) + 1;	
	}

}
