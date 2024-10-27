import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int now = arr[i];
            int containsNumberCount = 0;
            for (int j = now; j <= now + 4; j++) {
                if (isContain(arr, j)) {
                    containsNumberCount++;
                }
            }
            answer = Math.min(answer, 5 - containsNumberCount);
        }

        System.out.println(answer);
    }

    static boolean isContain(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
}