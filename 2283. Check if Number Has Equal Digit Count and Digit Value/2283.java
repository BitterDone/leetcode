class Solution {
    void p(String m) { System.out.println(m); }
    void p(int m) { System.out.println("" + m); }

    public boolean digitCount(String numberString) {
        int[] num = new int[numberString.length()];
        String[] numberStrings = numberString.split("");
        for (int k=0;k<num.length; k++) { num[k] = Integer.parseInt(numberStrings[k]); }
        int[] tracker = new int[num.length];

        p(numberString.length()+" digits in "+numberString+","+numberString.length()+"="+num.length+"="+tracker.length);
        
        // Return true         
        boolean ret = true;
        //  for every index i in the range 0 <= i < n, 
        for (int k=0;k<numberString.length(); k++) {
        // if the digit i occurs num[i] times in num,
            if(countRepsOf_k_in(k, num) != num[k]) {
                ret = false;
            }
        }
        // otherwise 
        //  return false.

        num = new int[numberString.length()];
        tracker = new int[num.length];
        return ret;
    }

    int countRepsOf_k_in(int i, int[] nums) {
        p("Counting reps of " + i);
        int counter = 0;
        for (int k=0;k<nums.length; k++) {
            boolean result = nums[k] == i;
            p("\tCompare against " + nums[k] + ": " + result);
            if (result) {
                counter++;
            }
        }
        p("\t\tFound " + counter + " reps of " + i);
        return counter;
    }

}
