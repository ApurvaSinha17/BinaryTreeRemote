package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class PrintAncestors {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		int key = 8;
		System.out.println("Ancestors of a Binary Tree Node");
		getAncestors(rootNode,key);
	}
	
	private static Boolean getAncestors(BinaryTreeNode node, int key){
		
		if(node == null)
			return false;
		
		if(node.getLeftNode() != null){
			if(node.getLeftNode().getData() == key || getAncestors(node.getLeftNode(), key)){
				System.out.print(node.getData()+" ");
				return true;
			}				
		}
		if(node.getRightNode() != null){
			if(node.getRightNode().getData() == key || getAncestors(node.getRightNode(), key)){
				System.out.print(node.getData()+" ");
				return true;
			}				
		}
		
		return false;
	}
	
}
