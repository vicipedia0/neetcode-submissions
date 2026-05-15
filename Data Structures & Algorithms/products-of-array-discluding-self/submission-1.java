class Solution {
    public int[] productExceptSelf(int[] nums) {
        var n = nums.length;
        var prefixes = new int[n];
        var sufixes = new int[n];
        prefixes[0] = 1;
        sufixes[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefixes[i] = prefixes[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            sufixes[i] = sufixes[i + 1] * nums[i + 1];
        }

        var output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = prefixes[i] * sufixes[i];
        }
        return output;
    }
}

// 0 1 2 3 4 5
// 3 2 0 1 2 3

// prefixes:
//  0 1 2 3 4 5
//  1 3 6 0 0 0

// sufixes:
//  0 1 2 3 4 5
//  0 0 6 6 3 1

//--------------------
// 0 1 2 3 4 5
// 3 2 2 1 2 3

// prefixes:
//  0 1 2 3  4  5
//  1 3 6 12 12 24

// sufixes:
//  0 1 2 3 4 5
//  0 0 6 6 3 1