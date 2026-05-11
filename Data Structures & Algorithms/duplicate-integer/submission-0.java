class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<Integer>();
        for (int i : nums) {
            if (uniques.contains(i)) return true;
            uniques.add(i);
        }
        return false;
    }
}