package common;

public class Node<T extends Comparable<T>> {
	public T value;
	public Node<T> next;

	// Only used for HashMap example
	public Object key;

	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	public boolean isLessThan(Node<T> other) {
		return this.value.compareTo(other.value) < 0;
	}

	public boolean isGreaterThan(Node<T> other) {
		return this.value.compareTo(other.value) > 0;
	}
}
