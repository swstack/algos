package leetcode;

public class MergeSortedLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// Create a new sorted list by traversing each list, picking the next smallest value node.

		if (l1 == null) {
			return l2;
		}
		if (l2 == null){
			return l1;
		}

		ListNode head = null;
		ListNode tail = null;
		ListNode next1 = l1;
		ListNode next2 = l2;
		while (next1 != null && next2 != null) {
			if (next1.val > next2.val) {
				if (head == null) {
					head = next2;
					tail = head;
				} else {
					tail.next = next2;
					tail = tail.next;
				}
				next2 = next2.next;
			} else {
				if (head == null) {
					head = next1;
					tail = head;
				} else {
					tail.next = next1;
					tail = tail.next;
				}
				next1 = next1.next;
			}
		}

		// Remaining l1
		while (next1 != null) {
			tail.next = next1;
			tail = tail.next;
			next1 = next1.next;
		}

		// Remaining l2
		while (next2 != null) {
			tail.next = next2;
			tail = tail.next;
			next2 = next2.next;
		}

		return head;
	}


	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);
		ListNode r = new MergeSortedLists().mergeTwoLists(l1, l2);

		ListNode next = r;
		while (next != null) {
			System.out.println(next.val);
			next = next.next;
		}
	}
}
