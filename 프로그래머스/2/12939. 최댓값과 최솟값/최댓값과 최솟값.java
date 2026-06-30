class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String value : str) {
            int num = Integer.parseInt(value);

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return min + " " + max;
    }
}