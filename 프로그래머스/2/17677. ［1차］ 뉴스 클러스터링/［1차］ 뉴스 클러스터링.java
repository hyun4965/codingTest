import java.util.*;

class Solution {
    static final int M = 65536;

    public int solution(String str1, String str2) {

        List<String> list1 = buildList(str1);
        List<String> list2 = buildList(str2);

        //공집합일 경우
        if (list1.isEmpty() && list2.isEmpty()) {
            return M;
        }

        int intersection = 0;


        List<String> copy = new ArrayList<>(list2);

        for (String s : list1) {
            if (copy.contains(s)) {
                intersection++;
                copy.remove(s); 
            }
        }

        int union = list1.size() + list2.size() - intersection;

        double jaccard = (double) intersection / union;
        return (int) (jaccard * M);
    }

    private List<String> buildList(String s) {
        List<String> result = new ArrayList<>();
        s = s.toUpperCase();

        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                result.add("" + c1 + c2);
            }
        }

        return result;
    }
}
