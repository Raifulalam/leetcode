class Solution {
   public int numberOfBeams(String[] bank) {
       int totalBeams = 0;          
       int previousDeviceCount = 0;      
       
       for (String row : bank) {
           int currentDeviceCount = 0;  
            for (int i = 0; i < row.length(); i++) {
                currentDeviceCount += row.charAt(i) - '0';
            }
            if (currentDeviceCount > 0) {
                totalBeams += previousDeviceCount * currentDeviceCount;
                previousDeviceCount = currentDeviceCount;
            }
        }
        return totalBeams;
    }
}