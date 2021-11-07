package Assignment;
import java.util.*;

class TrieNode{
    char data;
    boolean isTerminal;
    TrieNode children[];
    int childCount;

    public TrieNode(char data){
        this.data = data;
        this.isTerminal = false;
        children = new TrieNode[26]; // create an array of trie node references for children (at max 26 children)
        childCount = 0;
    }
}
public class PatternMatching {
    private TrieNode root;

    public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}
    private void addHelper(TrieNode root, String word){

        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }

        int childIndex = word.charAt(0) - 'a';  // ascii
        TrieNode child = root.children[childIndex];
        
        if(child == null){  // if that letter doesn't exist
            child = new TrieNode(word.charAt(0));   // create new node
            root.children[childIndex] = child;  // add it to root
            root.childCount++;
        }   

        addHelper(child, word.substring(1));
    }

    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        for(String s : vect){
            // adding suffix words
            for(int i = 0; i<s.length(); i++){
                addHelper(root, s.substring(i));
            }
        }
        return search(pattern);
	}
}
