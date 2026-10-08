class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArray = new int[nums.length];
        int[] suffixArray = new int[nums.length];

        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            prefixArray[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixArray[i] = suffix;
            suffix *= nums[i];
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixArray[i] * suffixArray[i];
        }

        return result;
    }
}  
