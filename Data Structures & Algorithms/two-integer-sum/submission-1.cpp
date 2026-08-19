class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> hashTable;
        for (int i = 0; i < nums.size(); i++) {
            if (hashTable.contains(nums[i])) {
                return {hashTable[nums[i]], i};
            }
            int other = target - nums[i];
            hashTable[other] = i;
        }
        return {};
    }
};
