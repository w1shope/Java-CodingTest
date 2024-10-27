import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        Arrays.sort(arr);

        int answer = 0;
        int s = 0, e = N - 1;
        while (s < e) { // 같은 재료로 갑옷을 만들 수 없다.
            int sum = arr[s] + arr[e];
            if (sum == M) { // 갑옷을 만들 수 있다.
                answer++;
                s++;
            } else if (sum < M) {
                s++;
            } else {
                e--;
            }
        }

        System.out.println(answer);
    }
}