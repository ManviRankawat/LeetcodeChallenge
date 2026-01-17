class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;

        int left = 0;
        int max = 0;

        boolean delete = false;

        for(int right = 0; right < nums.length; right++){
            while(nums[right] == 0 && delete == true){
                if(nums[left] == 0) delete = false;
                left++;
            }
            if(nums[right] == 0) delete = true;
            max = Math.max(max, right-left);
        }
        return max;
    }
}