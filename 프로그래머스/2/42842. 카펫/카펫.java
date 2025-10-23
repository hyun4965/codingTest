class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; // 결과를 저장할 배열 선언
        int sum = brown + yellow; // 격자의 총 개수

        for (int i = 3; i < sum / 2; i++) {
            int row = i;
            int col = sum / row;
            
            if ((row - 2) * (col - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                break;
            } 
        }
    
        return answer;
    }
}
