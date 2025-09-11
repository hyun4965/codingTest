class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int n = sequence.length;
        int bestL = 0;
        int bestR = n - 1;
        long sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += sequence[right];

            while (sum >= k && left <= right) {
                if (sum == k) {
                    if ((right - left) < (bestR - bestL) || ((right - left) == (bestR - bestL) && left < bestL)) 
                    {
                        bestL = left;
                        bestR = right;
                    }
                }
                sum -= sequence[left++];
            }
        }

        answer[0] = bestL;
        answer[1] = bestR;
        return answer;
    }
}
