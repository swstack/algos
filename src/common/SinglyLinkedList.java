package common;

public class SinglyLinkedList<T extends Comparable<T>> {

	Node<T> tail = null;  // The first node inserted
	Node<T> head = null;  // The last node inserted

	public Node<T> insert(T value) {
		// Insertion time is O(1)

		Node<T> newNode = new Node<>(value, null);
		if (tail == null && head == null) {
			tail = newNode;
			head = tail;
		} else {
			Node<T> previousHead = head;
			head = newNode;
			previousHead.next = head;
		}
		return newNode;
	}

	public void insertOrdered(T value) {
		// Insertion time is O(n)

		if (tail == null && head == null) {
			insert(value);
		} else {
			Node<T> next = tail;
			Node<T> newNode = new Node<>(value, null);
			Node<T> previous = null;

			while (next != null && next.isLessThan(newNode)) {
				previous = next;
				next = next.next;
			}

			if (previous == null) {
				// newNode is the new tail
				tail = newNode;
			} else {
				previous.next = newNode;
			}

			newNode.next = next;
		}
	}

	public SinglyLinkedList<T> order() {
		// Order is O(n2)

		SinglyLinkedList<T> newList = new SinglyLinkedList<>();
		Node<T> n = this.tail;
		while (n != null) {
			newList.insertOrdered(n.value);
			n = n.next;
		}
		return newList;
	}

	public void print() {
		System.out.println(this.toString());
	}

	public String toString() {
		Node<T> n = tail;
		StringBuilder out = new StringBuilder();
		while (n != null) {
			if (n.next == null) {
				out.append(String.format("%s", n.value));
			} else {
				out.append(String.format("%s -> ", n.value));
			}
			n = n.next;
		}
		return out.toString();
	}

	public static void main(String[] args) {
		// Test node
		Node<Integer> n1 = new Node<>(5, null);
		Node<Integer> n2 = new Node<>(5, null);
		Node<Integer> n3 = new Node<>(10, null);
		System.out.println(String.format("%s is less than %s: %s", n1.value, n2.value, n1.isLessThan(n2)));
		System.out.println(String.format("%s is less than %s: %s", n2.value, n1.value, n2.isLessThan(n1)));
		System.out.println(String.format("%s is less than %s: %s", n3.value, n2.value, n3.isLessThan(n2)));
		System.out.println(String.format("%s is less than %s: %s", n1.value, n3.value, n1.isLessThan(n3)));
		System.out.println(String.format("%s is greater than %s: %s", n1.value, n2.value, n1.isGreaterThan(n2)));
		System.out.println(String.format("%s is greater than %s: %s", n2.value, n1.value, n2.isGreaterThan(n1)));
		System.out.println(String.format("%s is greater than %s: %s", n3.value, n2.value, n3.isGreaterThan(n2)));
		System.out.println(String.format("%s is greater than %s: %s", n1.value, n3.value, n1.isGreaterThan(n3)));

		// Test unordered insert
		SinglyLinkedList<Integer> unorderedList = new SinglyLinkedList<>();
		unorderedList.insert(3);
		unorderedList.insert(11);
		unorderedList.insert(6);
		unorderedList.insert(22);
		unorderedList.insert(100);
		unorderedList.print();

		// Test ordered insert
		SinglyLinkedList<Integer> orderedList = new SinglyLinkedList<>();
		orderedList.insertOrdered(4);
		orderedList.insertOrdered(2);
		orderedList.insertOrdered(10);
		orderedList.insertOrdered(6);
		orderedList.print();

		// Order unsorted linked list
		unorderedList.order().print();
	}
}
