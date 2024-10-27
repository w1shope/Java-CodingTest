import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        K = inputArr[1] - 1;
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        Arrays.sort(arr); // 오름차순 정렬

        long answer = 0;
        answer += arr[N - 1]; // 가장 먼저 마시는 포도주으 맛은 본연의 맛임

        int s = 0, e = N - 2;
        boolean flag = false; // false : 가장 약한 맛, true : 가장 강한맛
        long prev = -1;
        while (K > 0) { // K 종류의 포도주를 다 마시면 종료
            if (!flag) { // 가장 약한 맛을 먹는다.
                prev = arr[s++];
            } else { // 가장 강한 맛을 먹는다.
                long diff = arr[e--] - prev; // 두 맛의 차이
                answer += diff;
                prev = -1;
            }
            K--;
            flag = !flag;
        }

        System.out.println(answer);
    }
}