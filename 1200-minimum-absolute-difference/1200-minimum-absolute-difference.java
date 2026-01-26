class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> pairs = new ArrayList<>();

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 1; i++){
            int diff= arr[i+1] - arr[i];
            minDiff = Math.min(diff, minDiff);
        }

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i+1] - arr[i] == minDiff){
                pairs.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return pairs;
    }
}