package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ16198 {
    static int maxEnergy = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        List<Integer> energyBalls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            energyBalls.add(Integer.parseInt(input[i]));
        }

        collectEnergy(energyBalls, 0);
        System.out.println(maxEnergy);
    }

    static void collectEnergy(List<Integer> energyBalls, int sum) {
        if (energyBalls.size() == 2) {
            maxEnergy = Math.max(maxEnergy, sum);
            return;
        }

        for (int i = 1; i < energyBalls.size() - 1; i++) {
            int energy = energyBalls.get(i - 1) * energyBalls.get(i + 1);

            int removed = energyBalls.remove(i);
            collectEnergy(energyBalls, sum + energy);
            energyBalls.add(i, removed);
        }
    }
}
