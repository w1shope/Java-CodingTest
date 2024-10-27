import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        if (N == 1) {
            if (arr[0] == M) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        int s = 0, e = 0, sum = 0, answer = 0;
        while (e < N) {
            sum += arr[e++];

            while (sum > M) {
                sum -= arr[s++];
            }

            if (sum == M) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}