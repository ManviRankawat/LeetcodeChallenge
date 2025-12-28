class Solution{
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        Q2 res = new Q2();
        return res.solve(cost1, cost2, costBoth, need1, need2);
    }
}

class Q2 {
    public long solve(int cost1, int cost2, int costBoth, int need1, int need2) {
        long res = Long.MAX_VALUE;
        long base = (long)need1*cost1 + (long)need2*cost2;
        res = Math.min(res, base);
        
        if((long)costBoth < (long)cost1+cost2) {
            int maxNeed = Math.max(need1, need2);
            long allBoth = (long)maxNeed*costBoth;
            res = Math.min(res, allBoth);
        }
        
        int minNeed = Math.min(need1, need2);
        long mixed = (long)minNeed*costBoth;
        
        if(need1 > need2) {
            mixed += (long)(need1-minNeed)*cost1;
        } else {
            mixed += (long)(need2-minNeed)*cost2;
        }
        
        res = Math.min(res, mixed);
        return res;
    }
}