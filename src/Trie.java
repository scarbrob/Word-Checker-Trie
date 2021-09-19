import java.io.Serializable;

/**
 * This class is a Trie object used to store a very large set of strings with ultrafast, constant-time access.
 * 
 * @author Ben Scarbrough
 * @Version 1.0
 *
 */
class Trie implements Serializable {
	private static final long serialVersionUID = 180125381233920584L; // The serialVersionUID Number.
	private Node root; // The root of the trie.
	private int size; // The size of the trie.

	/*
	 * A private nested node class that is used as a helper for Trie.
	 */
	private class Node implements Serializable {
		private static final long serialVersionUID = 8991495718149187003L; // The serialVersionUID Number.
		Node[] array; // an array that holds the data for the current node.
		boolean end; // A variable to check if the Node is the end.

		/**
		 * A private constructor for Node that gives the array 26 spots.
		 */
		private Node() {
			this.array = new Node[26];
			end = false;
		}
	}

	/**
	 * A constructor for the TRIE class that sets the root equal to a new node and the size to zero.
	 */
	public Trie() {
		root = new Node();
		size = 0;
	}

	/**
	 * A method which inserts a new word into the Trie.
	 * @param word The word to be inserted into the Trie.
	 */
	public void insert(String word) {
		size++;
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int index = letter - 'a';
			if (current.array[index] == null) {
				Node temp = new Node();
				current.array[index] = temp;
				current = temp;
			} else {
				current = current.array[index];
			}
		}
		current.end = true;
	}

	/**
	 * A method which returns true if the given value is present in the Trie or false if it is not.
	 * @param word The word to search the Trie for.
	 * @return True or False.
	 */
	public boolean has(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int index = letter - 'a';
			if (current.array[index] != null) {
				current = current.array[index];
			}
		}
		return (current != null && current.end);
	}

	/**
	 * A method which returns the size, or number of words inside the Trie.
	 * @return The size.
	 */
	public int getSize() {
		return size;
	}
}
