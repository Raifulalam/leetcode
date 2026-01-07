/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    // Step 1: Calculate total sum of tree
    long totalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    // Step 2: Calculate subtree sums & max product
    long find(TreeNode root) {
        if (root == null) return 0;

        long left = find(root.left);
        long right = find(root.right);

        long subTreeSum = root.val + left + right;
        long remaining = totalSum - subTreeSum;

        maxProduct = Math.max(maxProduct, subTreeSum * remaining);

        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = totalSum(root);
        find(root);
        return (int)(maxProduct % MOD);
    }
}
