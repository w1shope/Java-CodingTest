import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int original = Integer.parseInt(br.readLine());

        int count = 0;
        int num = original;

        while (true) {
            if (count > 0 && original == num) {
                break;
            }

            int a;
            int b;

            if (num >= 0 && num <= 9) {
                a = 0;
                b = num;
            } else {
                a = num / 10;
                b = num % 10;
            }

            int sum = a + b;
            num = b * 10 + (sum % 10);
            count++;
        }

        System.out.println(count);
    }
}