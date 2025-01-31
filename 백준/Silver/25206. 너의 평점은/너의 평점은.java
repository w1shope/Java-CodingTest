import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0d;
        double pointSum = 0d;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double point = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) {
                continue;
            }

            sum += point * getPoint(grade);
            pointSum += point;
        }

        System.out.println(sum / pointSum);
    }

    static double getPoint(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
        }
        return 0.0;
    }

}