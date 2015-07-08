package nonRecursiveTraversal;

import java.util.ArrayDeque;
import java.util.Queue;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

/*
 * Result: 1 2 5 3 4 6 7
 */
public class LevelOrderTraversal {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createFullBinaryTree();
		traverse(rootNode);
	}

	private static void traverse(BinaryTreeNode node){
		
		if(node == null)
			return;
		
		Queue<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();
		queue.add(node);
		while(!queue.isEmpty()){
			BinaryTreeNode curr = queue.poll();
			System.out.print(curr.getData()+" ");
			if(curr.getLeftNode() != null)
				queue.add(curr.getLeftNode());
			if(curr.getRightNode() != null)
				queue.add(curr.getRightNode());
		}
	}
}
