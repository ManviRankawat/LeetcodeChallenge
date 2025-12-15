class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        int length = 1;

        for(int i = 0; i < prices.length; i++){
            if(i > 0 && prices[i] == prices[i - 1] - 1){
                length++;
            }else{
                length = 1;
            }
            res += length;
        }
        return res;
    }
}