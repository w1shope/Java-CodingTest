import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int[] arr = new int[inputs.length - 1];
            for (int i = 1; i < inputs.length; i++) {
                arr[i - 1] = Integer.parseInt(inputs[i]);
            }

            long sum = 0L;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    sum += gcd(arr[i], arr[j]);
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}