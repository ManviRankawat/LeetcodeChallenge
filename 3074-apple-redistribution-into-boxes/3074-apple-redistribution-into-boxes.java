class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        
        for(int count : apple){
            sum += count;
        }

        Arrays.sort(capacity);
        
        int boxesUsed = 0;
        int i = capacity.length - 1;
        
        while(sum > 0 && i >= 0){
            sum -= capacity[i];
            boxesUsed++;
            i--;
        }
        
        return boxesUsed;
    }
}