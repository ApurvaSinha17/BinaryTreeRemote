package createBinaryTree;

/**
 * @author Apurva Kumar Sinha
 * Binary tree node having a char value
 *
 */
public final class BinaryTreeCharNode {

	private final char data;
	private BinaryTreeCharNode leftNode;
	private BinaryTreeCharNode rightNode;

	/**
	 * @param char data
	 */
	public BinaryTreeCharNode(char data){
		this.data = data;
	}
	
	/**
	 * @return char data
	 */
	public char getData() {
		return data;
	}
	
	/**
	 * @return leftNode
	 */
	public BinaryTreeCharNode getLeftNode() {
		return leftNode;
	}
	/**
	 * @param leftNode
	 */
	public void setLeftNode(BinaryTreeCharNode leftNode) {
		this.leftNode = leftNode;
	}
	/**
	 * @return rightNode
	 */
	public BinaryTreeCharNode getRightNode() {
		return rightNode;
	}
	/**
	 * @param rightNode
	 */
	public void setRightNode(BinaryTreeCharNode rightNode) {
		this.rightNode = rightNode;
	}
	
}
