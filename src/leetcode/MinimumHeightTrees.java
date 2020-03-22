package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {
	public static HashMap<Integer, List<Integer>> toAdjacencyList(int[][] edges) {
		// Undirected adjacency list where each key in the map is a node value and
		// the value is a list of adjacent nodes. The fact that it is undirected means
		// each edge generates an adjacent node for both nodes.

		HashMap<Integer, List<Integer>> adj = new HashMap<>();
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			List<Integer> listFrom = adj.getOrDefault(from, new LinkedList<>());
			listFrom.add(to);
			adj.put(from, listFrom);

			List<Integer> listTo = adj.getOrDefault(to, new LinkedList<>());
			listTo.add(from);
			adj.put(to, listTo);
		}
		return adj;
	}

	public static List<List<Integer>> _allPaths(int root, HashMap<Integer, List<Integer>> adj, List<Integer> visited) {
		List<List<Integer>> paths = new LinkedList<>();
		visited.add(root);
		List<Integer> children = adj.get(root);

		// Find the leaf nodes in an undirected graph, this means there are no children or
		// the only remaining children are already visited.
		if (children == null || children.size() == 0 || visited.containsAll(children)) {
			List<Integer> path = new LinkedList<>();
			path.add(root);
			paths.add(path);
			return paths;
		}

		for (int child : children) {
			if (!visited.contains(child)) {
				for (List<Integer> childPath : _allPaths(child, adj, visited)) {
					childPath.add(0, root);
					paths.add(childPath);
				}
			}
		}

		return paths;
	}

	public static List<List<Integer>> allPaths(int root, int[][] edges) {
		// Edges are represented as a list of edges

		List<Integer> visited = new LinkedList<>();
		return _allPaths(root, toAdjacencyList(edges), visited);
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		// Brute force:
		//  - Find every path for every potential root node using DFS and "completing" a path
		//    once it hits a leaf node, i.e. no unvisited children.
		//  - Find the root node(s) with the shortest longest path.

		if (n == 1) {
			List<Integer> list = new LinkedList<>();
			list.add(0);
			return list;
		}

		// Key is the potential root node value, values are list of paths
		HashMap<Integer, List<Integer>> longestPathRootMap = new HashMap<>();
		for (int root = 0; root <= n - 1; root++) {
			List<List<Integer>> rootPaths = allPaths(root, edges);
			System.out.println(String.format("%d : %s", root, rootPaths));
			int longestPath = 0;
			for (List<Integer> path : rootPaths) {
				if (path.size() > longestPath) {
					longestPath = path.size();
				}
			}

			List<Integer> roots = longestPathRootMap.getOrDefault(longestPath, new LinkedList<>());
			roots.add(root);
			longestPathRootMap.put(longestPath, roots);
		}

		Set<Integer> keys = longestPathRootMap.keySet();
		int minKey = Integer.MAX_VALUE;
		for (int key : keys) {
			if (key < minKey) {
				minKey = key;
			}
		}

		return longestPathRootMap.getOrDefault(minKey, new LinkedList<>());
	}

	public static void main(String[] args) {
		int[][] edges = new int[][]{
			new int[]{1, 0},
			new int[]{1, 2},
			new int[]{1, 3},
		};

		List<List<Integer>> allPaths1 = allPaths(1, edges);
		System.out.println(allPaths1);
		List<List<Integer>> allPaths2 = allPaths(2, edges);
		System.out.println(allPaths2);

		List<Integer> mins = new MinimumHeightTrees().findMinHeightTrees(4, edges);
		System.out.println(mins);

		int[][] edges2 = new int[][]{
			new int[]{1, 0},
		};
		List<Integer> mins2 = new MinimumHeightTrees().findMinHeightTrees(2, edges2);
		System.out.println(mins2);

	}
}
