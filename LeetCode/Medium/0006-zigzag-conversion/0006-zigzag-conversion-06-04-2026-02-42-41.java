class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<List<Character>> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            list.add(new ArrayList<>());
        }
        int idx = -1;
        boolean increase = true;
        for(char c : s.toCharArray()){
            if(increase){
                idx++;
            } else {
                idx--;
            }
            list.get(idx).add(c);
            if(idx + 1 == numRows ){
                increase = false;
            } else if (idx == 0) {
                increase = true;
            }
        }

        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.get(i).size(); j++){
                sb.append(list.get(i).get(j));
            }
        }

        return sb.toString();
    }
}