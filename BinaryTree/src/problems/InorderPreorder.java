package problems;

import java.util.HashMap;

import createBinaryTree.BinaryTreeNode;

public class InorderPreorder {

	public static void main(String[] args) {
		
		int[] pre = {7,10,4,3,1,2,8,11};
		int[] in = {4,10,3,1,7,11,8,2};
		BinaryTreeNode rootNode = buildTree(pre, in);
		System.out.println("Root to Leaf");
		PrintRootToLeaf.printValues(rootNode);
	}

	private static BinaryTreeNode buildTree(int[] pre,int[] in){
		
		int preLen = pre.length;
		int inLen = in.length;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<inLen;i++){
			map.put(in[i], i);
		}
		
		return buildTree(pre, 0, preLen, map, 0, inLen);
	}
	
	private static BinaryTreeNode buildTree(int[] pre,int preStart,int preEnd, HashMap<Integer,Integer> inMap,int inStart,int inEnd){
		
		if(preEnd <= preStart || inEnd <= inStart)
			return null;
		
		int preVal = pre[preStart];
		int inIndex = inMap.get(preVal);
		int leftSubTreeSize = inIndex - inStart;
		BinaryTreeNode node = new BinaryTreeNode();
		node.setData(pre[preStart]);
		node.setLeftNode(buildTree(pre, preStart+1, preStart+1+leftSubTreeSize, inMap, inStart, inIndex));
		node.setRightNode(buildTree(pre, preStart+1+leftSubTreeSize, preEnd, inMap, inIndex+1, inEnd));
		return node;
	}
}
