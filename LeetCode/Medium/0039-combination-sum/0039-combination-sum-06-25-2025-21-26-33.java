class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(new ArrayList<>(), candidates, target, 0, 0);
        return answer;
    }

    void dfs(List<Integer> arr, int[] candidates, int target, int sum, int idx){
        if(target == sum){
            answer.add(new ArrayList<>(arr));
            return;
        }
        if(target < sum){
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            arr.add(candidates[i]);
            dfs(arr,candidates,target,sum+candidates[i],i);
            arr.remove(arr.size()-1);
        }
    }
}