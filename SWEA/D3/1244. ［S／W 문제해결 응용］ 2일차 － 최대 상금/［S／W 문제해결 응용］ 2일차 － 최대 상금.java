import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {

    static int result;
    static Set<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            String[] inputArr = br.readLine().split(" ");
            String num = inputArr[0]; // 입력 숫자
            int maxChangeCount = Integer.parseInt(inputArr[1]); // 반드시 해야하는 교환 횟수

            result = 0;
            visited = new HashSet<>();

            dfs(num, 0, maxChangeCount);
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(String num, int changeCount, int maxChangeCount) {
        if (changeCount == maxChangeCount) { // 교환 횟수가 꽉찼다면
            result = Math.max(result, Integer.parseInt(num));
            return;
        }

        if (visited.contains(num)) {
            return;
        }

        visited.add(num);
        for (int i = 0; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                String swapStr = swap(num, i, j); // i <-> j 자리 바꾸기
                dfs(swapStr, changeCount + 1, maxChangeCount);
            }
        }
    }

    static String swap(String num, int idx1, int idx2) {
        char[] arr = num.toCharArray();
        char tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
        return new String(arr);
    }
}