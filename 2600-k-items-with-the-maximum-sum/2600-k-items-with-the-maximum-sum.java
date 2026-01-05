class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k<numOnes) return k;
        int totalP=numOnes+numZeros;
        if(k>totalP){
            int p=k-totalP;
            return numOnes-p;
        }
        return numOnes;
    }
}