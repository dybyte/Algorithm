class Solution {
    int answer = 0;
    public int countNumbersWithUniqueDigits(int n) {
        boolean[] visited = new boolean[10];
        backTracking(new ArrayList<>(),0,visited,n);
        return answer+1;
    }

    void backTracking(List<Integer> sb, int len, boolean[] visited, int n){  
        if(len == n) {            
            return;
        }
        for(int i = 0; i < 10; i++){
            if(len == 0 && i == 0) continue;
            if(!visited[i]){
                answer++;
                sb.add(i);
                visited[i] = true;
                backTracking(sb,len + 1, visited, n);
                visited[i] = false;
                sb.remove(sb.size()-1);
            }
        }
    }
}