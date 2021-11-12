public class Keypad {
    public static String[] keypad(int n){
		if(n==0) return new String[] {""}; // base case

        String[] small_output = keypad(n/10);
        String options = options(n%10);

        String[] new_output = new String[small_output.length * options.length()];
        int c = 0;

        // multiply the strings e.g => a,b,c and de = ad, ae, bd, be, cd, ce
        for(String s : small_output) {
            for(int i=0; i<options.length(); i++)
            new_output[c++] = s + options.charAt(i);
        }
        return new_output;
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
