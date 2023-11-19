import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indicies = new HashMap<Integer, Integer>();
        for (int ik=0;ik<nums.length;ik++) {
            int curr = nums[ik];
            int other = target-curr;

            int val = (indicies.get(other) != null ? (int)indicies.get(other).intValue() : -1);
            if(val > -1) {
                return new int[] { ik, val };
            } else {
                indicies.put(new Integer(curr), new Integer(ik));
            }
        }
        return new int[] { 0,0 };
    }
}