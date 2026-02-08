import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer>[] gears = new LinkedList[5];
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 4; i++) {
            gears[i] = new LinkedList<>();
            String state = br.readLine();
            for (char c : state.toCharArray()) {
                gears[i].add(c - '0');
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
             
            int[] rotateInfo = new int[5];
            rotateInfo[gearNum] = direction;

            checkRight(gearNum, direction, rotateInfo);
            checkLeft(gearNum, direction, rotateInfo);

            for (int j = 1; j <= 4; j++) {
                if (rotateInfo[j] != 0) {
                    rotate(j, rotateInfo[j]);
                }
            }
        }

        int totalScore = 0;

        if (gears[1].peekFirst() == 1) {
            totalScore += 1;
        }
        if (gears[2].peekFirst() == 1) {
            totalScore += 2;
        }
        if (gears[3].peekFirst() == 1) {
            totalScore += 4;
        }
        if (gears[4].peekFirst() == 1) {
            totalScore += 8;
        }

        System.out.println(totalScore);
    }

    public static void rotate(int gearNum, int direction) {
        if (direction == 1) {
            gears[gearNum].addFirst(gears[gearNum].pollLast());
        } else {
            gears[gearNum].addLast(gears[gearNum].pollFirst());
        }
    }

    public static void checkRight(int gearNum, int direction, int[] rotateInfo) {
        if (gearNum >= 4) return;

        if (!gears[gearNum].get(2).equals(gears[gearNum+1].get(6))) {
            rotateInfo[gearNum + 1] = -direction;
            checkRight(gearNum + 1, -direction, rotateInfo);
        }
    }

    public static void checkLeft(int gearNum, int direction, int[] rotateInfo) {
        if (gearNum <= 1) return;

        if (!gears[gearNum].get(6).equals(gears[gearNum-1].get(2))) {
            rotateInfo[gearNum - 1] = -direction;
            checkLeft(gearNum - 1, -direction, rotateInfo);
        }
    }
}