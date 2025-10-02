import java.time.Duration;
import java.time.LocalTime;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;

        m = normalize(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String startTimeStr = parts[0];
            String endTimeStr = parts[1];
            String title = parts[2];
            String sheet = parts[3];

            LocalTime start = LocalTime.parse(startTimeStr);
            LocalTime end = LocalTime.parse(endTimeStr);
            int playTime = (int) Duration.between(start, end).toMinutes();

            sheet = normalize(sheet);
            int sheetLength = sheet.length();

            StringBuilder playedMelody = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                playedMelody.append(sheet.charAt(i % sheetLength));
            }

            if (playedMelody.toString().contains(m)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        return answer;
    }

    private String normalize(String melody) {
        return melody.replace("C#", "H")
                     .replace("D#", "I")
                     .replace("F#", "J")
                     .replace("G#", "K")
                     .replace("A#", "L")
                     .replace("E#", "F") 
                     .replace("B#", "C");
    }
}