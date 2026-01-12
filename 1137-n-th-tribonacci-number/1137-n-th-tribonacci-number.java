class Solution {
    public int tribonacci(int n) {
        int memo[] = new int[n+1];
        return calc(memo, n);
    }

    private int calc(int memo[], int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        if(memo[n] != 0)return memo[n];

        memo[n] = calc(memo, n-1) + calc(memo, n-2) + calc(memo, n-3);

        return memo[n];
        
    }
}