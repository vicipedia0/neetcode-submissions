class Solution {
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
        frequencyMap.merge(num, 1, Integer::sum);
    }

    List<ArrayList<Integer>> bucketSort = IntStream.range(0, nums.length + 1)
            .mapToObj(i -> new ArrayList<Integer>())
            .toList();
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
        bucketSort.get(entry.getValue()).add(entry.getKey());
    }

    var result = new ArrayList<Integer>();
    for (int i = nums.length; i > 0; i--) {
        var bucket = bucketSort.get(i);
        while (!bucket.isEmpty() && result.size() != k) {
            result.add(bucket.getFirst());
            bucket.removeFirst();
        }
    }
    return result.stream().mapToInt(i -> i).toArray();
}
}
