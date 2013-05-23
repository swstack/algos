package hashed;

/* For this example we are assuming (Key, Value) pairs where:
 *   - all values are integers
 *   - minimum key is non-zero and that value is 5
 * */

class MyHashMap {
	private int minKey = 5;
	private int [] primaryStorage = new int [100];

	private int preProcessKey(int key) {
		return (key - (minKey));
	}
	
	public void insert(int key, int value) {
		if (key < this.minKey) {
			System.out.println("Bad Key");
		} else {
			// preprocess the key to handle negative indexs, which we wont have
			// because our min is 5, oh well
			int pk = this.preProcessKey(key);

			// do our hash computation, but we are using direct hashing so we
			// already have the index, oh well
			int index = pk;

			// deep copy it into storage
			this.primaryStorage[index] = value;
		} 
		
	}

	public int fetch(int key) {
		int pk = this.preProcessKey(key);
		int index = pk;  // just doing this for verbosity
		return primaryStorage[key];
	}
	
	public static void main(String[] args) {
		MyHashMap mhp = new MyHashMap();
		mhp.insert(5, 1);
		System.out.println(mhp.fetch(99));
	}
}
