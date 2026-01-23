class Solution {
    public int maxArea(int[] height) {
        int lp = 0, rp = height.length - 1;
        int maxW = 0;

        while(lp <= rp){
            int width = rp - lp;
            int h = Math.min(height[rp], height[lp]);
            int currW = width * h;
            maxW = Math.max(maxW, currW);
            if(height[rp] < height[lp]){
                rp--;
            }else{
                lp++;
            }
        }
        return maxW;
    }
}