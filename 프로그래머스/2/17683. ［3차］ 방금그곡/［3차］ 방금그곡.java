class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = -1; 

        m = changeMelody(m);

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            
            int startMin = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endMin = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            int playTime = endMin - startMin;

            String sheet = changeMelody(info[3]);
            
            StringBuilder playedMelody = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                playedMelody.append(sheet.charAt(i % sheet.length()));
            }


            if (playedMelody.toString().contains(m)) {
                if (playTime > max) {
                    answer = info[2];
                    max = playTime;
                }
            }
        }

        return answer;
    }

    private String changeMelody(String melody) {
        return melody
            .replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a")
            .replace("B#", "b");
    }
}