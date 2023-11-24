import java.util.HashSet;

class Solution {
    String substring = "";

    public int lengthOfLongestSubstring(String s) {
        String localSubstring = "";
        HashSet<Character> set = new HashSet<Character>();
        for (int z=0;z<s.length();z++) {
            char c = s.charAt(z);
            if (!set.contains(c)) {
                set.add(c);
                localSubstring += String.valueOf(c);
            } else {
                break;
            }
        }
        if (localSubstring.length() > substring.length()) {
            substring = localSubstring;
        }
        if (s.length() > 1) {
            return lengthOfLongestSubstring(s.substring(1));
        }
        return substring.length();
    }
}
