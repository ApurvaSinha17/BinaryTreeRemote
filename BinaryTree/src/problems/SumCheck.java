package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class SumCheck {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		int sum = 13;
		int val = 0 - sum;
		if(hasPath(rootNode,val))
			System.out.println("Path present");
		else
			System.out.println("Path not present");
	}
	
	private static Boolean hasPath(BinaryTreeNode node, int sum){
		
		if(sum == 0)
			return true;
		else if(node == null)
			return false;
		else{
			sum = sum + node.getData();
			return hasPath(node.getLeftNode(),sum) || hasPath(node.getRightNode(), sum);
		}
	}

}
