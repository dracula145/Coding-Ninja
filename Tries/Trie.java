
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

public class Trie {

    private TrieNode root;
    int numWords;

    public Trie(){
        root = new TrieNode('\0');
        numWords = 0;
    }


    private void addHelper(TrieNode root, String word){

        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }

        int childIndex = word.charAt(0) - 'A';  // ascii
        TrieNode child = root.children[childIndex];
        
        if(child == null){  // if that letter doesn't exist
            child = new TrieNode(word.charAt(0));   // create new node
            root.children[childIndex] = child;  // add it to root
            root.childCount++;
        }   

        addHelper(child, word.substring(1));
    }

    public void add(String word){
        addHelper(root, word);
        numWords++;
    }

    private boolean searchHelper(TrieNode root, String word){
        if(word.length() == 0) return root.isTerminal;

        int childIndex = word.charAt(0) - 'A';  // ascii
        TrieNode child = root.children[childIndex];
        
        if(child == null) return false; // if at any stage next letter doesn't exist return false

        return searchHelper(child, word.substring(1));
    }

    public boolean search(String word){
        return searchHelper(root, word);
    }


    private void removeHelper(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminal = false;
            return;
        }

        int childIndex = word.charAt(0) - 'A' ;
        TrieNode child = root.children[childIndex];

        if(child == null) return;
        removeHelper(child, word.substring(1));

        // if child of root is not terminal and child has no children of its own then delete... new and news e.g
        if(!child.isTerminal && child.childCount == 0){
            root.children[childIndex] = null;
            root.childCount--;
        }
    }

    public void remove(String word){
        removeHelper(root, word);
    }

    public int countWords() {
        return numWords;
	}
}
