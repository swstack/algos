package common;

public class QueueSingly<T> {
	QueueNode first;  // First in the queue (to be removed)
	QueueNode last;  // Last in the queue (To be removed)

	class QueueNode {
		T value;

		// Next points "backwards" towards last
		QueueNode next;

		QueueNode(T value) {
			this.value = value;
			this.next = null;
		}
	}

	boolean isEmpty() {
		return first == null;
	}

	void add(T value) {
		// Add to the beginning of the queue
		QueueNode newNode = new QueueNode(value);

		if (first == null) {
			first = newNode;
		}

		if (last != null) {
			last.next = newNode;
		}

		last = newNode;
	}

	T remove() throws Exception {
		// Remove from the end of the queue
		if (first == null) {
			throw new Exception("Empty queue");
		}

		QueueNode node = first;
		if (first.next == null) {
			first = null;
		} else {
			first = first.next;
		}
		return node.value;
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		QueueNode n = first;
		while (n != null) {
			out.append(String.format(" <- %s", n.value));
			n = n.next;
		}
		return out.toString();
	}

	void print() {
		System.out.println(this.toString());
	}

	public static void main(String[] args) throws Exception {
		QueueSingly<Integer> queue = new QueueSingly<>();
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

