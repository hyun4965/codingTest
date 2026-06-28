class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        boolean[] visited = new boolean[100001];

        for (int i = 0; i < k; i++) {
            answer[i] = -1;
        }

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (index == k) {
                break;
            }

            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                answer[index] = arr[i];
                index++;
            }
        }

        return answer;
    }
}