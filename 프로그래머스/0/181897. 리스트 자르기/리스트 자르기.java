import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        int[] result;

        switch (n) {
            case 1:
                result = Arrays.copyOfRange(num_list, 0, b + 1);
                break;
            case 2:
                result = Arrays.copyOfRange(num_list, a, num_list.length);
                break;
            case 3:
                result = Arrays.copyOfRange(num_list, a, b + 1);
                break;
            case 4:
                List<Integer> list = new ArrayList<>();
                for (int i = a; i <= b; i += c) {
                    list.add(num_list[i]);
                }
                result = list.stream().mapToInt(i -> i).toArray();
                break;
            default:
                result = new int[0]; 
        }

        return result;
    }
}
