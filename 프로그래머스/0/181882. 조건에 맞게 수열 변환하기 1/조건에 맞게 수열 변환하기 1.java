class Solution {
    public int[] solution(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            
            if (value >= 50 && value % 2 == 0) {
                arr[i] = value / 2;
            }
            else if (value < 50 && value % 2 == 1) {
                arr[i] = value * 2;
            }
        }

        return arr;
    }
}
