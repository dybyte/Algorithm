class Solution {
    public String largestNumber(int[] nums) {
        List<Num> list = new ArrayList<>();
        for(int i : nums) list.add(new Num(i));
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder("");
        if(list.get(0).val == 0) return "0";
        for(Num n : list){
            sb.append(n.val);
        }
        return sb.toString();
    }

    class Num implements Comparable<Num> {
        int val;
        Num(int val){
            this.val = val;
        }
        public int compareTo(Num other){
            String start = String.valueOf(this.val) + String.valueOf(other.val);
            String end = String.valueOf(other.val) + String.valueOf(this.val);
            Double startNum = Double.parseDouble(start);
            Double endNum = Double.parseDouble(end);
            Double result = endNum - startNum;
            if(result > 0) return 1;
            else if(result == 0) return 0;
            return -1;
        }
    }
    
}