package Assignment;

public class PermutationPrint {
    public static void permutations(String input){
		helper(input, "");
	}
    private static void helper(String input, String output)
    {
        if(input.length() == 0)
        {
            System.out.println(output);
            return;
        }
        for(int i =0; i< input.length(); i++)
        {
            String temp_out = output + input.charAt(i);
            String temp_inp = input.substring(0, i) + input.substring(i+1);
            helper(temp_inp, temp_out);
            temp_inp = "";    // everytime we print and come back.. we need to reset
            temp_out = "";
        }
    }
}
