class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int currentPosition = 1; 
        int stationIndex = 0;
        
        int coverageRange = 2 * w + 1;

        while (currentPosition <= n) {

            if (stationIndex < stations.length && stations[stationIndex] - w <= currentPosition) {
                currentPosition = stations[stationIndex] + w + 1;
                stationIndex++; 
            } else {
                answer++;
                currentPosition += coverageRange;
            }
        }

        return answer;
    }
}