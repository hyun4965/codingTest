class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n + 1];

        for(int i = 1; i <= n; i++){
            student[i] = 1;
        }

        for(int i=0; i<lost.length; i++){
            student[lost[i]] -=1; 
        }


        for(int i=0; i<reserve.length; i++){
            student[reserve[i]] +=1;
        }
        


        for (int i = 1; i <= n; i++) {
            if (student[i] == 0) {
                
                if (i > 1 && student[i - 1] == 2) {
                    student[i - 1] -= 1; 
                    student[i] += 1;
                    continue; 
                }

                if (i < n && student[i + 1] == 2) {
                    student[i + 1] -= 1;
                    student[i] += 1;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (student[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}