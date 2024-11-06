import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num = N; num <= M; num++) {
            if(num == 1) {
                continue;
            }
            if (isPrime(num)) {
                sum += num;
                min = Math.min(min, num);
            }
        }

        if (sum == 0) { // 소수 없음
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }


    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}