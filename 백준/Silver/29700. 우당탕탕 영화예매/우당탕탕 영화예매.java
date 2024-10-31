import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];
        K = inputArr[2];

        int answer = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int zeroCount = 0;
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == '1') {
                    if (zeroCount >= K) {
                        answer += 1 + (zeroCount - K);
                    }
                    zeroCount = 0;
                } else {
                    zeroCount++;
                    if (j == M - 1 && zeroCount >= K) {
                        answer += 1 + (zeroCount - K);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}