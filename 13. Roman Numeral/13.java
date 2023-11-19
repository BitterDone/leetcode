import java.util.HashMap;
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Same time/memory
        // HashSet<String> testCases = new HashSet<String>(Arrays.asList("IV", "IX", "XL", "XC", "CD", "CM"));
        int sum = 0;
        for (int u=0;u<s.length();u++) {
            char curr = s.charAt(u);
            sum += map.get(curr);

            if (u-1 < 0) { continue; }

            String test = s.substring(u-1, u+1);
            int val = map.get(s.charAt(u-1));

            // Same time/memory
            // if (testCases.contains(test)) { sum -= 2*val; }
            if (test.equals("IV")) { sum -= 2*val; }
            if (test.equals("IX")) { sum -= 2*val; }
            if (test.equals("XL")) { sum -= 2*val; }
            if (test.equals("XC")) { sum -= 2*val; }
            if (test.equals("CD")) { sum -= 2*val; }
            if (test.equals("CM")) { sum -= 2*val; }

            // char next;
            // if (s.charAt(u-1)=='I') {
            //     if (curr == 'V') {sum -= 2*map.get(s.charAt(u-1));}
            //     else if (curr == 'X') {sum -= 2*map.get(s.charAt(u-1));}

            // }
            // if (s.charAt(u-1)=='X') {
            //     if (curr == 'L') {sum -= 2*map.get(s.charAt(u-1));}
            //     else if (curr == 'C') {sum -= 2*map.get(s.charAt(u-1));}

            // }
            // if (s.charAt(u-1)=='C') {
            //     if (curr == 'D') {sum -= 2*map.get(s.charAt(u-1));}
            //     else if (curr == 'M') {sum -= 2*map.get(s.charAt(u-1));}

            // }

        }
        return sum;
    }

    void p(String m) { System.out.println(m); }
}