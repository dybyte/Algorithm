class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int idx = -1;
        boolean increase = true;
        for(char c : s.toCharArray()){
            if(increase){
                idx++;
            } else {
                idx--;
            }
            rows[idx].append(c);
            if(idx + 1 == numRows ){
                increase = false;
            } else if (idx == 0) {
                increase = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}