import javax.swing.tree.TreeNode;

public class GreaterThanX {

    public static int numNodeGreater(TreeNode<Integer> root,int x){

		if(root == null) return 0;
        int ans = 0;
        for(TreeNode<Integer> i : root.children) ans += numNodeGreater(i, x);

        if(root.data > x) ans++;
        return ans;

	}
}
