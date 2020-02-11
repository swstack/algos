//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//
//	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//	Example:
//
//	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//	Output: 7 -> 0 -> 8
//	Explanation: 342 + 465 = 807.

package leetcode;

import java.math.BigInteger;
import java.util.*;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	ListNode(int x, ListNode next) {
		val = x;
		this.next = next;
	}

	public static ListNode fromArray(int[] nums) {
		ListNode root = new ListNode(nums[0]);
		ListNode next = root;
		for (int i = 1; i < nums.length; i++) {
			next.next = new ListNode(nums[i]);
			next = next.next;
		}
		return root;
	}
}

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		// Reverse list 1
		Stack<ListNode> stack1 = new Stack<>();
		ListNode next1 = l1;
		while (next1 != null) {
			stack1.push(next1);
			next1 = next1.next;
		}

		// Build int for list 1
		BigInteger sum1 = new BigInteger("0");
		int i = stack1.size() - 1;
		while (!stack1.empty()) {
			BigInteger digit = new BigInteger(String.format("%s", stack1.pop().val));
			sum1 = sum1.add(digit.multiply(new BigInteger("10").pow(i)));
			i--;
		}

		// Reverse list 2
		Stack<ListNode> stack2 = new Stack<>();
		ListNode next2 = l2;
		while (next2 != null) {
			stack2.push(next2);
			next2 = next2.next;
		}

		// Build int for list 2
		BigInteger sum2 = new BigInteger("0");
		int i2 = stack2.size() - 1;
		while (!stack2.empty()) {
			BigInteger digit = new BigInteger(String.format("%s", stack2.pop().val));
			sum2 = sum2.add(digit.multiply(new BigInteger("10").pow(i2)));
			i2--;
		}

		// Sum of int 1 and 2 and add each digit to a queue for reversal
		BigInteger total = sum1.add(sum2);
		Queue<ListNode> queue = new LinkedList<>();
		while (total.compareTo(new BigInteger("0")) > 0) {
			BigInteger nextNum = total.mod(new BigInteger("10"));
			queue.add(new ListNode(nextNum.intValue()));
			total = total.divide(new BigInteger(("10")));
		}

		if (queue.isEmpty()) {
			return new ListNode(0);
		} else {
			ListNode root = queue.remove();
			ListNode node = root;
			while (node != null) {
				ListNode next;
				try {
					next = queue.remove();
				} catch (NoSuchElementException _e) {
					next = null;
				}
				node.next = next;
				node = next;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		ListNode y = ListNode.fromArray(new int[]{9});
		ListNode y1 = ListNode.fromArray(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9});

		ListNode result = new AddTwoNumbers().addTwoNumbers(y, y1);
		ListNode next = result;
		while (next != null) {
			System.out.print(String.format("%d ->", next.val));
			next = next.next;
		}
		System.out.println("");

		ListNode eightone = new ListNode(1);
		eightone.next = new ListNode(8);
		ListNode zero = new ListNode(0);
		ListNode zero2 = new ListNode(0);
		ListNode result2 = new AddTwoNumbers().addTwoNumbers(eightone, zero2);
		ListNode next2 = result2;
		while (next2 != null) {
			System.out.print(String.format("%d ->", next2.val));
			next2 = next2.next;
		}
	}
}
