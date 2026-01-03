class Solution {
    public String reversePrefix(String s, int k) {
        if(s == null || s.length() == 0 || k <= 1){
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = k-1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        sb.append(s.substring(k));

        return sb.toString();
    }
}