class RandomizedSet {
    private final List<Integer> list = new ArrayList<>();
    private final Map<Integer, Integer> map = new HashMap<>();//key:val,value:idx
    private final Random rand = new Random();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        boolean isPresent = map.containsKey(val);
        if(!isPresent) {
            list.add(val);
            map.put(val,list.size()-1);
        }
        return !isPresent;
    }
    
    public boolean remove(int val) {
        boolean isPresent = map.containsKey(val);
        if(isPresent) {
            int removedIdx = map.get(val);
            int lastVal = list.get(list.size() -1);
            list.set(removedIdx, lastVal);
            map.put(lastVal, removedIdx);
            list.remove(list.size() - 1);
            map.remove(val);
        }
        return isPresent;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */