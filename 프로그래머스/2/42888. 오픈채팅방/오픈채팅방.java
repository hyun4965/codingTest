import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        Map<String, String> nameByUid = new HashMap<>();
        
        for (String line : record) {
            String[] parts = line.split(" ");
            String cmd = parts[0];
            String uid = parts[1];
            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String nick = parts[2];
                nameByUid.put(uid, nick);
            }
        }

        List<String> out = new ArrayList<>();
        for (String line : record) {
            String[] parts = line.split(" ");
            String cmd = parts[0];
            String uid = parts[1];

            if (cmd.equals("Enter")) {
                out.add(nameByUid.get(uid) + "님이 들어왔습니다.");
            } else if (cmd.equals("Leave")) {
                out.add(nameByUid.get(uid) + "님이 나갔습니다.");
            }
        }

        return out.toArray(new String[0]);
    }
}
