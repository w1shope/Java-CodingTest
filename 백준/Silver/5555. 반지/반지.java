import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String findWord = br.readLine();
        int tc = Integer.parseInt(br.readLine());
        int result = 0;
        for (int t = 0; t < tc; t++) {
            String input = br.readLine();
            String rotateStr = input + input;
            if (rotateStr.contains(findWord)) {
                result++;
            }
        }

        System.out.println(result);
    }
}