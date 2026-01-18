class Solution {
    public int largestAltitude(int[] gain) {
        int[] sum = new int[gain.length];
        sum[0] = gain[0];
        int maxAlt = sum[0];

        for(int i = 1; i < gain.length; i++){
            sum[i] = gain[i] + sum[i-1];
            maxAlt = Math.max(maxAlt, sum[i]);
        }
        return maxAlt<0? 0: maxAlt;
    }
}