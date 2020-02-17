package graphs;

import common.Listing;

public class BinarySearchTree {
	TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public boolean insert(Listing newListing) {
		TreeNodeWrapper p = new TreeNodeWrapper();
		TreeNodeWrapper c = new TreeNodeWrapper();
		TreeNode n = new TreeNode();

		if (n == null)
			return false;

		n.node = newListing.deepCopy();
		n.lc = null;
		n.rc = null;
		if (root == null) {
			// tree is empty, set as root node
			root = n;
		} else {
			findNode(newListing.getKey(), p, c);  // find nodes parent
			if (newListing.getKey().compareTo(p.get().node.getKey()) < 0)
				p.get().lc = n;
			else
				p.get().rc = n;
		}
		return true;
	}

	public Listing fetch(String targetKey) {
		boolean found;
		TreeNodeWrapper p = new TreeNodeWrapper();
		TreeNodeWrapper c = new TreeNodeWrapper();
		found = findNode(targetKey, p, c);
		if (found == true)
			return c.get().node.deepCopy();
		else
			return null;
	}

	private boolean findNode(String targetKey,
	                         TreeNodeWrapper parent,
	                         TreeNodeWrapper child) {
		/* Return true if found else false, however the real job of this method
		 * is to mutate parent and child by setting them with valid node locations
		 * defined as:
		 *
		 * 	``child`` - The location of the `targetKey` node
		 *  ``parent`` - `child` parent node
		 *
		 *  */
		parent.set(root);
		child.set(root);

		if (root == null) {
			return true;
		}
		while (child.get() != null) {
			if (child.get().node.compareTo(targetKey) == 0) {
				return true;
			} else {
				parent.set(child.get());
				if (targetKey.compareTo(child.get().node.getKey()) < 0)
					/* targetKey is longer */
					child.set(child.get().lc);
				else
					/* targetKey is shorter */
					child.set(child.get().rc);
			}
		}
		return false;
	}

	class TreeNode {
		private Listing node;
		private TreeNode lc;
		private TreeNode rc;

		public TreeNode() {
		}
	}

	class TreeNodeWrapper {
		TreeNode treeRef = null;

		public TreeNodeWrapper() {
		}

		public TreeNode get() {
			return treeRef;
		}

		public void set(TreeNode t) {
			treeRef = t;
		}
	}

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
