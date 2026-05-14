class Solution {
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
        frequencyMap.merge(num, 1, Integer::sum);
    }

    List<ArrayList<Integer>> buckets = IntStream.range(0, nums.length + 1)
            .mapToObj(i -> new ArrayList<Integer>())
            .toList();
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
        buckets.get(entry.getValue()).add(entry.getKey());
    }

    var result = new int[k];
    int idx = 0;
    for (int i = buckets.size() - 1; i > 0 && idx < k; i--) {
        for (int bucketValue : buckets.get(i)) {
            result[idx++] = bucketValue;
            if (idx == k) break;
        }
    }
    return result;
}
}
