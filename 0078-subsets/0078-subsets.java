class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultSubset = new ArrayList<>();

        backtrack(resultSubset, nums, new ArrayList<>(), 0);
        return resultSubset;
    }

    private void backtrack(List<List<Integer>> results, int[] nums, List<Integer> tempSet, int start){
        results.add(new ArrayList<>(tempSet));

        for(int i = start; i < nums.length; i++){
            tempSet.add(nums[i]);

            backtrack(results, nums, tempSet, i+1);

            tempSet.remove(tempSet.size() - 1);
        }
    }
}