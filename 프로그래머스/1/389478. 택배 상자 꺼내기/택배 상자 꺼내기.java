import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int height = n / w;
        if (n % w > 0) {
            height++;
        }

        int[][] arr = new int[height][w];
        for (int i = 0; i < height; i++) {
            Arrays.fill(arr[i], -1);
        }

        int boxNum = 1;
        int x = 0;
        int y = 0; 
        boolean isDir = true;

        while (boxNum <= n) {
            arr[x][y] = boxNum;

            if (isDir) { 
                if (y == w - 1) { 
                    x += 1;
                    isDir = !isDir; 
                } else {
                    y += 1;
                }
            } else { 
                if (y == 0) { 
                    x += 1;
                    isDir = !isDir; 
                } else {
                    y -= 1;
                }
            }

            boxNum += 1;
        }

        int targetRow = (num - 1) / w;
        int targetCol = -1;
        for (int col = 0; col < w; col++) {
            if (arr[targetRow][col] == num) {
                targetCol = col;
                break;
            }
        }

        int maxRow = height - 1; 
        int answer = 0;

        while (true) {
            if (arr[maxRow][targetCol] == num) {
                answer += 1;
                break;
            }

            if (arr[maxRow][targetCol] != -1) {
                answer += 1;
            }

            maxRow -= 1; 
        }

        return answer;
    }
}
