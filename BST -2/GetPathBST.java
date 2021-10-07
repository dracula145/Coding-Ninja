public class GetPathBST {
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		if(root == null) return null;
        if(root.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(data);
            return list;
        }
        if(root.data > data){
            ArrayList<Integer> leftOutput = getPath(root.left, data);
            if(leftOutput !=null){
                leftOutput.add(root.data);
                return leftOutput;
            }
        	else return null;
        }
        ArrayList<Integer> rightOutput = getPath(root.right, data);
        if(rightOutput != null){
            rightOutput.add(root.data);
                return rightOutput;
        }
         return null;
	}
}
