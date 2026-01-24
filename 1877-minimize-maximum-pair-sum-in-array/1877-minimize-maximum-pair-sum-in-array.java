class Solution {
    public int minPairSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            maxSum = Math.max(sum, maxSum);
            i++;
            j--;
        }
        return maxSum;
    }
}