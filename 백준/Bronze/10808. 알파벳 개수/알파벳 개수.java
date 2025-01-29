import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (char c : br.readLine().toCharArray()) {
            arr[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int count : arr) {
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }
}