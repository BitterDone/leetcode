import java.util.HashSet;

class Solution {
    HashSet<Character> set = new HashSet<Character>();
    int fast=0, slow=0, max=0;

    public int lengthOfLongestSubstring(String s) {
        while (fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast));
                fast++;
            max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(slow));
                slow++;
            }
        }
        return max;
    }
}