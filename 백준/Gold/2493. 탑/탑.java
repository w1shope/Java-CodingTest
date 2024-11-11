import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    static int N;
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int height = inputs[i]; // i번째 건물의 높이
            // 레이저를 쏘기 위해,
            // 현재 건물보다 낮은 건물을 제거
            while (!stack.isEmpty() && stack.peek()[1] < height) {
                stack.pop();
            }

            if (stack.isEmpty()) { // 현재 건물보다 높은 건물이 없다면
                sb.append("0 ");
            } else {
                sb.append(stack.peek()[0] + " ");
            }

            stack.push(new int[]{i + 1, height});
        }

        System.out.println(sb);
    }
}