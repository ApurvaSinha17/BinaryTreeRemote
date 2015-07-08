package createBinaryTree;


public class BinaryTreeCreate {

	/*
	 *				1
	 * 		2				5		
	 * 	3		4		6		7	
	 */
	public static BinaryTreeNode createFullBinaryTree(){
		
		BinaryTreeNode rootNode = new BinaryTreeNode();
		rootNode.setData(1);
		
		BinaryTreeNode l1  = new BinaryTreeNode();
		l1.setData(2);
		BinaryTreeNode l2  = new BinaryTreeNode();
		l2.setData(3);
		BinaryTreeNode l3  = new BinaryTreeNode();
		l3.setData(4);
		
		BinaryTreeNode r1 = new BinaryTreeNode();
		r1.setData(5);
		BinaryTreeNode r2 = new BinaryTreeNode();
		r2.setData(6);
		BinaryTreeNode r3 = new BinaryTreeNode();
		r3.setData(7);
				
		rootNode.setLeftNode(l1);
		rootNode.setRightNode(r1);
		
		l1.setLeftNode(l2);
		l1.setRightNode(l3);
		
		r1.setLeftNode(r2);
		r1.setRightNode(r3);
		
		return rootNode;
	}
	
	/*
	 *				1
	 * 		5				2		
	 * 	7		6		4		3	
	 * 								9
	 */
	public static BinaryTreeNode createMirrorBinaryTree(){
		
		BinaryTreeNode rootNode = new BinaryTreeNode();
		rootNode.setData(1);
		
		BinaryTreeNode l1  = new BinaryTreeNode();
		l1.setData(5);
		BinaryTreeNode l2  = new BinaryTreeNode();
		l2.setData(7);
		BinaryTreeNode l3  = new BinaryTreeNode();
		l3.setData(6);
		
		BinaryTreeNode r1 = new BinaryTreeNode();
		r1.setData(2);
		BinaryTreeNode r2 = new BinaryTreeNode();
		r2.setData(4);
		BinaryTreeNode r3 = new BinaryTreeNode();
		r3.setData(3);
				
		rootNode.setLeftNode(l1);
		rootNode.setRightNode(r1);
		
		l1.setLeftNode(l2);
		l1.setRightNode(l3);
		
		r1.setLeftNode(r2);
		r1.setRightNode(r3);
		
		/*BinaryTreeNode r4 = new BinaryTreeNode();
		r4.setData(9);	
		r3.setRightNode(r4);*/
		
		return rootNode;
	}
	
	/*
	 *						1
	 * 			2						5		
	 * 	3				4			6		7	
	 * 		8
	 */
	public static BinaryTreeNode createCompleteBinaryTree(){
		
		BinaryTreeNode rootNode = createFullBinaryTree();
		BinaryTreeNode node = rootNode;
		BinaryTreeNode l4 = new BinaryTreeNode();
		l4.setData(8);
		BinaryTreeNode prev = null;
		while(node != null){
			prev = node;
			node = node.getLeftNode();
		}
		prev.setRightNode(l4);	
		
		return rootNode;
	}
		
	/*
	 * 			2
	 * 3				4
	 * 		8
	 */
	public static BinaryTreeNode createSubTree(){
		
		BinaryTreeNode rootNode = new BinaryTreeNode();
		rootNode.setData(2);
		
		BinaryTreeNode l  = new BinaryTreeNode();
		l.setData(3);
		BinaryTreeNode r  = new BinaryTreeNode();
		r.setData(4);
		BinaryTreeNode lr = new BinaryTreeNode();
		lr.setData(8);
		
		rootNode.setLeftNode(l);
		rootNode.setRightNode(r);
		l.setRightNode(lr);
		
		return rootNode;
	}
	
	/*
	 *						1
	 * 			2						5		
	 * 	3				4			6		7	
	 * 		9
	 */
	public static BinaryTreeNode createAnotherCompleteBinaryTree(){
		
		BinaryTreeNode rootNode = createFullBinaryTree();
		BinaryTreeNode node = rootNode;
		BinaryTreeNode l4 = new BinaryTreeNode();
		l4.setData(9);
		BinaryTreeNode prev = null;
		while(node != null){
			prev = node;
			node = node.getLeftNode();
		}
		prev.setRightNode(l4);		
		return rootNode;
	}
}
