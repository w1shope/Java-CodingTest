import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            String input = br.readLine();
            sb.append(answer(input) + "\n");
        }

        System.out.println(sb);
    }

    static int answer(String input) {
        boolean isOdd = input.length() % 2 != 0; // 홀수인가?

        int midIdx = input.length() / 2;
        String first = input.substring(0, midIdx);

        if (isOdd) { // 홀수라면
            StringBuilder last = new StringBuilder(input.substring(midIdx + 1));
            return first.equals(last.reverse().toString()) ? 1 : 0;
        } else { // 짝수라면
            StringBuilder last = new StringBuilder(input.substring(midIdx));
            return first.equals(last.reverse().toString()) ? 1 : 0;
        }
    }

}