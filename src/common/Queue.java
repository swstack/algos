package common;

/*
Queue implementation using doubly linked list.
*/
public class Queue<T> {
	QueueNode first;  // First in the queue (to be removed)
	QueueNode last;  // Last in the queue (To be removed)

	class QueueNode {
		T value;
		QueueNode next;
		QueueNode previous;

		QueueNode(T value) {
			this.value = value;
			this.next = null;
			this.previous = null;
		}
	}

	boolean isEmpty() {
		return first == null;
	}

	void add(T value) {
		// Add to the beginning of the queue
		QueueNode newNode = new QueueNode(value);

		if (first == null && last == null) {
			last = newNode;
			first = last;
		} else {
			last.previous = newNode;
			newNode.next = last;
			last = newNode;
		}
	}

	T remove() throws Exception {
		// Remove from the end of the queue
		if (first == null) {
			throw new Exception("Empty queue");
		}

		QueueNode node = first;
		if (first.previous == null) {
			first = null;
		} else {
			first = first.previous;
			first.next = null;
		}
		return node.value;
	}

	void print() {
		QueueNode n = last;
		while (n != null) {
			String next = n.next == null ? "null" : String.format("%s", n.next.value);
			String previous = n.previous == null ? "null" : String.format("%s", n.previous.value);
			System.out.println(String.format("%s <- %s -> %s", previous, n.value, next));
			n = n.next;
		}
	}

	public static void main(String[] args) throws Exception {
		Queue<Integer> queue = new Queue<>();
		queue.add(1);
		queue.add(23);
		queue.add(12);
		queue.add(14);
		queue.add(15);
		queue.add(6);
		queue.print();

		System.out.println(String.format("Remove: %s", queue.remove()));
		System.out.println(String.format("Remove: %s", queue.remove()));
		System.out.println(String.format("Remove: %s", queue.remove()));
		System.out.println(String.format("Remove: %s", queue.remove()));
		System.out.println(String.format("Remove: %s", queue.remove()));
		System.out.println(String.format("Remove: %s", queue.remove()));
	}
}
