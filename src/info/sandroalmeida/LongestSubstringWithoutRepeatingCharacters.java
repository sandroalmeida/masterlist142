package info.sandroalmeida;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        Set<Character> charSet = new HashSet<>();

        for(int right = 0; right < s.length(); right++){
            if(!charSet.contains(s.charAt(right))){
                charSet.add(s.charAt(right));
            } else{
                while(charSet.contains(s.charAt(right))){
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
