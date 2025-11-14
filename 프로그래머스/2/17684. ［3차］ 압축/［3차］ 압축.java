import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // 사전에 등록할 인덱스 초기화
        int idx = init(map);

        for (int i = 0; i < msg.length(); i++) {
            String word = "";

            while (i < msg.length() && map.containsKey(word + msg.charAt(i))) {
                word += msg.charAt(i);
                i++;
            }

            answer.add(map.get(word));

            if (i < msg.length()) {
                map.put(word + msg.charAt(i), idx);
                idx++; 
                i--; 
            }
        }

        return answer;
    }

    private int init(Map<String, Integer> map) {
        int idx = 1;

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(String.valueOf(ch), idx++);
        }

        return idx;
    }
}
