package common;

import java.util.Random;

public class HashMap<K extends Comparable<K>, V extends Comparable<V>> {
	ResizableArray<SinglyLinkedList<V>> data = new ResizableArray<>();

	void put(K key, V value) throws Exception {
		// Insert O(1)

		int hash = this.computeHash(key);
		int index = hash % data.size();
		SinglyLinkedList<V> list = data.get(index);
		if (list == null) {
			list = new SinglyLinkedList<>();
			data.insert(index, list);
		}
		Node<V> n = list.insert(value);
		n.key = key;
	}

	V get(K key) throws Exception {
		// Compute hash O(1)
		int hash = this.computeHash(key);
		int index = hash % data.size();

		// Array lookup O(1)
		SinglyLinkedList<V> list = data.get(index);
		if (list == null) {
			return null;
		}

		// Linked list lookup O(x) where x should be a small number assuming hash func has few collisions
		Node<V> n = list.tail;
		while (n != null && n.key != key) {
			n = n.next;
		}
		if (n != null) {
			return n.value;
		} else {
			return null;
		}
	}

	public void print() {
		for (int i = 0; i < data.size(); i++) {
			String val = data.get(i) != null ? data.get(i).toString() : "null";
			System.out.println(String.format("%d: %s", i, val));
		}
	}

	int computeHash(K key) throws Exception {
		if (key instanceof Integer) {
			// Simplest possible integer hash function, mod by array size

			Integer keyInt = (Integer) key;
			return keyInt % data.size();
		}

		if (key instanceof String) {
			// Simplest possible string hash function, assign each character a number and sum

			String keyStr = (String) key;
			int hashVal = 0;
			for (int i = 0; i < keyStr.length(); i++) {
				hashVal += Character.getNumericValue(keyStr.charAt(i));
			}
			return hashVal;
		}

		throw new Exception("Unsupported type");
	}

	public static void main(String[] args) throws Exception {
		HashMap<String, String> strMap = new HashMap<>();

		strMap.put("one", "two");
		strMap.put("three", "four");
		strMap.put("five", "six");
		strMap.put("seven", "eight");
		strMap.put("nine", "ten");
		strMap.put("eleven", "twelve");
		strMap.print();

		System.out.println(String.format("(k:v) one:%s", strMap.get("one")));
		System.out.println(String.format("(k:v) three:%s", strMap.get("three")));
		System.out.println(String.format("(k:v) one hundred:%s", strMap.get("one hundred")));

		HashMap<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 2);
		intMap.put(3, 4);
		intMap.put(5, 6);
		intMap.put(7, 8);
		intMap.put(9, 10);
		intMap.put(11, 12);
		intMap.print();

		System.out.println(String.format("(k:v) 1:%s", intMap.get(1)));
		System.out.println(String.format("(k:v) 3:%s", intMap.get(3)));
		System.out.println(String.format("(k:v) 100:%s", intMap.get(100)));
	}
}
