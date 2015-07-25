package problems;

import java.util.ArrayList;
import java.util.LinkedList;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

public class LevelLinkedLists {

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeCreate.createCompleteBinaryTree();
		ArrayList<LinkedList<BinaryTreeNode>> result = create(rootNode);
		for(LinkedList<BinaryTreeNode> list : result){
			for(BinaryTreeNode node : list){
				System.out.print(node.getData()+" ");
			}
			System.out.println("");
		}
	}
	
	private static ArrayList<LinkedList<BinaryTreeNode>> create(BinaryTreeNode node){
		
		ArrayList<LinkedList<BinaryTreeNode>> lists = new ArrayList<LinkedList<BinaryTreeNode>>();
		create(node, lists, 0);
		return lists;
	}
	
	private static void create(BinaryTreeNode node, ArrayList<LinkedList<BinaryTreeNode>> lists, int level){
		
		if(node == null)
			return;
		
		LinkedList<BinaryTreeNode> list = null;
		if(lists.size() == level){
			list = new LinkedList<BinaryTreeNode>();
			lists.add(list);
		}
		else
			list = lists.get(level);
		
		list.add(node);
		
		create(node.getLeftNode(),lists,level + 1);
		create(node.getRightNode(),lists,level + 1);
		
	}

}
