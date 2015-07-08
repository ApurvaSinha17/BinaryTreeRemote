package nonRecursiveTraversal;

import java.util.ArrayList;
import java.util.Stack;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

/*
 * Result: 3 4 2 6 7 5 1
 */
public class PostOrderTraversal {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createFullBinaryTree();
		traverse(rootNode);
	}

	private static void traverse(BinaryTreeNode node){
		
		if(node == null)
			return;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(node);
		BinaryTreeNode prev = null;
		BinaryTreeNode curr = null;
		
		while(!stack.isEmpty()){
			
			curr = stack.peek();
			
            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
			//prev == null is the situation for the root node
			if(prev == null || prev.getLeftNode() == curr || prev.getRightNode() == curr){
				if(curr.getLeftNode() != null)
					stack.push(curr.getLeftNode());
				else if(curr.getRightNode() != null)
					stack.push(curr.getRightNode());
				else{
					stack.pop();
					list.add(curr.getData());
				}
			}
            //go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
			else if(curr.getLeftNode() == prev){
				if(curr.getRightNode() != null)
					stack.push(curr.getRightNode());
				else{
					stack.pop();
					list.add(curr.getData());
				}
			}
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack.
			else if(curr.getRightNode() == prev){
				stack.pop();
				list.add(curr.getData());
			}
			
			prev = curr;			
		}
		
		for(Integer val : list){
			System.out.print(val+" ");
		}
	}
}
