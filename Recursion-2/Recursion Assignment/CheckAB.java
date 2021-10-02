import java.util.Scanner;

public class CheckAB {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		System.out.println(checkAB(input));
	}
    public static boolean checkAB(String input) {
      if(input.length() == 0) return false;
      if(input.charAt(0) == 'b') return false;  // to check if string starts with a 'b'
      return check(input);
	}
  public static boolean check(String input){
    if(input.length()==0) return true;
    if(input.equals("ab") || input.equals("ba") || input.equals("b")) return false;  //last remaining substring
    if(input.charAt(0)=='a') return check(input.substring(1));
    if(input.charAt(0)=='b' && input.charAt(1)=='b') return check(input.substring(2));
    return false;
  }
}
