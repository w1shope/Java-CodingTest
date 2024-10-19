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
            String strNumber = String.valueOf(i);
            for (char c : strNumber.toCharArray()) {
                if (c - '0' == find) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}