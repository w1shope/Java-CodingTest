import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabets = new int[26];
        Arrays.fill(alphabets, -1);

        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - 'a';
            alphabets[idx] = alphabets[idx] == -1 ? i : alphabets[idx];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alphabets[i]).append(" ");
        }
        System.out.println(sb);
    }
}