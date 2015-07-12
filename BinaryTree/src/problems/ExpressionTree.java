package problems;

import java.util.Stack;

import createBinaryTree.BinaryTreeCharNode;

public class ExpressionTree {

	public static void main(String[] args) {
		
		//Valid Postfix expression
		String postFixExpr = "ABC*+D/";
		char[] postFixArr = postFixExpr.toCharArray();
				
		BinaryTreeCharNode rootNode = buildExprTree(postFixArr);
		
		//Inorder traversal of binary tree
		inOrder(rootNode);
	}

	private static void inOrder(BinaryTreeCharNode node){
		
		if(node == null)
			return;
		
		inOrder(node.getLeftNode());
		System.out.print(node.getData()+" ");
		inOrder(node.getRightNode());;
	}
	
	private static BinaryTreeCharNode buildExprTree(char[] post){
		
		Stack<BinaryTreeCharNode> stack = new Stack<BinaryTreeCharNode>();
		
		for(int i=0;i<post.length;i++){
			
			if(post[i] == '+' || post[i] == '*' || post[i] == '-' || post[i] == '/' || post[i] == '%'){
				BinaryTreeCharNode rNode = stack.pop();
				BinaryTreeCharNode lNode = stack.pop();
				BinaryTreeCharNode node = new BinaryTreeCharNode();
				node.setData(post[i]);
				node.setLeftNode(lNode);
				node.setRightNode(rNode);
				stack.push(node);
			}
			else{
				BinaryTreeCharNode node = new BinaryTreeCharNode();
				node.setData(post[i]);
				node.setLeftNode(null);
				node.setRightNode(null);
				stack.push(node);
			}
		}
		
		return stack.pop();
	}
}
