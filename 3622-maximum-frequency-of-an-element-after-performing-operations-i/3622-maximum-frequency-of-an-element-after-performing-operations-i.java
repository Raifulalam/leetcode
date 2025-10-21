class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        Map<Integer, Integer> maxFreq = new HashMap<>();
        for (int n : nums) {
            maxFreq.put(n, maxFreq.getOrDefault(n, 0) + 1);
        }
        int maxNum = nums[nums.length - 1];
        int ans = 0;
        for (int target = 1; target <= maxNum; target++) {
            ans = Math.max(ans, maxFreq(target, nums, maxFreq, k, numOperations));
        }
        return ans;
    }

    private int maxFreq(int target, int[] nums, Map<Integer, Integer> maxFreq, int k, int numOperations) {
        int left = getIndex(nums, target - k);
        int right = getIndex(nums, target + k+1);
        int op = right - left - maxFreq.getOrDefault(target, 0);
        return Math.min(op, numOperations) + maxFreq.getOrDefault(target, 0);
    }

    private int getIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}