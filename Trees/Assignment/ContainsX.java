import java.util.ArrayList;

class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    TreeNode(T data){
        this.data = data;
        children = new ArrayList<TreeNode<T>>();
    }
}

public class ContainsX {

    static boolean ans = false;
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        if(root == null) return false;
        if(root.data == x) return true;
        for(TreeNode<Integer> i : root.children) ans = ans | checkIfContainsX(i, x);
        return ans;
	}
}

// for(TreeNode<Integer> i : root.children) return checkIfContainsX(i, x); wont work... because
// it returns whatever value 1st child offers.. and doesn't look for other children