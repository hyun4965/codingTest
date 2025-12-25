import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double> gradePoint = new HashMap<>();
        gradePoint.put("A+", 4.5);
        gradePoint.put("A0", 4.0);
        gradePoint.put("B+", 3.5);
        gradePoint.put("B0", 3.0);
        gradePoint.put("C+", 2.5);
        gradePoint.put("C0", 2.0);
        gradePoint.put("D+", 1.5);
        gradePoint.put("D0", 1.0);
        gradePoint.put("F", 0.0);

        double sumCredit = 0.0;
        double sumScore = 0.0;

        for (int i = 0; i < 20; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            st.nextToken(); 
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue; 

            double gp = gradePoint.get(grade);
            sumCredit += credit;
            sumScore += credit * gp;
        }

        double result = sumScore / sumCredit;
        System.out.printf("%.6f\n", result);
    }
}
