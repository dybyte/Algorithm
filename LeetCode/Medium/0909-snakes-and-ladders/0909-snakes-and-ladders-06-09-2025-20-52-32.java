class Solution {
    public int snakesAndLadders(int[][] board) {
        Map<Integer, Integer> snakes = new HashMap<>();
        int count = 1;
        int flag = 0;
        for(int i = board.length - 1; i >= 0; i--){
            if(flag%2==0){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] != -1){
                        snakes.put(count,board[i][j]);
                    }
                    count++;
                } 
            } else{
                for(int j = board[0].length - 1; j >= 0; j--){
                    if(board[i][j] != -1){
                        snakes.put(count,board[i][j]);
                    }
                    count++;
                }
            }
            flag++;
        }
        Queue<Position> positions = new LinkedList<>();
        positions.add(new Position(1, 0));
        while (!positions.isEmpty()) {
            Position poll = positions.poll();
            if (poll.number >= board.length*board.length) return poll.count;
      //      if (poll.count >= board.length*board.length) return -1;
            for (int i = 1; i <= 6; i++) {
                int num = snakes.getOrDefault(poll.number + i, poll.number + i);
                Position position = new Position(num, poll.count + 1);
                if (!positions.contains(position)) {
                    positions.add(position);
                }
            }
        }
        return -1;
    }
     public class Position {
        int number;
        int count;

        public Position(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public boolean equals(Object obj) {
            Position position = (Position) obj;
            return this.number == position.number;
        }
    }
}