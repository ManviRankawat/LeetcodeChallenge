class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for(int num : nums){
            if(!seen.add(num)){  // add() returns false if element already exists
                return num;
            }
        }
        
        return -1;
    }
}