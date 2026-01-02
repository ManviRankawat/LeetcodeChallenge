class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            count.put(nums[i],count.getOrDefault(nums[i], 0) + 1);
        }

        int n = nums.length/2;
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            if(entry.getValue() == n){
                return entry.getKey();
            }
        }
        return -1;
    }
}