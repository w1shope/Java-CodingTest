import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        int sum = 0;
        for (char c : br.readLine().toCharArray()) {
            sum += arr[c - 'A'];
        }
        System.out.println(sum);
    }

    static void init() {
        String[] alphabets = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int number = 3;
        for (String alphabet : alphabets) {
            for (char c : alphabet.toCharArray()) {
                int idx = c - 'A';
                arr[idx] = number;
            }
            number++;
        }
    }
}