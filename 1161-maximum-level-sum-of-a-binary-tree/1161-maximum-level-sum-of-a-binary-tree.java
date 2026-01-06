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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        
        int maxSum = Integer.MIN_VALUE;
        int level = 1;           // Result level
        int currentLvl = 1;      // Current level counter
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            int sum = 0;
            
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                sum += temp.val;
                
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            
            if (sum > maxSum) {
                maxSum = sum;
                level = currentLvl;
            }
            
            currentLvl++;
        }
        
        return level;
    }
}