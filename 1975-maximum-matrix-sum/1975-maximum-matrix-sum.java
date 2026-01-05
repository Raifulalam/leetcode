class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        long m=matrix[0].length;
        long n=matrix[1].length;
        long smallest=Integer.MAX_VALUE;
        long count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0){
                    count++;
                }
                long val=Math.abs(matrix[i][j]);
                smallest=Math.min(smallest,val);
                sum+=val;
            }
        }
        if(count%2==0) return sum;

      return sum-(2*smallest);
    }
}