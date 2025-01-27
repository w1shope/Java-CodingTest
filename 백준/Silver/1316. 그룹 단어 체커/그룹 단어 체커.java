import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 0;
        while (T-- > 0) {
            int[] arr = new int[26];
            boolean flag = false;

            char prev = ' ';
            for (char c : br.readLine().toCharArray()) {
                int idx = c - 'a';
                if (arr[idx] == 0) {
                    arr[idx]++;
                } else {
                    if (prev != c) {
                        flag = true;
                        break;
                    }
                }
                prev = c;
            }

            if (!flag) {
                count++;
            }
        }

        System.out.println(count);
    }

}