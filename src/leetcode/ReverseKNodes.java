package leetcode;

import java.util.Stack;

public class ReverseKNodes {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public void print() {
			ListNode n = this;
			while (n != null) {
				System.out.print(String.format("%d -> ", n.val));
				n = n.next;
			}
			System.out.println("");
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		Stack<ListNode> stack = new Stack<>();
		ListNode result = head;
		ListNode next = head;
		ListNode lastReversedTail = null;
		while (next != null) {
			if (stack.size() < k) {
				stack.push(next);

			}

			next = next.next;

			if (stack.size() == k) {
				ListNode reversedHead = stack.pop();
				ListNode reversedTail = reversedHead;
				ListNode reversedNext = reversedHead;
				while (!stack.isEmpty()) {
					reversedNext.next = stack.pop();
					reversedNext = reversedNext.next;
					reversedTail = reversedNext;
				}

				if (lastReversedTail != null) {
					lastReversedTail.next = reversedHead;
				} else {
					result = reversedHead;
				}

				lastReversedTail = reversedTail;
				reversedTail.next = next;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
//		ListNode three = new ListNode(3);
//		ListNode four = new ListNode(4);
//		ListNode five = new ListNode(5);
		one.next = two;
//		two.next = three;
//		three.next = four;
//		four.next = five;
		ListNode result = new ReverseKNodes().reverseKGroup(one, 2);
		result.print();
	}
}
