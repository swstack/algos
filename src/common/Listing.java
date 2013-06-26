package common;

public class Listing {
	private String name;
	private String address;
	private String number;
	
	public Listing (String n, String a, String num) {
		name = n;
		address = a;
		number = num;
	}
	
	public String toString() {
		return ("Name is " + name + "\n" +
				"Address is " + address + "\n" +
				"Number is " + number + "\n");
	}
	
	public Listing deepCopy() {
		Listing clone = new Listing(name, address, number);
		return clone;
	}
	
	public int compareTo(String targetKey) {
		/* Return 0 if match, else 1 */
		return (name.compareTo(targetKey));
	}
	
	public void setAddress(String a) {
		address = a;
	}
	
	public String getKey() {
		return name;
	}
	
	public static void main(String[] args) {
		Listing a = new Listing("test", "123", "456");
		System.out.println(a.compareTo("est"));
	}
}