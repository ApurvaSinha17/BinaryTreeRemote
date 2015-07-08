package problems;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class VerticalSum {

	private static TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
	
	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		traverse(rootNode, 0);
		
		//Printing out the vertical sum
		System.out.println("From left to right");
		Iterator iter = map.entrySet().iterator();		
		while(iter.hasNext()){
			Map.Entry<Integer,Integer> entry = (Entry<Integer, Integer>) iter.next();
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
	
	private static void traverse(BinaryTreeNode node,int col){
		
		if(node == null)
			return;
		
		traverse(node.getLeftNode(), col-1);
		traverse(node.getRightNode(), col+1);
		
		Integer data = map.get(col);
		if(data != null)
			map.put(col, node.getData() + data);
		else
			map.put(col, node.getData());		
		
	}

}
