import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputs[0];
        M = inputs[1];
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int[] result = answer();
        if (result[0] == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(result[0]);
            System.out.println(result[1]);
        }
    }

    static int[] answer() {
        int maxNumberCount = 0;
        int maxNum = 0;
        for (int i = 0; i < M; i++) {
            maxNum += arr[i];
        }
        maxNumberCount = 1;

        int s = 1;
        int e = M;
        int sum = maxNum;
        while (e < N) {
            sum = sum - arr[s - 1] + arr[e];
            if (sum == maxNum) {
                maxNumberCount++;
            } else {
                if (sum > maxNum) {
                    maxNum = sum;
                    maxNumberCount = 1;
                }
            }
            s++;
            e++;
        }
        return new int[]{maxNum, maxNumberCount};
    }
}