import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();

        int count = 0;
        char prev = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] == 'W' && prev == 'E') {
                count++;
            }
            prev = arr[i];
        }

        System.out.println(count);
    }
}