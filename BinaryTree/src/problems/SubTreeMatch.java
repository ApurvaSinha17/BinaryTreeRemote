package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class SubTreeMatch {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode1 = BinaryTreeCreate.createCompleteBinaryTree();
		BinaryTreeNode rootNode2 = BinaryTreeCreate.createSubTree();
		//BinaryTreeNode rootNode2 = BinaryTreeCreate.createAnotherCompleteBinaryTree();
		//BinaryTreeNode rootNode2 = null;
		
		if(isSubTree(rootNode1, rootNode2)){
			System.out.println("Is a sub tree");
		}
		else{
			System.out.println("Is not a sub tree");
		}

	}
	
	private static Boolean isSubTree(BinaryTreeNode node1, BinaryTreeNode node2){
		
		if(node1 == null || node2 == null)
			return false;
		else
			return (checkSubTree(node1,node2) || checkSubTree(node2,node1));
	}

	private static Boolean checkSubTree(BinaryTreeNode node1, BinaryTreeNode node2){
		
		if(node1 == null)
			return false;
		else if(node1.getData() == node2.getData()){
			if(matchTrees(node1,node2))
				return true;
			else
				return checkSubTree(node1.getLeftNode(),node2) || checkSubTree(node1.getRightNode(),node2);
		}
		else{
			return checkSubTree(node1.getLeftNode(),node2) || checkSubTree(node1.getRightNode(),node2);
		}		
	}
	
	private static Boolean matchTrees(BinaryTreeNode node1, BinaryTreeNode node2){
		
		if(node1 == null && node2 == null)
			return true;
		else if(node1 == null || node2 == null)
			return false;
		else if(node1.getData() != node2.getData())
			return false;
		else{
			//System.out.println("Node1: "+node1.getData()+" Node2: "+node2.getData());
			return (matchTrees(node1.getLeftNode(),node2.getLeftNode()) && matchTrees(node1.getRightNode(),node2.getRightNode()));
		}
	}
}
