class Solution {
    public long solution(int k, int d) {
        long kk = k;
        long dd = d;
        long count = 0;

        for (long x = 0; x <= dd; x += kk) {
            long yMax = (long) Math.sqrt(dd*dd - x * x);
            count += (yMax / kk) + 1;
        }
        return count;
    }
}