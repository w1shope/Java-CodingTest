import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");

        int result = 0;
        int n = Integer.parseInt(split[0]);
        int find = Integer.parseInt(split[1]);

        for (int i = 1; i <= n; i++) {
            int number = i;
            while (number != 0) {
                int div = number % 10;
                if (div == find) {
                    result++;
                }
                number /= 10;
            }
        }

        System.out.println(result);
    }
}