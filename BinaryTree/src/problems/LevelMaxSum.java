package problems;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class LevelMaxSum {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		int level = levelWithMaxSum(rootNode);
		System.out.println("Level with max sum: "+level);
	}
	
	private static int levelWithMaxSum(BinaryTreeNode node){
		
		if(node == null)
			return 0;
		
		int level = 1;
		int levelSum = 0;
		int maxLevel = 0;
		int maxLevelSum = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(node);
		queue.add(null);
		while(!queue.isEmpty()){			
			node = queue.poll();
			if(node == null){
				if(!queue.isEmpty())
					queue.add(null);
				if(levelSum > maxLevelSum){
					maxLevelSum = levelSum;
					maxLevel = level;
				}
				levelSum = 0;
				level++;
			}
			else{
				levelSum = levelSum + node.getData();
				if(node.getLeftNode() != null)
					queue.add(node.getLeftNode());
				if(node.getRightNode() != null)
					queue.add(node.getRightNode());
			}
		}
		
		return maxLevel;
	}

}
