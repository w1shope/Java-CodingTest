import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];
        for (char c : br.readLine().toLowerCase().toCharArray()) {
            arr[c - 'a']++;
        }

        int idx = 0;
        int count = arr[0];
        boolean isDuplicate = false;

        for (int i = 1; i < 26; i++) {
            if (arr[i] > count) {
                idx = i;
                count = arr[i];
                isDuplicate = false;
            } else if (arr[i] == count) {
                isDuplicate = true;
            }
        }

        if (isDuplicate) {
            System.out.println("?");
        } else {
            System.out.println((char) Character.toUpperCase(idx + 'a'));
        }
    }
}