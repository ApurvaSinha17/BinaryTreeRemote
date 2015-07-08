package problems;

import java.util.HashMap;

import createBinaryTree.BinaryTreeNode;

public class InorderPostorder {

	public static void main(String[] args) {
		
		int[] in = {4,10,3,1,7,11,8,2};
		int[] post = {4,1,3,10,11,8,2,7};
		BinaryTreeNode rootNode = buildTree(in, post);
		System.out.println("Root to Leaf");
		PrintRootToLeaf.printValues(rootNode);
	}
	
	private static BinaryTreeNode buildTree(int[] in,int[] post){
		
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		int inLen = in.length;
		int postLen = post.length;
		for(int i=0;i<in.length;i++){
			map.put(in[i], i);
		}
		return buildTree(post, 0, postLen, map, 0, inLen);
	}

	private static BinaryTreeNode buildTree(int[] post, int postStart, int postEnd, HashMap<Integer, Integer> inMap, int inStart, int inEnd){
		
		if(postEnd <= postStart || inEnd <= inStart)
			return null;
		
		int postVal = post[postEnd-1];
		int inIndex = inMap.get(postVal);
		int subTreeSize = inIndex - inStart;
		
		BinaryTreeNode node = new BinaryTreeNode();
		node.setData(postVal);
		node.setLeftNode(buildTree(post, postStart, postStart+subTreeSize, inMap, inStart, inIndex));
		node.setRightNode(buildTree(post, postStart+subTreeSize, postEnd-1, inMap, inIndex+1, inEnd));
		return node;
	}
}
