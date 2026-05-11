class Solution {
    public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    var frequencyTableS = new HashMap<Character, Integer>();
    var frequencyTableT = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
        frequencyTableS.put(s.charAt(i), frequencyTableS.getOrDefault(s.charAt(i), 0) + 1);
        frequencyTableT.put(t.charAt(i), frequencyTableT.getOrDefault(t.charAt(i), 0) + 1);
    }
    return frequencyTableS.equals(frequencyTableT);
}
}
