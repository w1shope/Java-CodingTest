import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = 0;
        int modNum = 10;
        int numLength = 1;
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (i % modNum == 0) {
                numLength += 1;
                modNum *= 10;
            }
            length += numLength;
        }
        System.out.println(length);
    }
}