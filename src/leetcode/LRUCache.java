package leetcode;

public class LRUCache {
	int capacity;
	CacheItem head;

	static class CacheItem {
		int key;
		int value;
		CacheItem next;

		CacheItem(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.head = null;
	}

	public int get(int key) {
		// O(n) get, linear scan of list, if found move element to head
		// trim parameter is used by Put, to trim the tail off if the cache is at capacity

		int result = -1;
		// We need previous node to move the key-node to the front, also to remove the tail
		CacheItem prev = null;
		CacheItem next = this.head;
		while (next != null) {
			if (next.key == key) {
				if (prev != null) {
					prev.next = next.next;
				}

				if (head.value != next.value) {
					// Guard against infinite loop (head points to itself)
					next.next = head;
				}

				head = next;
				result = next.value;
				break;
			}
			prev = next;
			next = next.next;
		}

		System.out.println(String.format("Get: %d", result));
		return result;
	}

	public void put(int key, int value) {
		// O(n) put, scan list to find if value already exists,
		// if the key already exists, move to head and update value,
		// otherwise just create new item at head.

		// Use the get to move the item to the front of list if it exists
		if (get(key) == -1) {
			// Doesn't exist
			CacheItem item = new CacheItem(key, value);
			item.next = head;
			head = item;
		} else {
			// Exists
			head.value = value;
		}

		// Truncate the list past the capacity
		CacheItem current = this.head;
		int i = 1;
		while (current !=  null) {
			if (i == this.capacity) {
				current.next = null;
				break;
			}
			i++;
			current = current.next;
		}
	}

	public void print() {
		CacheItem next = this.head;
		while (next != null) {
			System.out.print(String.format("%d -> ", next.value));
			next = next.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.get(1); // -1
		cache.put(1, 1);
		cache.put(2, 2);
		cache.print();
		cache.get(1); // 1
		cache.get(2); // 2
		cache.get(3); // -1
		cache.put(3, 3);
		cache.print();
		cache.get(3); // 3
		cache.get(2); // -1
	}
}