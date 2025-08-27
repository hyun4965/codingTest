package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> colors = new ArrayList<>(Arrays.asList(
                "black", "brown", "red", "orange", "yellow",
                "green", "blue", "violet", "grey", "white"
        ));

        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();

        long value1 = colors.indexOf(color1);

        long value2 = colors.indexOf(color2);

        long multiplier = (long) Math.pow(10, colors.indexOf(color3));

        long finalResistance = (value1 * 10 + value2) * multiplier;

        System.out.println(finalResistance);
    }
}
