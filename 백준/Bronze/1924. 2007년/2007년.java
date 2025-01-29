import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final String[] WEEKS = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    static int month = 1, day = 1, weekIdx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        while (true) {
            if (month == x && day == y) {
                break;
            }

            day++;
            weekIdx = (weekIdx + 1) % 7;
            if (DAYS[month] < day) {
                month++;
                day = 1;
            }
        }

        System.out.println(WEEKS[weekIdx]);
    }
}