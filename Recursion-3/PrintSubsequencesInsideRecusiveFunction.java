public class PrintSubsequencesInsideRecusiveFunction {

    public static void main(String args[]){
        printSubsequences("abc", "");
    }

    public static void printSubsequences(String word, String string_so_far){
        if(word.length() == 0){
            System.out.print(string_so_far + " ");
            return;
        }
        printSubsequences(word.substring(1), string_so_far);
        printSubsequences(word.substring(1), string_so_far + word.charAt(0));
    }
}
