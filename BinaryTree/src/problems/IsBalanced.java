package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class IsBalanced {
	
	private static boolean balanceFlag = true;
	private static boolean flag = false;
	private static int height = 0;

	public static void main(String[] args) {
		
	BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();	
	checkBalance(rootNode,0);
	
	if(balanceFlag)
		System.out.println("Is balanced");
	else
		System.out.println("Is not balanced");
	}

	private static void checkBalance(BinaryTreeNode node,int count){
		
		if (balanceFlag) {
			if (node == null)
				return;
			if (node.getLeftNode() == null && node.getRightNode() == null) {
				if (flag) {
					if (Math.abs(count - height) > 1)
						balanceFlag = false;						
				} else {
					height = count;
					flag = true;
				}
			}
			checkBalance(node.getLeftNode(), count + 1);
			checkBalance(node.getRightNode(), count + 1);
		}
	}
}
