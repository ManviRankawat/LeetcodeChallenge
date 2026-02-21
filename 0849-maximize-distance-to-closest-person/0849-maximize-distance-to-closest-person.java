class Solution {
    public int maxDistToClosest(int[] seats) {
        int lastPersonIndex = -1;
        int maxDist = 0;
        for(int i = 0; i <= seats.length - 1; i++){

            if(seats[i] == 1){
                if(lastPersonIndex == -1){ //firstpersonHit
                    maxDist = Math.max(maxDist, i);
                }else{//alreadyfoundAPerson
                    maxDist = Math.max(maxDist,  (i - lastPersonIndex)/2);
                }
                lastPersonIndex = i;
            
            }   
        }
        return maxDist = Math.max(maxDist, (seats.length - lastPersonIndex - 1));
    }
}