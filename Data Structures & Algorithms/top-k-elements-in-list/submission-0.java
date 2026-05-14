class Solution {
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
        if (!frequencyMap.containsKey(num)) {
            frequencyMap.put(num, 0);
        }
        var frequency = frequencyMap.get(num);
        frequencyMap.put(num, ++frequency);
    }
   return frequencyMap.entrySet().stream()
            .sorted((e1, e2) ->  e2.getValue() - e1.getValue())
            .mapToInt(Map.Entry::getKey)
            .limit(k)
            .toArray();
}
}
