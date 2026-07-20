class Solution {
    public int trailingZeroes(int n) {
        int byTwo = 0, byFive = 0;
        for(int i = 0; i < n; i++){
            int num = n - i;
            if(num%2 == 0){
                int tmp = num;
                int count = 0;
                while(tmp%2 == 0){
                    tmp/=2;
                    count++;
                }
                byTwo += count;
            }
            if(num%5 == 0){
                int tmp = num;
                int count = 0;
                while(tmp%5 == 0){
                    tmp/=5;
                    count++;
                }
                byFive += count;
            }
        }
        return Math.min(byTwo, byFive);
    }
}