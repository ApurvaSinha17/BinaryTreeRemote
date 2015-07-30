package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

//Time Complexity: O(n log(n))
//Space Complexity: O(log(n))
public class PathMatchesSum {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		int sum = 12;
		findSum(rootNode,sum);
	}
	
	private static void findSum(BinaryTreeNode node,int sum){
		
		int depth = depth(node);
		int[] paths = new int[depth];
		findSum(node,sum,paths,0);
	}
	
	private static void findSum(BinaryTreeNode node,int sum,int[] paths,int level){
		
		if(node == null)
			return;
		
		paths[level] = node.getData();
		int x = 0;
		for(int i=level;i>=0;i--){
			x = x + paths[i];
			if(x == sum)
				printPath(paths, i, level);
		}
		
		findSum(node.getLeftNode(),sum,paths,level + 1);
		findSum(node.getRightNode(),sum,paths,level + 1);
	}
	
	private static int depth(BinaryTreeNode node){
		
		if(node == null)
			return 0;
		
		int left = depth(node.getLeftNode());
		int right = depth(node.getRightNode());
		
		return 1 + Math.max(left, right);
	}
	
	private static void printPath(int[] paths,int start,int end){
		
		System.out.println("Path is");
		for(int i=start;i<=end;i++)
			System.out.print(paths[i]+" ");
		System.out.println("");
	}

}
