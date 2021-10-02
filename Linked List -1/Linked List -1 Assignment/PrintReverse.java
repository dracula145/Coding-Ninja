public class PrintReverse {
    public static void printReverse(LinkedListNode<Integer> root) {
		if(root==null) return;
        printReverse(root.next);
        System.out.print(root.data + " ");
	}
}
