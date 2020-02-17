package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphAllPaths {
	public void dfsAdjacencyList(int root, int[][] graph) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> visited = new LinkedList<>();

		int next = root;
		stack.push(next);
		while (next > -1) {

			// Visit current node
			if (!visited.contains(next)) {
				System.out.print(String.format("%d -> ", next));
				visited.add(next);
			}

			// Find the first unvisited child, add to the stack, and re-iterate
			int[] children = graph[next];
			for (int child : children) {
				if (!visited.contains(child)) {
					stack.push(next);
					next = child;
					break;
				}
			}

			// The loop above didnt' find any unvisited children, pop from the stack and work way up
			if (visited.contains(next)) {
				if (!stack.isEmpty()) {
					next = stack.pop();
				} else {
					// Nothing in the stack, must be the end
					next = -1;
				}
			}
		}
		System.out.println("");
	}

	public List<List<Integer>> allPathsRecursive(int root, int[][] graph) {
		List<List<Integer>> paths = new LinkedList<>();
		int[] children = graph[root];

		// Leaf node
		if (children.length == 0) {
			List<Integer> leafPath = new LinkedList<>();
			leafPath.add(root);
			paths.add(leafPath);
		}

		for (int child : children) {
			for (List<Integer> childPath : allPathsRecursive(child, graph)) {
				childPath.add(0, root);
				paths.add(childPath);
			}
		}

		System.out.println(paths);
		return paths;
	}

	public List<List<Integer>> allPathsIterative(int root, int[][] graph) {
		List<List<Integer>> paths = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		List<Integer> visited = new LinkedList<>();

		int next = root;
		while (next > -1) {

			// Visit current node
			if (!visited.contains(next)) {
				System.out.print(String.format("%d -> ", next));
				visited.add(next);
			}

			// Find the first unvisited child, add to the stack, and re-iterate
			for (int child : graph[next]) {
				if (!visited.contains(child)) {
					stack.push(next);
					next = child;
					break;
				}
			}

			// The loop above didn't find any unvisited children, pop from the stack and work way up.
			if (visited.contains(next)) {
				if (!stack.isEmpty()) {
					next = stack.pop();
				} else {
					// Nothing in the stack, must be the end
					next = -1;
				}
			}
		}

		return paths;
	}

	public List<List<Integer>> allPathsSourceTarget(int source, int target, int[][] graph) {
		List<List<Integer>> paths = new LinkedList<>();

		if (source == target) {
			List<Integer> path = new LinkedList<>();
			path.add(source);
			paths.add(path);
			return paths;
		}

		for (int child : graph[source]) {
			for (List<Integer> childPath : allPathsSourceTarget(child, target, graph)) {
				childPath.add(0, source);
				paths.add(childPath);
			}
		}
		System.out.println(paths);
		return paths;
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		int source = 0;
		int target = graph.length - 1;
		return allPathsSourceTarget(source, target, graph);
	}

	public static void main(String[] args) {
		int[][] graph1 = new int[][]{
			new int[]{1, 2, 7},
			new int[]{3, 4},
			new int[]{4, 5},
			new int[]{},
			new int[]{},
			new int[]{6},
			new int[]{},
			new int[]{}
		};

//		new GraphAllPaths().allPathsRecursive(0, graph1);
//		new GraphAllPaths().dfsAdjacencyList(0, graph1);
//		new GraphAllPaths().allPathsIterative(0, graph1);
//		new GraphAllPaths().allPathsSourceTarget(0, 4, graph1);

		int[][] graph2 = new int[][]{
			new int[]{1, 2},
			new int[]{3},
			new int[]{3},
			new int[]{}
		};

//		new GraphAllPaths().allPathsRecursive(0, graph2);
		new GraphAllPaths().allPathsSourceTarget(graph2);
	}
}
