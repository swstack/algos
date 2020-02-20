package leetcode;

import java.util.Stack;

public class RemoveNthNode {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;

		if (head.next == null && n == 1)
			return null;

		ListNode next = head;

		Stack<ListNode> stack = new Stack<>();
		while (next != null) {
			stack.push(next);
			next = next.next;
		}

		if (n > stack.size())
			return head;

		ListNode toBeRemoved = null;
		ListNode previous = null;
		for (int i = n; i > 0; i--) {
			if (!stack.isEmpty()) {
				toBeRemoved = stack.pop();
			}

			if (!stack.isEmpty()) {
				previous = stack.peek();
			} else {
				previous = null;
			}
		}

		if (previous == null) {
			head = toBeRemoved.next;
		}

		if (previous != null && toBeRemoved != null)
			previous.next = toBeRemoved.next;

		System.out.println(head);
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		new RemoveNthNode().removeNthFromEnd(head, 2);
	}
}
