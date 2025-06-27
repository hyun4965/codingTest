class Solution {
    public int solution(int num, int k) {
        String strNum = String.valueOf(num); // 정수 num을 문자열로 변환
        String strK = String.valueOf(k);     // k도 문자열로 변환

        int index = strNum.indexOf(strK);    // k가 처음 나타나는 위치를 찾음

        if (index == -1) {
            return -1; // k가 없다면 -1 반환
        } else {
            return index + 1; // 위치는 1부터 시작하므로 +1
        }
    }
}
