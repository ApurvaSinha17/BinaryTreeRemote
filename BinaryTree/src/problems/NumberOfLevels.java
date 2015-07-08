package problems;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class NumberOfLevels {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		int levels = levels(rootNode);
		System.out.println("Number of levels: "+levels);
	}
	
	private static int levels(BinaryTreeNode node){
		
		if(node == null)
			return -1;
		
		int level = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(node);
		queue.add(null);
		
		while(!queue.isEmpty()){
			BinaryTreeNode currNode = queue.poll();
			if(currNode == null){
				if(!queue.isEmpty())
					queue.add(null);
				level++;
			}
			else{
				if(currNode.getLeftNode() != null)
					queue.add(currNode.getLeftNode());
				if(currNode.getRightNode() != null)
					queue.add(currNode.getRightNode());
			}
		}		
		
		return level;
	}

}
