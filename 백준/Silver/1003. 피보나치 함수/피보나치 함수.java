import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        result = new int[41][2]; // 0과 1의 출력 횟수를 저장하는 배열
        result[0][0] = 1;
        result[1][1] = 1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            fibonacci(num);
            sb.append(result[num][0]).append(" ").append(result[num][1]).append("\n");
        }

        System.out.println(sb);
    }

    static void fibonacci(int num) {
        for (int i = 2; i <= num; i++) {
            if (result[i][0] == 0 && result[i][1] == 0) { // 아직 계산되지 않은 경우에만 수행
                result[i][0] = result[i - 1][0] + result[i - 2][0]; // 0의 출력 횟수
                result[i][1] = result[i - 1][1] + result[i - 2][1]; // 1의 출력 횟수
            }
        }
    }
}