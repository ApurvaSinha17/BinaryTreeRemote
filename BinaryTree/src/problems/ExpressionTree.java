package problems;

import java.util.Stack;

import createBinaryTree.BinaryTreeCharNode;

/**
 * @author Apurva Kumar Sinha
 * Java program to build an expression tree from a post-fix expression
 * Input: ABC*+D/ (post-fix expression)
 * Output: A+B*C/D (in-fix expression)
 * Presently this code supports just the following binary operators: + * - / %
 */
public class ExpressionTree {

	public static void main(String[] args) {
		
		if(args.length == 0 || "".equals(args[0])){
			System.out.println("No input was provided");
		} else {
			String postFixExpr = args[0];
			char[] postFixArr = postFixExpr.toCharArray();			
			BinaryTreeCharNode rootNode;
			try {
				rootNode = buildExprTree(postFixArr);
				displayAsInfixExpr(rootNode);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}			
			
		}		
	}

	/**
	 * @param node (Root node of the Binary tree)
	 * Prints out the in-fix expression by doing an in-order traversal of the binary tree
	 */
	private static void displayAsInfixExpr(BinaryTreeCharNode node){
		
		if(node != null){
			displayAsInfixExpr(node.getLeftNode());
			System.out.print(node.getData());
			displayAsInfixExpr(node.getRightNode());
		}
		
	}
	
	/**
	 * @param post (Post-fix expression as a char array)
	 * @return Root node of the constructed binary tree
	 */
	private static BinaryTreeCharNode buildExprTree(char[] post) throws Exception{
		
		Stack<BinaryTreeCharNode> stack = new Stack<BinaryTreeCharNode>();
		
		for(int i=0;i<post.length;i++){
			
			if(post[i] == '+' || post[i] == '*' || post[i] == '-' || post[i] == '/' || post[i] == '%'){
				if(stack.isEmpty()){
					throw new RuntimeException("Invalid input");
				}
				BinaryTreeCharNode rNode = stack.pop();
				if(stack.isEmpty()){
					throw new RuntimeException("Invalid input");
				}
				BinaryTreeCharNode lNode = stack.pop();
				BinaryTreeCharNode node = new BinaryTreeCharNode(post[i]);
				node.setLeftNode(lNode);
				node.setRightNode(rNode);
				stack.push(node);
			}
			else{
				BinaryTreeCharNode node = new BinaryTreeCharNode(post[i]);
				node.setLeftNode(null);
				node.setRightNode(null);
				stack.push(node);
			}
		}
		
		return stack.pop();
	}
}
