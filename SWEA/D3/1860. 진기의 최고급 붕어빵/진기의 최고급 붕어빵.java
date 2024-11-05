import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    static int N, M, K;
    static int maxArrivedSecond = 11_111;
    static int[] seconds;

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
            M = inputArr[1];
            K = inputArr[2];

            seconds = new int[maxArrivedSecond + 1]; // 0 <= K <= 11_111
            inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            for (int i = 0; i < N; i++) {
                seconds[inputArr[i]]++; // inputArr[i] 시간에 오는 사람 1명 추가
            }

            sb.append(answer() ? "Possible" : "Impossible").append("\n");
        }

        System.out.println(sb);
    }

    static boolean answer() {
        int makedFish = 0; //만들어진 붕어빵 개수

        // passedSecond : 지나간 시간
        for (int passedSecond = 0; passedSecond <= maxArrivedSecond; passedSecond++) {
            if (passedSecond > 0 && passedSecond % M == 0) { // M초의 시간이 지나면 K개의 붕어빵을 만든다.
                makedFish += K;
            }

            if (seconds[passedSecond] > 0) { // 현재 시간에 도착한 사람이 1명 이상이라면
                if (makedFish < seconds[passedSecond]) { // 현재 시간에 도착한 사람보다 만들어진 붕어빵 개수가 적다면 종료
                    return false;
                }
                makedFish -= seconds[passedSecond];
            }
        }

        return true;
    }
}