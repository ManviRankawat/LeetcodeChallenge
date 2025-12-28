class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        return nQueens(board, 0, n);
    }
    private int nQueens(char[][]board, int row, int n){
        if(row == n){
            return 1;
        }
        int count = 0;

        for(int j = 0; j < n; j++){
            if(isSafe(board, row, j, n)){
                board[row][j] = 'Q';

                count += nQueens(board, row+1, n);

                board[row][j] = '.';
            }
        }
        return count;
    }
    private boolean isSafe(char[][]board, int row, int col, int n){
        for(int j = 0; j < n; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }
        for(int i = 0; i < n; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row, j = col; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}