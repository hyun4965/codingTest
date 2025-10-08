import java.util.*;

class Solution {

    static class Plan implements Comparable<Plan> {
        String name;
        int start;   // 시작 시각(분)
        int remain;  // 남은 소요시간(분)

        Plan(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.remain = playTime;
        }

        @Override
        public int compareTo(Plan o) {
            if (this.start != o.start) {
                return this.start - o.start;
            }
            return this.name.compareTo(o.name); 
        }
    }

    public String[] solution(String[][] plans) {
        int n = plans.length;

        List<Plan> list = new ArrayList<>(n);
        for (String[] p : plans) {
            String name = p[0];
            int start = toMinute(p[1]);
            int play  = Integer.parseInt(p[2]);
            list.add(new Plan(name, start, play));
        }
        Collections.sort(list);

        Deque<Plan> paused = new ArrayDeque<>(); 
        List<String> done = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            Plan cur = list.get(i);
            int curStart = cur.start;

            int nextStart;
            if (i + 1 < n) {
                nextStart = list.get(i + 1).start;
            } else {
                nextStart = Integer.MAX_VALUE; 
            }

            int available = nextStart - curStart;

            if (cur.remain <= available) {
                available -= cur.remain;
                done.add(cur.name);

                while (available > 0 && !paused.isEmpty()) {
                    Plan top = paused.pop();
                    if (top.remain <= available) {
                        available -= top.remain;
                        done.add(top.name);
                    } else {
                        top.remain -= available;
                        available = 0;
                        paused.push(top);
                    }
                }
            } else {
                cur.remain -= available;
                paused.push(cur);
            }
        }

        while (!paused.isEmpty()) {
            done.add(paused.pop().name);
        }

        return done.toArray(new String[0]);
    }

    private int toMinute(String hhmm) {
        String[] split = hhmm.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
