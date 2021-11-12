public class KeypadInsideRecusiveFunction {
    public static void printKeypad(int input){
		printKeypadHelper(input, "");
	}
    public static void printKeypadHelper(int input, String string_so_far){
        if(input == 0){
            System.out.println(string_so_far);
            return;
        }
        String options = options(input%10);
        for(int i=0; i<options.length(); i++){
            printKeypadHelper(input/10, options.charAt(i) + string_so_far);
        }
    }

    //return corresponding strings of given number
    private static String options(int n){
        if(n==2) return "abc";
        if(n==3) return "def";
        if(n==4) return "ghi";
        if(n==5) return "jkl";
        if(n==6) return "mno";
        if(n==7) return "pqrs";
        if(n==8) return "tuv";
        if(n==9) return "wxyz";
        return "";
    }
}
