package common;

class Node {
	private Node next;
	private int key;
	private String value;

	public Node(int key, String value) {
		this.next = null;
		this.key = key;
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return this.next;
	}

	public int getKey() {
		return this.key;
	}
}