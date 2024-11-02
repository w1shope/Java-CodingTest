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
            int p = inputArr[0]; // A : 1리터당 비용
            int q = inputArr[1]; // B : 기본 요금
            int r = inputArr[2]; // B : R 리터까지 무료
            int s = inputArr[3]; // B : R 리터 초과 시, 1리터당 비용
            int w = inputArr[4]; // 사용한 수도 양

            int costWaterA = p * w;
            int costWaterB = q;
            if (w > r) { // 기본 제공 초과
                for (int i = r + 1; i <= w; i++) {
                    costWaterB += s;
                }
            }

            sb.append(Math.min(costWaterA, costWaterB) + "\n");
        }
        System.out.println(sb);
    }
}