import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        for (int x = 0; x < N - 1; x++) {
            if (arr[x] == 'E' && arr[x + 1] == 'W') {
                count++;
            }
        }

        System.out.println(count);
    }

}