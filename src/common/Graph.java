package common;

import java.util.*;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

class GraphNode<T> {
	T value;
	boolean visited;
	ArrayList<GraphNode<T>> children;

	GraphNode(T value) {
		this.value = value;
		children = new ArrayList<>();
		visited = false;
	}
}

class Edge<T> {
	T srcVal;
	T dstVal;
	int weight;

	Edge(T srcVal, T dstVal, int weight) {
		this.srcVal = srcVal;
		this.dstVal = dstVal;
		this.weight = weight;
	}
}

public class Graph<T> {

	ArrayList<Edge<T>> edges;
	HashMap<T, GraphNode<T>> nodes;
	boolean directed;

	Graph() {
		edges = new ArrayList<>();
		nodes = new HashMap<>();
		this.directed = true;
	}

	private void add(T srcVal, T dstVal, boolean undirected) {
		GraphNode<T> src = nodes.getOrDefault(srcVal, new GraphNode<>(srcVal));
		if (!nodes.containsKey(srcVal)) {
			nodes.put(srcVal, src);
		}

		GraphNode<T> dst = nodes.getOrDefault(dstVal, new GraphNode<>(dstVal));
		if (!nodes.containsKey(dstVal)) {
			nodes.put(dstVal, dst);
		}

		src.children.add(dst);
		if (undirected) {
			dst.children.add(src);
		}
	}

	void build(Edge<T>... edges) {
		for (Edge<T> edge : edges) {
			this.edges.add(edge);
			add(edge.srcVal, edge.dstVal, directed);
		}
	}

	void reset() {
		for (Map.Entry<T, GraphNode<T>> entry : nodes.entrySet()) {
			entry.getValue().visited = false;
		}
	}

	void visitBFS(T value) {
		Queue<GraphNode<T>> queue = new LinkedList<>();
		GraphNode<T> root = nodes.get(value);
		queue.add(root);
		System.out.print("Visiting: ");
		while (!queue.isEmpty()) {
			GraphNode<T> node = queue.remove();
			if (!node.visited) {
				System.out.print(String.format(" %s", node.value));
				node.visited = true;
			}

			for (GraphNode<T> child : node.children) {
				queue.add(child);
			}
		}
		System.out.println("");
	}

	void _visitDFSRecursive(GraphNode<T> node) {
		if (!node.visited) {
			System.out.print(String.format(" %s", node.value));
			node.visited = true;
		}

		for (GraphNode<T> child : node.children) {
			if (!child.visited) {
				_visitDFSRecursive(child);
			}
		}
	}

	void visitDFSRecursive(T value) {
		GraphNode<T> next = nodes.get(value);
		System.out.print("Visiting: ");
		_visitDFSRecursive(next);
		System.out.println("");
	}

	void visitDFS(T value) {
		// Iterative solution using a stack

		Stack<GraphNode<T>> stack = new Stack<>();

		GraphNode<T> next = nodes.get(value);
		stack.push(next);

		System.out.print("Visiting: ");
		while (next != null) {
			if (!next.visited) {
				System.out.print(String.format(" %s", next.value));
				next.visited = true;
			}

			GraphNode<T> nextChild = null;
			for (GraphNode<T> child : next.children) {
				if (!child.visited) {
					nextChild = child;
					break;
				}
			}

			if (nextChild != null) {
				next = nextChild;
				stack.push(next);
			} else {
				try {
					next = stack.pop();
				} catch (EmptyStackException _e) {
					next = null;
				}
			}
		}
		System.out.println("");
	}

	boolean routeBetween(T valA, T valB) {
		GraphNode<T> a = this.nodes.get(valA);


		GraphNode<T> b = this.nodes.get(valB);

		GraphNode<T> nextA = a;
		GraphNode<T> nextB = b;

		return true;
	}

	void print() {
		// Print the graph as an adjacency list

		for (Map.Entry<T, GraphNode<T>> entry : nodes.entrySet()) {
			System.out.print(String.format("%s", entry.getValue().value));
			for (GraphNode<T> child : entry.getValue().children) {
				System.out.print(String.format(" -> %s", child.value));
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<>();
		graph.build(
			new Edge<>(1, 5, 0),
			new Edge<>(1, 6, 0),
			new Edge<>(2, 1, 0),
			new Edge<>(2, 3, 0),
			new Edge<>(4, 5, 0),
			new Edge<>(4, 7, 0),
			new Edge<>(5, 2, 0),
			new Edge<>(5, 3, 0),
			new Edge<>(6, 4, 0),
			new Edge<>(7, 6, 0)
		);

		graph.print();
		graph.visitDFS(1);
		graph.reset();
		graph.visitDFSRecursive(1);
		graph.reset();
		graph.visitBFS(1);
	}
}
