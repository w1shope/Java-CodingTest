import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int suffleCount = Integer.parseInt(inputs[1]);

        int[] arr = new int[N + 1];
        inputs = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(inputs[i - 1]);
        }

        dArr = new int[N + 1];
        inputs = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            dArr[i] = Integer.parseInt(inputs[i - 1]);
        }

        while (suffleCount-- > 0) {
            int[] temp = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                temp[dArr[i]] = arr[i];
            }
            arr = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.print(sb);
    }
}