/*

Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get 
reduced to 1. You can perform any one of the following 3 steps:

1.) Subtract 1 from it. (n = n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  

Constraints :
1 <= n <= 200

Time Limit: 1 sec
Sample Input 1 :
4
Sample Output 1 :
2 
Explanation of Sample Output 1 :
For n = 4
Step 1 :  n = 4 / 2  = 2
Step 2 : n = 2 / 2  =  1 
Sample Input 2 :
7
Sample Output 2 :
3
Explanation of Sample Output 2 :
For n = 7
Step 1 :  n = 7 ­- 1 = 6
Step 2 : n = 6  / 3 = 2 
Step 3 : n = 2 / 2 = 1  

*/

public class MinStepsToOne {
    public static void main(String args[]){
        int result = countMinStepsToOne(10);
        System.out.println(result);
    }
    public static int countMinStepsToOne(int n) {
		if(n==1) return 0;
        int res1 = Integer.MAX_VALUE, res2 = res1, res3 = res1;

        //need to explore all options. e.g 10->5->4->2->1 = 4 staps
        // but should be 10->9->3->1 = 3 steps

        if(n%3 == 0) res3 = countMinStepsToOne(n/3);
        if(n%2 == 0) res2 = countMinStepsToOne(n/2);
        res1 = countMinStepsToOne(n-1);

        // take minimum of all the options
        int result = Math.min(res1, Math.min(res2, res3));
        return 1 + result;
	}

}
