import java.util.*;
public class GeometricSum {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		double ans = findGeometricSum(k);
		System.out.println(ans);
	}

    public static double findGeometricSum(int k){
		if(k==0) return 1;
        return 1/(Math.pow(2, k)) + findGeometricSum(k-1);
	}
}
