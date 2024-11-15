import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1 ~ 10,000
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; i * j <= n; j++) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}