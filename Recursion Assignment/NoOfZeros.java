import java.util.*;
public class NoOfZeros {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(countZerosRec(n));
	}
    public static int countZerosRec(int input){
            if(input==0) return 1;  // this is to handle if starting number is zero then it must return 1
            if(input/10 == 0 && input!=0) return 0; // but we want to return 0 when we reach a single digit number !=0
            if(input%10 == 0) return 1 + countZerosRec(input/10);
            else return countZerosRec(input/10);
	}
}
