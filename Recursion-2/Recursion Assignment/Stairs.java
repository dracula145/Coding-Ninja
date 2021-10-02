import java.util.Scanner;

public class Stairs {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(staircase(n));
	}
    public static int staircase(int n){
		if(n==0) return 1;
		if(n==1) return 1;
		if(n==2) return 2;
		//if(n==3) return 4;  // i had used this and in n==0 returned 0
		return staircase(n-1) + staircase(n-2) + staircase(n-3);
    }
}
