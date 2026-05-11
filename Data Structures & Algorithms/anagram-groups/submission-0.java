class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            str.chars().forEach(it -> count[it-'a']++);
            var countString = Arrays.toString(count);
            anagramGroups.putIfAbsent(countString, new ArrayList<>());
            anagramGroups.get(countString).add(str);
        }
        return List.copyOf(anagramGroups.values());
    }
}
