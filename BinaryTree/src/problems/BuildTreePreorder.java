package problems;

import createBinaryTree.BinaryTreeNode;

public class BuildTreePreorder {

	public static void main(String[] args) {
		
		char[] pre = {'I','L','I','L','L'};
		BinaryTreeNode rootNode = buildTree(pre, 0);
		PrintRootToLeaf.printValues(rootNode);
		System.out.println("I "+ (int) 'I');
		System.out.println("L "+ (int) 'L');
	}
	
	private static BinaryTreeNode buildTree(char[] pre, int i){
		
		if(pre[i] == '\0')
			return null;
		
		BinaryTreeNode node = new BinaryTreeNode();
		node.setData(pre[i]);
		
		if(pre[i] == 'L')
			return node;
		
		i = i + 1;
		node.setLeftNode(buildTree(pre, i));
		i = i + 1;
		node.setRightNode(buildTree(pre,i));
		
		return node;
	}

}
