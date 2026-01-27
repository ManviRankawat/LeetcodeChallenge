class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        Map<Character, Integer> w1 = new HashMap<>();
        Map<Character, Integer> w2 = new HashMap<>();

        for(int i = 0; i < word1.length(); i++){
            w1.put(word1.charAt(i), w1.getOrDefault(word1.charAt(i), 0)+1);
        }
        for(int i = 0; i < word2.length(); i++){
            w2.put(word2.charAt(i), w2.getOrDefault(word2.charAt(i), 0)+1);
        }

        if(!w1.keySet().equals(w2.keySet())) return false;

        List<Integer> freq1 = new ArrayList<>(w1.values());
        List<Integer> freq2 = new ArrayList<>(w2.values());
        Collections.sort(freq1);
        Collections.sort(freq2);

        return freq1.equals(freq2);
    }
}