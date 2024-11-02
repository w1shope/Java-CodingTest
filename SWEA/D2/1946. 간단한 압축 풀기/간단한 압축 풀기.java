import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + "\n");

            int n = Integer.parseInt(br.readLine());
            int repeatCount = 0;
            for (int i = 0; i < n; i++) {
                String[] inputArr = br.readLine().split(" ");
                char alphabet = inputArr[0].charAt(0);
                int number = Integer.parseInt(inputArr[1]);

                for (int j = 0; j < number; j++) {
                    sb.append(alphabet);
                    repeatCount++;
                    if (repeatCount == 10) {
                        repeatCount = 0;
                        sb.append("\n");
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}