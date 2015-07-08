package problems;

import java.util.Scanner;

import createBinaryTree.BinaryTreeCreate;
import createBinaryTree.BinaryTreeNode;

/*
 *				1
 * 		2				5		
 * 	3		4		6		7	
 */

public class SearchAnElement {

	public static void main(String[] args) {
			
		BinaryTreeNode rootNode = BinaryTreeCreate.createFullBinaryTree();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number to search");
		int num = 0;
		try {
			num = scanner.nextInt();
			if(search(rootNode,num))
				System.out.println("Element found");
			else
				System.out.println("Element not found");
		} catch (Exception e) {
			System.out.println("Enter a valid number");
		}
		finally{
			scanner.close();
		}
	}

	// recursive method
	private static Boolean search(BinaryTreeNode node, int key){
		
		if(node == null)
			return false;
		
		if(node.getData() == key)
			return true;
		
		if(search(node.getLeftNode(), key) == true || search(node.getRightNode(), key) == true)
			return true;
		else
			return false;

	}
}
