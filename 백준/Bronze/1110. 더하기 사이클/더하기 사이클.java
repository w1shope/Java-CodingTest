import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int original = Integer.parseInt(br.readLine());
        int num = original;
        int count = 0;

        while (true) {
            if (count > 0 && original == num) {
                break;
            }

            int front = num / 10;
            int back = num % 10;
            num = back * 10 + (front + back) % 10;
            count++;
        }

        System.out.println(count);
    }
}