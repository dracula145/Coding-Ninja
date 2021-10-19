package Assignment;

import java.util.HashMap;

public class UniqueChar {
    public static String uniqueChar(String str){
		HashMap<Character, Boolean> map = new HashMap<>();
        String result = "";
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                result += c;
                map.put(c, true);
            }
        }
        return result;
	}
}
