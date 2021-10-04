import java.lang.*;

class Pair<T, U> {
    T minimum;
    U maximum;

    public Pair(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}
public class MinMax {
    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		if(root == null) return new Pair<Integer,Integer>(Integer.MAX_VALUE,Integer.MIN_VALUE);
        
        Pair<Integer, Integer> leftOutput = getMinAndMax(root.left);
        Pair<Integer, Integer> rightOutput = getMinAndMax(root.right);
        Pair<Integer, Integer> ans = new Pair<>(0,0);
        
        ans.minimum = Math.min(root.data, Math.min(leftOutput.minimum, rightOutput.minimum));
        ans.maximum = Math.max(root.data, Math.max(leftOutput.maximum, rightOutput.maximum));
        return ans;
	}
}
