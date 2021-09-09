import java.util.Scanner;

public class StringToInteger {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(convertStringToInt(input));
	}
    public static int convertStringToInt(String input){
		if(input.length() <= 0) return 0;
        return convertStringToInt(input.substring(0,input.length()-1))*10 + input.charAt(input.length()-1)-48;
	}
}

