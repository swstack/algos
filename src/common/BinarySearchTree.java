package common;

public class BinarySearchTree {
	TreeNode root = null;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public BinarySearchTree addUnbalanced(int val) {
		TreeNode node = new TreeNode(val);

		if (root == null) {
			root = node;
			return this;
		}

		TreeNode next = root;
		while (next != null) {
			if (val < next.val) {
				if (next.left == null) {
					next.left = node;
					next = null;
				} else {
					next = next.left;
				}
			} else {
				if (next.right == null) {
					next.right = node;
					next = null;
				} else {
					next = next.right;
				}
			}
		}
		return this;
	}

	public BinarySearchTree addBalanced(int val) {
		// TODO
		return this;
	}

	void printRecursive(TreeNode node, int currentDepth) {
		// Reverse in-order traversal of the tree printing it on it's side

		if (node != null) {
			printRecursive(node.right, currentDepth + 1);
			StringBuilder spaces = new StringBuilder();
			while (spaces.length() < currentDepth * 10) {
				spaces.append(" ");
			}
			System.out.println(String.format("%s%d", spaces.toString(), node.val));
			printRecursive(node.left, currentDepth + 1);
		}
	}

	void print() {
		printRecursive(root, 0);
	}

	public static void main(String[] args) {
//		BinarySearchTree bst2 = new BinarySearchTree();
//		bst2.addUnbalanced(4)
//		    .addUnbalanced(2)
//		    .addUnbalanced(23)
//		    .addUnbalanced(3)
//		    .addUnbalanced(11)
//		    .addUnbalanced(12)
//		    .addUnbalanced(1)
//		    .addUnbalanced(8)
//		    .print();

		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.addUnbalanced(4)
		    .addUnbalanced(2)
		    .addUnbalanced(23)
		    .addUnbalanced(3)
		    .addUnbalanced(11)
		    .addUnbalanced(12)
		    .addUnbalanced(1)
		    .addUnbalanced(8)
		    .print();
	}
}
