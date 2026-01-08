class Solution {
    int m, n;
    Integer[][] dp;

    int solve(int[] nums1, int[] nums2, int i, int j) {
        if (i == m || j == n) return Integer.MIN_VALUE;
        if (dp[i][j] != null) return dp[i][j];

        int val = nums1[i] * nums2[j];
        int takeBoth = val + Math.max(0, solve(nums1, nums2, i + 1, j + 1));
        int skip1 = solve(nums1, nums2, i + 1, j);
        int skip2 = solve(nums1, nums2, i, j + 1);

        return dp[i][j] = Math.max(takeBoth, Math.max(skip1, skip2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new Integer[m][n];
        return solve(nums1, nums2, 0, 0);
    }
}
