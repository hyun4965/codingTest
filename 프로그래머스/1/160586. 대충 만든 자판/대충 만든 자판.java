class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) {
            for(char c : targets[i].toCharArray()) {
                int press = Integer.MAX_VALUE;
                for(String k : keymap) {
                    for(int j = 0; j < k.length(); j++) {
                        if(c == k.charAt(j)) {
                            press = Math.min(press, j);
                            break;
                        }
                    }
                }
                if(press == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                }
                else answer[i] += press + 1;
            }
        }
        return answer;
    }
}