/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        


        while(start<= end){

            int mid = start + (end - start)/2;
            int result= guess(mid);

            if(result == 0){
                return mid; // Found the number
            } else if (result < 0) {
                end = mid - 1; // Guess is lower, so move the end
            } else {
                start = mid + 1; // Guess is higher, so move the start
            }
        }
        return -1;
    }
}