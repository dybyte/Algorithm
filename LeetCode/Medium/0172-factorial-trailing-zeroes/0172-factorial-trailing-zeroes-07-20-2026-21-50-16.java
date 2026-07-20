class Solution {
    public int trailingZeroes(int n) {
        int byFive = 0;
        for(int i = 0; i < n; i++){
            int num = n - i;
            if(num%5 != 0) continue;
            int tmp = num;
            int count = 0;
            while(tmp%5 == 0){
                tmp/=5;
                count++;
            }
            byFive += count;
        }
        return byFive;
    }
}