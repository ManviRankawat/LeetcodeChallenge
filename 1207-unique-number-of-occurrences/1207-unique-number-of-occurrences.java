class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurence = new HashMap<>();

        for(int i: arr){
            occurence.put(i, occurence.getOrDefault(i, 0) + 1);
        }

        Set<Integer> count = new HashSet<>();
        for(int i: occurence.values()){
            count.add(i);
        }

        return occurence.size() == count.size();
    }
}