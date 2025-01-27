import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        for (int i = 0; i < 3; i++) {
            sum *= Integer.parseInt(br.readLine());
        }

        int[] arr = new int[10];
        for (char c : (sum + "").toCharArray()) {
            arr[c - '0']++;
        }

        for (int num : arr) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);

    }
}