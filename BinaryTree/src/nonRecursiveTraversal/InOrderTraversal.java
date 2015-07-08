package nonRecursiveTraversal;

import java.util.Stack;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

/*
 * Result: 3 2 4 1 6 5 7
 */
public class InOrderTraversal {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createFullBinaryTree();
		
		traverse(rootNode);
	}

	private static void traverse(BinaryTreeNode node){
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		while(true){
			
			if(node != null){				
				stack.push(node);
				node = node.getLeftNode();
			}
			else{
				if(stack.isEmpty())
					break;
				else{
					BinaryTreeNode currNode = stack.pop();
					System.out.print(currNode.getData()+" ");
					node = currNode.getRightNode();
				}
			}
		}
	}
}
