import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int s = 1, e = 1, sum = 1, answer = 1;
        while (e < N) {
            if (sum == N) { // 정답 조건
                answer++;
                sum += ++e;
            } else if (sum < N) {
                sum += ++e;
            } else {
                sum -= s++;
            }
        }

        System.out.println(answer);
    }
}