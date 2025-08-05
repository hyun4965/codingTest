class Solution {
    public int solution(String[] order) {
        int total = 0;

        for (String menu : order) {
            if (menu.contains("americano") || menu.equals("anything")) {
                total += 4500;
            } else if (menu.contains("cafelatte")) {
                total += 5000;
            }
        }

        return total;
    }
}
