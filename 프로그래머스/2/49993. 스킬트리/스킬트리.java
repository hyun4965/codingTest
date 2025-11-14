class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            int index = 0;  
            boolean possible = true;

            for (int j = 0; j < tree.length(); j++) {
                char c = tree.charAt(j);
                int pos = skill.indexOf(c);

                if (pos == -1) {
                    continue;
                }

                if (index < pos) {
                    possible = false;
                    break;
                } else if (index == pos) {
                    index++;
                }
            }

            if (possible) answer++;
        }

        return answer;
    }
}
