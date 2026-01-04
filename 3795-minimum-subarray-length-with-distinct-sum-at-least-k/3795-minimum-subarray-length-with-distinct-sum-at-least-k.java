class Solution {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, sum = 0, minLength = Integer.MAX_VALUE;

        for(int j = 0; j < nums.length; j++){
            int counter = count.getOrDefault(nums[j], 0);
            if(counter == 0){
                sum += nums[j];
            }
            count.put(nums[j], counter + 1);

            while(sum >= k){
                minLength = Math.min(minLength, j-i+1);

                int countL = count.get(nums[i]);
                if(countL == 1){
                    sum -= nums[i];
                }

                if(countL > 1){
                    count.put(nums[i], countL - 1);
                }else{
                    count.remove(nums[i]);
                }
                i++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }
}