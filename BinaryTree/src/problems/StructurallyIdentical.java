package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class StructurallyIdentical {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode1 = BinaryTreeCreate.createCompleteBinaryTree();
		BinaryTreeNode rootNode2 = BinaryTreeCreate.createAnotherCompleteBinaryTree();
		
		if(isIdentical(rootNode1,rootNode2)){
			System.out.println("Identical");
		}
		else{
			System.out.println("Not Identical");
		}
	}

	private static Boolean isIdentical(BinaryTreeNode node1, BinaryTreeNode node2){
		
		if(node1 == null && node2 == null)
			return true;
		else if(node1 == null || node2 == null)
			return false;
		else if(node1.getData() != node2.getData())
			return false;
		else{
			BinaryTreeNode lnode1 = node1.getLeftNode();
			BinaryTreeNode lnode2 = node2.getLeftNode();
			BinaryTreeNode rnode1 = node1.getRightNode();
			BinaryTreeNode rnode2 = node2.getRightNode();
			
			return isIdentical(lnode1,lnode2) && isIdentical(rnode1, rnode2);
		}
	}
}

