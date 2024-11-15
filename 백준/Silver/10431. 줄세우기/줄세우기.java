import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String[] inputs = br.readLine().split(" ");
            List<Integer> heights = new LinkedList<>();

            // 현재 첫 번재 사람의 키가 가장 크다
            heights.add(Integer.parseInt(inputs[1]));

            int walkCount = 0; // 이동 거리
            for (int i = 2; i < inputs.length; i++) {
                int height = Integer.parseInt(inputs[i]);
                int count = 0;
                for (int j = heights.size() - 1; j >= 0; j--) {
                    if (heights.get(j) > height) { // 자신의 키보다 다면
                        count++; // 한 칸 앞으로 이동한다.
                    }
                }
                walkCount += count;
                heights.add(heights.size() - count, height);
            }

            sb.append(t).append(" ").append(walkCount).append("\n");
        }

        System.out.println(sb);
    }
}