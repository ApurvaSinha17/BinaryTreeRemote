package problems;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class CreateMirror {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		System.out.println("Original Binary Tree");
		traverse(rootNode);
		BinaryTreeNode mirrorRootNode = getMirrorRootNode(rootNode);
		System.out.println();
		System.out.println("Original Binary Tree mirror");
		traverse(mirrorRootNode);
	}
	
	private static BinaryTreeNode getMirrorRootNode(BinaryTreeNode node){
		
		if(node == null)
			return null;
		else{
			getMirrorRootNode(node.getLeftNode());
			getMirrorRootNode(node.getRightNode());
			BinaryTreeNode tempNode = node.getRightNode();
			node.setRightNode(node.getLeftNode());
			node.setLeftNode(tempNode);
			return node;
		}
	}
	
	private static void traverse(BinaryTreeNode node){
		if(node == null)
			return;
		else{
			System.out.print(node.getData()+" ");
			traverse(node.getLeftNode());			
			traverse(node.getRightNode());
		}
	}

}
