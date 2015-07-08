package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class LcaBinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		BinaryTreeNode a = new BinaryTreeNode();
		a.setData(8);
		BinaryTreeNode b = new BinaryTreeNode();
		b.setData(7);
		BinaryTreeNode lca = findLca(rootNode, a, b);
		if(lca != null)
			System.out.println("LCA is: "+lca.getData());
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
