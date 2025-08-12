class Solution {
    public String largestNumber(int[] nums) {
        List<Num> list = new ArrayList<>();
        for(int i : nums){
            list.add(new Num(i));
        }
        Collections.sort(list);
        StringBuilder ans = new StringBuilder("");
        boolean firstZero = true;
        for(Num n : list) {
            if(firstZero && n.value == 0) continue;
            else firstZero = false;
            ans.append(n.value);
        }
        if(ans.length() == 0) return "0";
        return ans.toString();
    }

    class Num implements Comparable<Num> {
        int value;
        Num (int value){
            this.value = value;
        }
        public int compareTo(Num other){
            String start = Integer.toString(this.value) + Integer.toString(other.value);
            String end = Integer.toString(other.value) + Integer.toString(this.value);
            Double startNum = Double.parseDouble(start);
            Double endNum = Double.parseDouble(end);
            if(endNum - startNum > 0) return 1;
            else if(endNum - startNum == 0) return 0;
            else return -1;
        }
    }
}