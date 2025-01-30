import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, C, M;
    static int work;
    static int fatigue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int time = 1; time <= 24; time++) {
            if (fatigue + A > M) {
                fatigue -= C;
                if (fatigue < 0) {
                    fatigue = 0;
                }
            } else {
                fatigue += A;
                work += B;
            }
        }

        System.out.println(work);
    }
}