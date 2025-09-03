class Solution {
    int[] answer = new int[2]; // [0의 개수, 1의 개수]

    public int[] solution(int[][] arr) {
        recall(arr, 0, 0, arr.length);
        return answer;
    }

    private void recall(int[][] arr, int r, int c, int size) {
        if (isSame(arr, r, c, size)) {
            answer[arr[r][c]]++;
            return;
        }

        int newSize = size / 2;
        recall(arr, r, c, newSize); 
        recall(arr, r, c + newSize, newSize); 
        recall(arr, r + newSize, c, newSize); 
        recall(arr, r + newSize, c + newSize, newSize); 
    }

    private boolean isSame(int[][] arr, int r, int c, int size) {
        int value = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
