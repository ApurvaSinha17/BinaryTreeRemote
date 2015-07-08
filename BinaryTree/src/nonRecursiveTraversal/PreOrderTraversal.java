package nonRecursiveTraversal;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;
import java.util.Stack;

/*
 * Result: 1 2 3 4 5 6 7
 */
public class PreOrderTraversal {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createFullBinaryTree();
		
		traverse(rootNode);
	}
	
	private static void traverse(BinaryTreeNode node){
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

		while(true){
			
			if(node != null){
				System.out.print(node.getData()+" ");
				stack.push(node);
				node = node.getLeftNode();
			}
			else{
				if(stack.isEmpty())
					break;
				BinaryTreeNode currNode = stack.pop();
				node = currNode.getRightNode();
			}			
		}		
	}

}
