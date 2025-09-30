import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static boolean[][] visited;
    static int rows, cols;

    public int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        visited = new boolean[rows][cols];
        
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int stay = bfs(i, j, maps);
                    list.add(stay);
                }
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(i -> i).toArray();
    }

    public int bfs(int x, int y, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        int currentStay = Character.getNumericValue(maps[x].charAt(y));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true; 
                        currentStay += Character.getNumericValue(maps[nx].charAt(ny)); 
                        queue.add(new int[]{nx, ny}); 
                    }
                }
            }
        }
        return currentStay;
    }
}