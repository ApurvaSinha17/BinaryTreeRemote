package problems;

import java.util.ArrayList;
import java.util.LinkedList;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class PrintRootToLeaf {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		printValues(rootNode);
	}
	
	public static void printValues(BinaryTreeNode node){
		
		int[] values = new int[256];
		printValues(node,values,0);
	}
	
	private static void printValues(BinaryTreeNode node, int[] values,int len){
		
		if(node == null)
			return;
		
		values[len] = node.getData();
		len++;
		if(node.getLeftNode() == null && node.getRightNode() == null){
			display(values,len);
		}
		printValues(node.getLeftNode(),values,len);
		printValues(node.getRightNode(), values,len);
	}
	
	private static void display(int[] values,int len){
		
		for(int i=0;i<len;i++){
			System.out.print(values[i]+" ");
		}
		System.out.println("");
	}
}
