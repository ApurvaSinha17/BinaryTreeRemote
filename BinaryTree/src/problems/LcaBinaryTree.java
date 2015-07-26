package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class LcaBinaryTree {
	
	private static boolean firstNodeFound = false;
	private static boolean secondNodeFound = false;

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		BinaryTreeNode a = new BinaryTreeNode();
		a.setData(8);
		BinaryTreeNode b = new BinaryTreeNode();
		b.setData(4);
		
		//Pre-condition: Check whether both the nodes are present in the Binary Tree
		bothNodesFound(rootNode,a,b);
		
		if(firstNodeFound && secondNodeFound){
			BinaryTreeNode lca = findLca(rootNode, a, b);
			if(lca != null)
				System.out.println("LCA is: "+lca.getData());
		}
		else{
			if(!firstNodeFound && !secondNodeFound)
				System.out.println("Both nodes were not found in the Binary Tree");
			else{
				BinaryTreeNode nodeNotFound = !firstNodeFound ? a : b;
				System.out.println("Node "+nodeNotFound.getData()+" was not found in the Binary Tree");
			}			
		}		
	}
	
	private static void bothNodesFound(BinaryTreeNode node,BinaryTreeNode x,BinaryTreeNode y){
		
		if (!firstNodeFound || !secondNodeFound) {
			if (node == null)
				return;
			if (node.getData() == x.getData())
				firstNodeFound = true;
			if (node.getData() == y.getData())
				secondNodeFound = true;
			
			bothNodesFound(node.getLeftNode(),x,y);
			bothNodesFound(node.getRightNode(), x, y);
		}
	}
	
	private static BinaryTreeNode findLca(BinaryTreeNode node, BinaryTreeNode a, BinaryTreeNode b){
		
		if(node == null)
			return null;
		
		// if at least one matched, no need to continue
        // this is the LCA for this root
		if(node.getData() == a.getData() || node.getData() == b.getData())
			return node;
		
		BinaryTreeNode left = findLca(node.getLeftNode(), a, b);
		BinaryTreeNode right = findLca(node.getRightNode(), a, b);
		
		// nodes are each on a separate branch
		if(left != null && right != null)
			return node;
		
		// either one node is on one branch, 
	    // or none was found in any of the branches
		return left != null ? left : right;
	}

}
