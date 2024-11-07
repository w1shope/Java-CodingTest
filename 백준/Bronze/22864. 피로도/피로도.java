import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int A, B, C, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        A = inputs[0]; // 1시간마다 쌓이는 피로도
        B = inputs[1]; // 1시간마다 쌓이는 처리량
        C = inputs[2]; // 1시간마다 회복되는 피로도
        M = inputs[3]; // 피로도 최대량

        System.out.println(answer());
    }

    static int answer() {
        int fatigue = 0; // 피로도
        int passedHour = 0; // 지난 시간, 24시간 지나면 종료
        int throughput = 0; // 처리량

        while (passedHour < 24) {
            if (fatigue + A > M) { // 최대 피로도를 넘길 수 없다.
                fatigue -= C; // 휴식한다.
                if (fatigue < 0) {
                    fatigue = 0;
                }
            } else {
                fatigue += A;
                throughput += B;
            }
            passedHour++;
        }

        return throughput;
    }

}