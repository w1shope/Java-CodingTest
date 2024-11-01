import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static int[] calculated = new int[111];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            init();

            int num = Integer.parseInt(br.readLine());
            sb.append(calculated[num] + "\n");
        }

        System.out.println(sb);
    }

    static void init() {
        // 홀수는 더하고, 짝하는 뺀다
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) { // 짝수면
                calculated[i] = calculated[i - 1] - i;
            } else {
                calculated[i] = calculated[i - 1] + i;
            }
        }
    }

}