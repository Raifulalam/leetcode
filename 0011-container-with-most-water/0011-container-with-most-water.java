class Solution {
    public int maxArea(int[] height) {
        int right=height.length-1;
        int left=0;
        int res=0;
        
        while(left<right){
            int max=Math.min(height[left],height[right])*(right-left);
            res=Math.max(max,res);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
       
        return res;
    }
}