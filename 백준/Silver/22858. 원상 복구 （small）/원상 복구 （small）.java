import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] s = new int[n];
        for (int i = 0; i < n; i++)
            s[i] = Integer.parseInt(input[i]);

        input = br.readLine().split(" ");
        int[] d = new int[n];
        for (int i = 0; i < n; i++)
            d[i] = Integer.parseInt(input[i]) - 1;

        for (int i = 0; i < k; i++) {
            int[] newS = new int[n];
            for (int j = 0; j < n; j++) {
                newS[d[j]] = s[j];
            }
            s = newS;
        }

        for (int num : s)
            sb.append(num + " ");
        System.out.println(sb);
    }
}