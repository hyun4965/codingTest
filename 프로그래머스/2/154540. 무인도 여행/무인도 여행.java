import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    boolean[][] visited;
    int rows, cols;

    public int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        visited = new boolean[rows][cols];
        
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = maps[i].charAt(j);
                
                if (c != 'X' && !visited[i][j]) {
                    int sum = bfs(i, j, maps);
                    resultList.add(sum);
                }
            }
        }

        if (resultList.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(resultList);

        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }

    public int bfs(int startRow, int startCol, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int sum = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            sum += maps[row].charAt(col) - '0';

            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols) {
                    if (!visited[nr][nc] && maps[nr].charAt(nc) != 'X') {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return sum;
    }

}