class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> metricsMap = new HashMap<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(!Character.isDigit(board[i][j])) continue;
                int value = board[i][j] - '0';
                Set<Integer> row = rowMap.getOrDefault(i, new HashSet<>());
                Set<Integer> col = colMap.getOrDefault(j, new HashSet<>());
                int metricsKey = (i/3) * 10 + (j/3);
                Set<Integer> metrics = metricsMap.getOrDefault(metricsKey, new HashSet<>());
                if(row.contains(value)) return false;
                if(col.contains(value)) return false;
                if(metrics.contains(value)) return false;
                row.add(value);
                rowMap.put(i, row);
                col.add(value);
                colMap.put(j, col);
                metrics.add(value);
                metricsMap.put(metricsKey, metrics);
            }
        }
        return true;
    }
}