import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {

    static int K; // 최대 교환 횟수
    static int answer = Integer.MIN_VALUE;
    static Set<Integer> visited; // 방문 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] inputs = br.readLine().split(" ");
            char[] arr = inputs[0].toCharArray();
            K = Integer.parseInt(inputs[1]);
            answer = 0;
            visited = new HashSet<>();

            dfs(arr, 0);
            sb.append("#" + t + " ").append(answer + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(char[] arr, int changeCount) {
        if (changeCount == K) {
            int money = charToInteger(arr);
            answer = Math.max(answer, money);
            return;
        }

        // 이미 자리 교체를 완료한 숫자는 다시 탐색 X
        if (visited.contains(charToInteger(arr))) {
            return;
        }
        visited.add(charToInteger(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                swap(arr, i, j);
                dfs(arr, changeCount + 1);
                swap(arr, j, i);
            }
        }
    }

    static int charToInteger(char[] arr) {
        return Integer.parseInt(new String(arr));
    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}