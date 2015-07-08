package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class ReverseLevelOrderDisplay {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		traverse(rootNode);
	}
	
	private static void traverse(BinaryTreeNode node){
		
		if(node == null)
			return;
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		queue.add(node);
		queue.add(null);
		while(!queue.isEmpty()){
			node = queue.poll();
			stack.push(node);
			if(node == null){
				if(!queue.isEmpty())
					queue.add(null);
			}
			else{
				if(node.getRightNode() != null)
					queue.add(node.getRightNode());
				if(node.getLeftNode() != null)
					queue.add(node.getLeftNode());				
			}
		}
		while(!stack.isEmpty()){
			BinaryTreeNode btNode = stack.pop();
			if(btNode != null){
				System.out.print(btNode.getData()+" ");
			}
			else{
				System.out.println(" ");
			}
		}
	}
	
	/*private static void traverse(BinaryTreeNode node){
		
		if(node == null)
			return;
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		queue.add(node);
		while(!queue.isEmpty()){
			node = queue.poll();
			stack.push(node);
			if(node.getRightNode() != null)
				queue.add(node.getRightNode());
			if(node.getLeftNode() != null)
				queue.add(node.getLeftNode());
		}	
		while(!stack.isEmpty())
			System.out.print((stack.pop()).getData()+" ");
	}*/

}
