import java.util.*;
public class Multiplication {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		System.out.println(multiplyTwoIntegers(m, n));
	}
    
	public static int multiplyTwoIntegers(int m, int n){
		if(n==0) return 0;
        return m + multiplyTwoIntegers(m, n-1);	
	}
}
