package common;

public class Stack<T> {
	StackNode top;

	class StackNode {
		T value;
		StackNode next;

		StackNode(T value) {
			this.value = value;
			this.next = null;
		}
	}

	public void push(T value) {
		StackNode newNode = new StackNode(value);
		newNode.next = top;
		top = newNode;
	}

	public T peek() {
		return top.value;
	};

	public T pop() {
		T value = top.value;
		top = top.next;
		return value;
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append(String.format("(top)", top.value));
		StackNode n = top;
		while (n != null) {
			out.append(String.format(" %s ->", n.value));
			n = n.next;
		}
		return out.toString();
	}

	public void print() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.print();

		System.out.println(String.format("pop: %s", stack.pop()));
		System.out.println(String.format("pop: %s", stack.pop()));
		stack.print();
	}
}
