package trees;
import common.Listing;


public class Run {

	public static void main(String[] args) {
		BinarySearchTree storage = new BinarySearchTree();

		Listing a = new Listing("steve", "1.2", "5");
		Listing b = new Listing("pher", "4.2", "3");
		Listing c = new Listing("luke", "2.1", "1");
		Listing d = new Listing("gilmore", "3.4", "6");
		Listing e = new Listing("vadim", "5.1", "7");
		Listing f = new Listing("phil", "6.6", "8");
		Listing g = new Listing("spud", "7.7", "9");

		storage.insert(e);
		storage.insert(d);
		storage.insert(a);
		
		System.out.print(storage.fetch("vadim"));
	}
}
