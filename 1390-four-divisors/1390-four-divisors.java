class Solution {
    public int sumFourDivisors(int[] nums) {
        
         int total=0;
        for(int n:nums){
            int count=0;
            int sum=0;
            for(int i=1;i*i<=n;i++){
                if(n%i==0){
                    int other=n/i;
                  if (i == other) {
                        count += 1;
                        sum += i;
                    } else {
                        count += 2;
                        sum += i + other;
                    }
                    if(count>4){
                        break;
                    }
                }
            }
            if(count==4){
                total+=sum;
            }
            
        }
    
        return total;
    }
}