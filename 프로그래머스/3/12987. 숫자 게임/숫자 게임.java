import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int indexA = 0;
        int indexB = 0;

        while (indexA < A.length && indexB < B.length) {
            if (B[indexB] > A[indexA]) {
                answer++; 
                indexA++;  
                indexB++;
            } else {
                indexB++;  
            }
        }

        return answer;
    }
}
