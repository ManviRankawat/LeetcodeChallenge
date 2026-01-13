class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        int write = 0;
        
        while (j < chars.length) {
            int count = 0;
            char current = chars[j];
            
            // Count consecutive characters
            while (j < chars.length && chars[j] == current) {
                j++;
                count++;
            }
            
            // Write character
            chars[write++] = current;
            
            // Write count if > 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        
        return write;
    }
}