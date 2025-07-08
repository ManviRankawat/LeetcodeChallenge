class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        for(int j = 0; j < nums.length; j++){
            sum += nums[j];

            while(sum >= target){
                minLength = Math.min(minLength, j-i+1);
                sum -= nums[i];
                i++;
            }
        }
        return minLength == Integer.MAX_VALUE? 0: minLength;
    }
}