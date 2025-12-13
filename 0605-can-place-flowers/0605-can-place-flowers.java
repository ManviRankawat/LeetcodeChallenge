class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n < 0 || flowerbed.length == 0) return false;

        int count = 0;

        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                boolean leftbed = (i == 0 || flowerbed[i-1] == 0);
                boolean rightbed = (i == flowerbed.length - 1 || flowerbed[i+1] == 0);

                if(leftbed && rightbed){
                    flowerbed[i] = 1;
                    count++;

                    if(count >= n) return true;
                }
            }
        }
        return count >= n;
    }
}