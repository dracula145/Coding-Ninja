package Assignment;

import java.util.Stack;

public class PairSum {

    private static class Pair{

        BinaryTreeNode<Integer> node;
        int state;  // 1 for pre, 2 for in, 3 for post order... number of times visited that node

        public Pair(BinaryTreeNode<Integer> node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        if(root == null) return;

        Stack <Pair> ls = new Stack<>();        // together they'll take only max O(logn) space at any time
        Stack <Pair> rs = new Stack<>();

        ls.push(new Pair(root, 1));
        rs.push(new Pair(root, 1));

        BinaryTreeNode<Integer> left = getNextNormalInorder(ls);
        BinaryTreeNode<Integer> right = getNextReverseInorder(rs);

        while(left.data < right.data){  // its like 2 pointer array technique.. but in this case O(logn) space
            int sum = left.data + right.data;
            if(sum < s) left = getNextNormalInorder(ls);    // gives next greater element (next inorder)
            else if(sum > s) right = getNextReverseInorder(rs);
            else{
                System.out.println(left.data + " " + right.data);
                left = getNextNormalInorder(ls);
                right = getNextReverseInorder(rs);
            }
        }   
	}

    private static BinaryTreeNode<Integer> getNextNormalInorder(Stack<Pair> st){
        while(st.size() > 0){
            Pair top = st.peek();
            
            if(top.state == 1){ // pre order... insert next left... do state++
                if(top.node.left != null) st.push(new Pair(top.node.left, 1));
                top.state ++;
            }
            else if(top.state == 2){  // in order... insert next right... state++ .. return node
                if(top.node.right != null) st.push(new Pair(top.node.right, 1));
                top.state ++;
                return top.node;    // gives next element in normal inorder
            }

            else{       // post order... pop
                st.pop();
            }
        }
        return null;    // never will reach here
    }


    private static BinaryTreeNode<Integer> getNextReverseInorder(Stack<Pair> st){
        while(st.size() > 0){
            Pair top = st.peek();
            
            if(top.state == 1){ // pre order... insert next right... do state++
                if(top.node.right != null) st.push(new Pair(top.node.right, 1));
                top.state ++;
            }
            else if(top.state == 2){  // in order... insert next left... state++ .. return node
                if(top.node.left != null) st.push(new Pair(top.node.left, 1));
                top.state ++;
                return top.node;    // gives next element in reverse inorder
            }

            else{       // post order... pop
                st.pop();
            }
        }
        return null;    // never will reach here
    }

}
