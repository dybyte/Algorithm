class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(new ArrayList<>(),candidates,target,0,0);
        return answer;
    }

    void dfs(List<Integer> arr, int[] candidates, int target, int curSum, int curIdx){
        if(target == curSum){
            answer.add(new ArrayList<>(arr));
            return;
        }
        if(target < curSum){
            return;
        }
        for(int i = curIdx; i < candidates.length; i++){
            if (candidates[i] > target) break;
            arr.add(candidates[i]);
            dfs(arr,candidates,target,curSum+candidates[i],i);
            arr.remove(arr.size()-1);
        }
    }
}