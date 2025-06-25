class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(),candidates,target,0,0);
        return answer;
    }

    void dfs(List<List<Integer>> answer, List<Integer> arr, int[] candidates, int target, int curSum, int curIdx){
        if(target == curSum){
            answer.add(new ArrayList<>(arr));
            return;
        }
        if(target < curSum){
            return;
        }
        for(int i = curIdx; i < candidates.length; i++){
            arr.add(candidates[i]);
            dfs(answer, arr,candidates,target,curSum+candidates[i],i);
            arr.remove(arr.size()-1);
        }
    }
}