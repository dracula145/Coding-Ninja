import java.util.Scanner;

import javax.management.Query;
import javax.swing.tree.TreeNode;

public class InputLevelwise {
    public static TreeNode<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root's data : ");
        int data = sc.nextInt();
        if(data == -1) return null;
        TreeNode<Integer> root = new TreeNode<>(data);

        Queue <TreeNode<Integer>> pending_children = new LinkedList<>();
        pending_children.add(root);

        while(!pending_children.isEmpty()){
            TreeNode<Integer> front = pending_children.remove();
            System.out.println("Enter the number of children of " + front.data + " : ");
            int n = sc.nextInt();
            System.out.println("Enter the children of " + front.data + " : ");
            for(int i=0;i<n;i++){
                int d = sc.nextInt();
                TreeNode<Integer> newNode = new TreeNode<>(d);
                front.children.add(newNode);
                pending_children.add(newNode);
            }
        }
    }
}
