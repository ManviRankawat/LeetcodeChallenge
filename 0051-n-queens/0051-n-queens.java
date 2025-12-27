class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        nQueens(board, 0, n, result);
        return result;
    }

    private void nQueens(char[][] board, int row, int n, List<List<String>> result){
        if(row == n){
            result.add(constructBoard(board));
            return;
        }
        for(int j = 0; j < n; j++){
            if(isSafe(board, row, j, n)){
                board[row][j] = 'Q';

                nQueens(board, row + 1, n , result);

                board[row][j] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n){

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

    private List<String> constructBoard(char[][] board){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            result.add(new String(board[i]));
        }
        return result;
    }
}