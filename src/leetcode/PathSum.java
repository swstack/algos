package leetcode;

public class PathSum {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSumRecursive(TreeNode next, int target, int total) {
		if (next == null) {
			return false;
		}

		total += next.val;

		if (next.left == null && next.right == null && target == total) {
			return true;
		}

		if (next.left != null) {
			boolean existsLeft = hasPathSumRecursive(next.left, target, total);
			if (existsLeft) {
				return existsLeft;
			}
		}

		if (next.right != null) {
			boolean existsRight = hasPathSumRecursive(next.right, target, total);
			if (existsRight) {
				return existsRight;
			}
		}

		return false;
	}


	public boolean hasPathSum(TreeNode root, int sum) {
		// DFS traversal checking sum along the way
		return hasPathSumRecursive(root, sum, 0);
	}

	public static void main(String[] args) {
		TreeNode five = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode eight = new TreeNode(8);
		TreeNode eleven = new TreeNode(11);
		TreeNode thirteen = new TreeNode(13);
		TreeNode four2 = new TreeNode(4);
		TreeNode seven = new TreeNode(7);
		TreeNode two = new TreeNode(2);
		TreeNode one = new TreeNode(1);

		five.left = four;
		five.right = eight;

		four.left = eleven;

		eight.left = thirteen;
		eight.right = four2;

		eleven.left = seven;
		eleven.right = two;

		four2.right = one;

		boolean res = new PathSum().hasPathSum(five, 22);
		System.out.println(res);
	}
}
