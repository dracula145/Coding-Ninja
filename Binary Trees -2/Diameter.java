import java.lang.*;
public class Diameter {
    
    private class Return2Values{  // for every node we keep its height and diameter wrapped around this single class
        int height;
        int diameter;
        public Return2Values(){
            
        }
        public Return2Values(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
		}
    }

	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		Return2Values ans = helper(root);
        return ans.diameter;
	}
	private static Return2Values helper(BinaryTreeNode<Integer> root){
        if(root == null) return new Return2Values(0, 0);
        
        Return2Values leftOutput = helper(root.left);
        Return2Values rightOutput = helper(root.right);
        Return2Values ans = new Return2Values();
        ans.height = 1 + Math.max(leftOutput.height, rightOutput.height);
        ans.diameter = Math.max(1+leftOutput.height+rightOutput.height,       // watch video to know why diameter is so
                    	Math.max(leftOutput.diameter, rightOutput.diameter));
        return ans;
    }
}