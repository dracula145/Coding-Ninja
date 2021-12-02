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
