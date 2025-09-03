import java.util.*;

class Solution {

    static class Song {
        int id;
        int plays;
        Song(int id, int plays) { this.id = id; this.plays = plays; }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 1) 장르별 총 재생수
        Map<String, Integer> totalByGenre = new HashMap<>();
        // 2) 장르 -> (해당 장르의 곡 목록)
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            totalByGenre.put(g, totalByGenre.getOrDefault(g, 0) + p);
            songsByGenre.computeIfAbsent(g, k -> new ArrayList<>())
                        .add(new Song(i, p));
        }

        // 3) 장르를 총 재생수 내림차순으로 정렬
        List<String> genreOrder = new ArrayList<>(totalByGenre.keySet());
        genreOrder.sort((a, b) -> totalByGenre.get(b) - totalByGenre.get(a));

        // 4) 각 장르 내에서 곡을 (재생수 내림차순, 고유번호 오름차순) 정렬 후 최대 2개 선택
        List<Integer> pick = new ArrayList<>();
        for (String g : genreOrder) {
            List<Song> list = songsByGenre.get(g);
            list.sort((s1, s2) -> {
                if (s1.plays != s2.plays) return s2.plays - s1.plays; // 재생수 내림차순
                return s1.id - s2.id;                                  // 번호 오름차순
            });

            // 최대 2곡 선택
            for (int i = 0; i < list.size() && i < 2; i++) {
                pick.add(list.get(i).id);
            }
        }

        // 5) 정답 배열로 변환
        int[] answer = new int[pick.size()];
        for (int i = 0; i < pick.size(); i++) answer[i] = pick.get(i);
        return answer;
    }
}
