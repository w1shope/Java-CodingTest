import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        long A = inputArr[0];
        long B = inputArr[1];

        recur(A, B, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer + 1);
        }
    }

    static void recur(long num, long B, int cnt) {
        if (num > B) { // 범위 초과
            return;
        }
        if (num == B) {
            answer = Math.min(answer, cnt);
            return;
        }

        recur(num * 2, B, cnt + 1); // 2를 곱한다
        recur(num * 10 + 1, B, cnt + 1); // 마지막 자리에 1 추가
    }
}