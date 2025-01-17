import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] arr;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        arr = new int[M];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 1; i < M - 1; i++) {
            int left = 0, right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }
            for (int j = i + 1; j < M; j++) {
                right = Math.max(right, arr[j]);
            }

            if (left > arr[i] && right > arr[i]) {
                sum += Math.min(left, right) - arr[i];
            }
        }

        System.out.println(sum);
    }

}