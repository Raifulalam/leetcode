class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
    if(operations.length==0) return 0;
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("++X") || operations[i].equals("X++")){
                x++;
            }else if(operations[i].equals("--X") || operations[i].equals("X--")){
                x--;
            }
        }
        return x;
    }
}