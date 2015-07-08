package problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import createBinaryTree.BinaryTreeNode;

public class InorderLevelorder {
	
	private static int[] levelArray;

	public static void main(String[] args) {
		
		int[] in = {4,10,3,1,7,11,8,2};
		int[] lev = {7,10,2,4,3,8,1,11};
		BinaryTreeNode rootNode = buildTree(in, lev);
		System.out.println("Root to leaf");
		PrintRootToLeaf.printValues(rootNode);
	}
	
	private static BinaryTreeNode buildTree(int[] in, int[] lev){
		
		HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> levMap = new HashMap<Integer, Integer>();
		levelArray = lev;
		for(int i=0;i<in.length;i++)
			inMap.put(in[i], i);
		for(int j=0;j<lev.length;j++)
			levMap.put(lev[j], j);
		return buildTree(in, lev, 0, in.length - 1, inMap, levMap);
	}

	private static BinaryTreeNode buildTree(int[] in, int[] lev, int inStart, int inEnd, HashMap<Integer, Integer> inMap, HashMap<Integer, Integer> levMap){
		
		if(inStart > inEnd)
			return null;
		
		int nodeVal = lev[0];
		BinaryTreeNode node = new BinaryTreeNode();
		node.setData(nodeVal);
		
		if(inStart == inEnd)
			return node;
		
		int inIndex = inMap.get(nodeVal);
		int[] leftSubTree = subArray(in, levelArray, inStart, inIndex-1, inMap, levMap);
		int[] rightSubTree = subArray(in, levelArray, inIndex+1, inEnd, inMap, levMap);
		
		node.setLeftNode(buildTree(in, leftSubTree, inStart, inIndex-1, inMap, levMap));
		node.setRightNode(buildTree(in, rightSubTree, inIndex+1, inEnd, inMap, levMap));
		
		return node;
	}
	
	private static int[] subArray(int[] in, int[] lev, int inStart, int inEnd, HashMap<Integer, Integer> inMap, HashMap<Integer, Integer> levMap){
		
		int[] newSubArray = new int[inEnd - inStart + 1];
		//System.out.println("Sub Array Size: "+newSubArray.length);
		SortedSet<Integer> set = new TreeSet<Integer>();
		for(int i=inStart;i<=inEnd;i++){
			int levIndex = levMap.get(in[i]);
			set.add(levIndex);
		}
		int j=0;
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()){
			int levIndex = iter.next();
			//System.out.println("Level Index: "+levIndex+ "Value: "+lev[levIndex]);
			int levValue = lev[levIndex];
			newSubArray[j] = levValue;
			j++;
		}
		
		return newSubArray;
	}
}
