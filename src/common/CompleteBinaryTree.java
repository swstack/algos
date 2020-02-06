package common;

public class CompleteBinaryTree<T> {

	TreeNode root;

	class TreeNode {
		T value;
		TreeNode leftChild;
		TreeNode rightChild;

		TreeNode(T value) {
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	CompleteBinaryTree() {
		root = null;
	}

	void add(T value) throws Exception {
		// Add to the tree ensuring it remains a complete binary tree

		TreeNode node = new TreeNode(value);

		if (root == null) {
			root = node;
		} else {
			QueueSingly<TreeNode> queue = new QueueSingly<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode next = queue.remove();

				if (next.leftChild == null) {
					next.leftChild = node;
					break;
				} else {
					queue.add(next.leftChild);
				}

				if (next.rightChild == null) {
					next.rightChild = node;
					break;
				} else {
					queue.add(next.rightChild);
				}
			}
		}
	}

	void printRecursive(TreeNode node, int currentDepth) {
		// Reverse in-order traversal of the tree printing it on it's side

		if (node != null) {
			printRecursive(node.rightChild, currentDepth + 1);
			StringBuilder spaces = new StringBuilder();
			while (spaces.length() < currentDepth * 10) {
				spaces.append(" ");
			}
			System.out.println(String.format("%s%s", spaces.toString(), node.value));
			printRecursive(node.leftChild, currentDepth + 1);
		}
	}

	void print() {
		printRecursive(root, 0);
	}

	public static void main(String[] args) throws Exception {
		CompleteBinaryTree<Integer> tree = new CompleteBinaryTree<>();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		tree.add(6);
		tree.add(7);
		tree.add(8);
		tree.add(9);
		tree.add(10);
		tree.print();
	}
}
