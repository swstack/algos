package hashed;

/* For this example we are assuming (Key, Value) pairs where:
 *   - all keys are integers greater than 0
 * */

class HashNode {
	private HashNode next;
	private int key;
	private String value;
	
	public HashNode(int key, String value) {
		this.next = null;
		this.key = key;
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void setNext(HashNode next) {
		this.next = next;
	}

	public HashNode getNext() {
		return this.next;
	}

	public int getKey() {
		return this.key;
	}
}

class MyHashMap {
	private HashNode [] primaryStorage = new HashNode[100];

	private int hashKey(int key) {
		return key % primaryStorage.length;
	}

	public void insert(int key, String value) {
		/* Basic insert function using a division hash, averages O(1) time */
		int hashed = this.hashKey(key);

		// make a shallow copy of the node at this hashed  index for
		// reusability in this algorithm
		HashNode bucket = this.primaryStorage[hashed];
		HashNode newNode = new HashNode(key, value);
		
		// if the node is empty, just copy it to that slot 
		if (bucket == null) {
			primaryStorage[hashed] = newNode;
		}
	
		// if the node is not empty, we need to follow the basic algorithm:
		//  - check to see if there is a next node
		//  - if there is not, put this node as the next node
		//  - if there is, go to the next node and repeat the procedure
		else {
			while (bucket.getNext() != null) {
				bucket = bucket.getNext();
			}
			// we found the end node for this bucket
			bucket.setNext(newNode);
		}
	}

	public String fetch(int key) {
		/* Basic algorithm:
		 *  - Hash the key
		 *  - Iterate through nodes in the bucket and compare keys
		 *  - Return the Node's value
		 *  - Return null if not found
		 */
		int hashed = hashKey(key);
		HashNode node = this.primaryStorage[hashed];
		if (node == null) {
			// do nothing here we will return null at end
		} else {
			do {
				int nodeKey = node.getKey();
				if (nodeKey == key) {
					return node.getValue();
				} else {
					node = node.getNext();
				}
					
			} while (node != null);
		}

		// if the entire search failed, return null
		return null;
	}
	
	public static void main(String[] args) {
		MyHashMap mhp = new MyHashMap();
		mhp.insert(5, "hey");
		mhp.insert(445, "how are you");
		mhp.insert(15, "quite well");
		mhp.insert(0, "thank you");
		mhp.insert(2435, "very much!");
		mhp.insert(645, "Lets");
		mhp.insert(745, "try some");
		mhp.insert(845, "collisions!");
		System.out.println(mhp.fetch(5));
		System.out.println(mhp.fetch(445));
		System.out.println(mhp.fetch(645));
		System.out.println(mhp.fetch(745));
		System.out.println(mhp.fetch(845));
		System.out.println(mhp.fetch(1234)); // expecting null
	}
}
