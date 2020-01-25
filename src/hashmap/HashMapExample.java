package hashmap;
import java.util.HashMap;

class HashMapExample {
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put(1, 2);
		hm.put("hey", 3);
		System.out.println(hm.get(1));
		System.out.println(hm.get("hey"));
		System.out.println(hm.get(3));
	}
}