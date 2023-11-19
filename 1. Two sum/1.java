class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for (int ik=0;ik<nums.length;ik++) {
            for (int jk=ik+1;jk<nums.length;jk++) {
                if ((nums[ik] + nums[jk]) == target) {
                    ret[1] = ik;
                    ret[0] = jk;
                    ik = nums.length;
                    jk = nums.length;
                    break;
                }
            }
        }
        return ret;
    }
    void p(String m) { System.out.println(m); }
}
