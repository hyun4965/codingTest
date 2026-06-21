class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        while (true) {
            boolean changed = false;

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];

                if (num >= 50 && num % 2 == 0) {
                    arr[i] = num / 2;
                    changed = true;
                } else if (num < 50 && num % 2 == 1) {
                    arr[i] = num * 2 + 1;
                    changed = true;
                }
            }

            if (!changed) {
                break;
            }

            answer++;
        }

        return answer;
    }
}