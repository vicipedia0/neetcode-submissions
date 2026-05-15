class Solution {
    public int[] productExceptSelf(int[] nums) {
    var count0 = Arrays.stream(nums).filter(num -> num == 0).count();

    if (count0 > 1) {
        return IntStream.range(0, nums.length)
                .map(i -> 0)
                .toArray();
    }

    var output = new int[nums.length];
    var productWithout0 = Arrays.stream(nums)
            .filter(num -> num != 0)
            .reduce(1, (a, b) -> a * b);
    if (count0 == 1) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                output[i] = productWithout0;
            } else {
                output[i] = 0;
            }
        }
        return output;
    }

    for (int i = 0; i < nums.length; i++) {
        output[i] = productWithout0 / nums[i];
    }
    return output;
}
}  
