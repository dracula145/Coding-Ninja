package Assignment;
import java.util.*;

class TrieNode {
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}

public class PalindromePair {
   private TrieNode root;
	public int count;

	public PalindromePair() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}





	/*..................... Palindrome Pair................... */


	public boolean isPalindromePair(ArrayList<String> words) {
		for(String s : words){
            add(s);
            add(s.substring(1)); // to check words like ab, cba we need to store ba as well
        } 
        for(String s : words){
			String temp = reverse(s);
			if(isPalindrome(s) || search(temp) || search(temp.substring(1))) return true;
			else remove(s.substring(1)); // abcc and ccbd.. have to remove bcc before checking for ccbd
        }
		return false;
	}
    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private boolean isPalindrome(String s){
		int i =0, j= s.length()-1;
		while(i<j){
			if(s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
    }
	private void removeHelper(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = false;
            return;
        }

        int childIndex = word.charAt(0) - 'a' ;
        TrieNode child = root.children[childIndex];

        if(child == null) return;
        removeHelper(child, word.substring(1));

        // if child of root is not terminal and child has no children of its own then delete... new and news e.g
        if(!child.isTerminating && child.childCount == 0){
            root.children[childIndex] = null;
            root.childCount--;
        }
    }

    public void remove(String word){
        removeHelper(root, word);
    }
}