class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       final int n=nums1.length;
       final int m=nums2.length;
        if(n>m)
            return findMedianSortedArrays(nums2,nums1);
        int l=0;
        int r=n;
        int totalLeft = (n + m + 1) / 2;
        while(l<=r){
            int p1 = (l + r) / 2;
            int p2 = totalLeft - p1;

            int maxL1 = (p1 == 0) ? Integer.MIN_VALUE : nums1[p1 - 1];
            int minR1 = (p1 == n) ? Integer.MAX_VALUE : nums1[p1];

            int maxL2 = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2 - 1];
            int minR2 = (p2 == m) ? Integer.MAX_VALUE : nums2[p2];

           if (maxL1 <= minR2 && maxL2 <= minR1) {
                 if ((n + m) % 2 == 0) {
                    return (Math.max(maxL1, maxL2) + Math.min(minR1, minR2)) / 2.0;
                } else {
                   return Math.max(maxL1, maxL2);
                }
                }else if (maxL1 > minR2){
               r = p1 - 1;
            }
            else{
               l = p1 + 1;
            }
        }
        throw new IllegalArgumentException(); 
    }
}