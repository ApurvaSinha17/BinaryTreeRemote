package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class CheckMirror {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createFullBinaryTree();
		BinaryTreeNode mirrorRootNode = BinaryTreeCreate.createMirrorBinaryTree();
		if(isMirror(rootNode, mirrorRootNode)){
			System.out.println("Is a mirror");
		}
		else{
			System.out.println("Not a mirror");
		}
	}
	
	private static Boolean isMirror(BinaryTreeNode node, BinaryTreeNode mnode){
		
		/*if(node != null)
			System.out.println("Node: "+node.getData());
		if(mnode != null)
			System.out.println("Mnode: "+mnode.getData());*/
		
		if(node == null && mnode == null)
			return true;
		else if(node == null || mnode == null)
			return false;
		else if(node.getData() != mnode.getData())
			return false;
		else
			return isMirror(node.getLeftNode(), mnode.getRightNode()) && isMirror(node.getRightNode(), mnode.getLeftNode());
	}

}
