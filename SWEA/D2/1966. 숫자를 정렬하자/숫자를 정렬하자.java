import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            int n = Integer.parseInt(br.readLine());
            int[] numbers = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            Arrays.sort(numbers);

            for (int num : numbers) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}