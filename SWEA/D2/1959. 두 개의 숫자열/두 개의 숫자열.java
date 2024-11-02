import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int n = inputArr[0];
            int m = inputArr[1];

            int[] a = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int[] b = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            int[] moveArr;
            int[] stopArr;
            if (a.length < b.length) {
                moveArr = a;
                stopArr = b;
            } else {
                moveArr = b;
                stopArr = a;
            }

            int result = Integer.MIN_VALUE;
            for (int i = 0; i <= stopArr.length - moveArr.length; i++) {
                int tmp = 0;
                for (int j = 0; j < moveArr.length; j++) {
                    tmp += moveArr[j] * stopArr[i + j];
                }
                result = Math.max(result, tmp);
            }

            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}