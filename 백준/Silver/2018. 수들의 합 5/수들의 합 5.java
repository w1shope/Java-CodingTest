import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N == 1) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        int s = 0, e = 1; // 투 포인터
        int answer = 0;
        int sum = arr[s] + arr[e];
        while (s <= e && e < N) {
            if (sum == N) { // 정답
                answer++;
                sum -= arr[s++];
                if (e < N - 1) {
                    sum += arr[++e];
                }
            } else if (sum > N) { // 연속된 배열의 합이 더 크다면
                sum -= arr[s++];
            } else {
                if (e < N - 1) {
                    sum += arr[++e];
                }
            }
        }

        System.out.println(answer);
    }
}