class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       // 0번째 방은 그냥 들어갈 수 있다.
       // 0번쨰 방에 들어가서 key값에 해당하는 방들을 모두 방문
       // 순환이 발생하지 않게 visited 를 관리해야할 것 같음
       // 모두 방문했는지 확인하는 법 : visited 순회 

       Queue<Integer> queue = new ArrayDeque<>();
       boolean[] visited = new boolean[rooms.size()];

       List<Integer> keys = rooms.get(0);
       visited[0] = true;
       queue.offer(0);

       while(!queue.isEmpty()){
            int poll = queue.poll();

            List<Integer> list = rooms.get(poll);
            for(int key : list){
                if(!visited[key]){
                    visited[key] = true;
                    queue.offer(key);
                }
            }
       }

       for(int i = 0; i < visited.length; i++){
            if(!visited[i]) return false;
       }
       return true;
    }
}