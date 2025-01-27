import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static List<String> words = List.of(
            "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;
        while (true) {
            if (str.isBlank()) {
                break;
            }

            String croatia = null;
            for (String word : words) {
                if (str.startsWith(word)) {
                    croatia = word;
                    break;
                }
            }

            if (croatia == null) {
                str = str.substring(1);
            } else {
                str = str.substring(croatia.length());
            }
            count++;
        }

        System.out.println(count);
    }
}