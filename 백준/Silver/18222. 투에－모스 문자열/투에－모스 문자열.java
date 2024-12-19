import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long k = Long.parseLong(br.readLine());
        System.out.println(recur(k - 1));
    }

    static int recur(long k) {
        if (k == 0) {
            return 0;
        } else if (k == 1) {
            return 1;
        } else if (k % 2 == 0) {
            return recur(k / 2);
        } else {
            return 1 - recur(k / 2);
        }
    }
}