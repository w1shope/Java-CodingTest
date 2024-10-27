import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] arr;
    static int X;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr); // 오름차순 정렬

        int s = 0, e = N - 1; // 투 포인터
        traverse(s, e);

        System.out.println(answer);
    }

    static void traverse(int s, int e) {
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum == X) {
                answer++;
                e--;
            }
            if (sum > X) {
                e--;
            }
            if (sum < X) {
                s++;
            }
        }
    }
}