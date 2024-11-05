import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    static int N, K;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            N = inputArr[0];
            K = inputArr[1];
            arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            answer = 0;
            dfs(0, 0);

            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int sum, int idx) {
        if (sum == K) { // 합이 K인 경우
            answer++;
            return;
        }
        if (idx == N) { // 배열 범위 벗어남
            return;
        }
        if (sum > K) { // 합 K를 벗어난 경우
            return;
        }

        // 현재 숫자를 뽑거나
        dfs(sum + arr[idx], idx + 1);
        // 뽑지 않거나
        dfs(sum, idx + 1);
    }

}