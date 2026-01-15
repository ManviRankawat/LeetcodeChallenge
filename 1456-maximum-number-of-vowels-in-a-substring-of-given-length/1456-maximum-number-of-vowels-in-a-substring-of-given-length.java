class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        int count = 0;
        for(int i = 0; i < k; i++){
            if(vowel.contains(s.charAt(i))){
                count++;
            }
        }
        int maxCount = count;

        if(count == k){
            return count;
        }
        
        // Slide the window
        for(int i = k; i < s.length(); i++){
           
            if(vowel.contains(s.charAt(i))){
                count++;
            }
            
            if(vowel.contains(s.charAt(i - k))){
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}