package problems;

import java.util.Stack;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class ZigzagTraversal {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		zigzag(rootNode);
	}
	
	//Two stacks (pops from the same stack and pushes to the other stack) and a direction flag to switch the order of pushing nodes to stack (left to right or right to left)
	//Two while loops required: One for popping out all the values and other for switching stacks
	private static void zigzag(BinaryTreeNode node){
		
		if(node == null)
			return;
		
		Boolean leftToRight = true;
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(node);
		
		while(!stack.isEmpty()){
			
			Stack<BinaryTreeNode> tempStack = new Stack<BinaryTreeNode>();
			
			while (!stack.isEmpty()) {
				
				BinaryTreeNode currNode = stack.pop();
				System.out.print(currNode.getData()+" ");
				
				if (leftToRight) {
					if (currNode.getLeftNode() != null)
						tempStack.push(currNode.getLeftNode());
					if (currNode.getRightNode() != null)
						tempStack.push(currNode.getRightNode());
				} else {
					if (currNode.getRightNode() != null)
						tempStack.push(currNode.getRightNode());
					if (currNode.getLeftNode() != null)
						tempStack.push(currNode.getLeftNode());
				}
			}
			
			leftToRight = !leftToRight;
			stack = tempStack;
		}
	}

}
