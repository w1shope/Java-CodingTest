import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int wordCount = Integer.parseInt(br.readLine());
            String[] words = new String[wordCount];
            for (int i = 0; i < wordCount; i++) {
                words[i] = br.readLine();
            }

            boolean flag = false;
            for (int i = 0; i < wordCount; i++) {
                if (flag) {
                    break;
                }
                for (int j = 0; j < wordCount; j++) {
                    if (i == j) {
                        continue;
                    }
                    String join = words[i] + words[j];
                    if (isPalindrome(join)) {
                        sb.append(join + "\n");
                        flag = true;
                        break;
                    }
                }
                if (i == wordCount - 1 && !flag) {
                    sb.append("0\n");
                }
            }
        }

        System.out.println(sb);
    }

    static boolean isPalindrome(String str) {
        boolean isOdd = isOdd(str);
        int midIdx = str.length() / 2;
        if (isOdd) {
            String prefix = str.substring(0, midIdx);
            String suffix = str.substring(midIdx + 1);
            if (prefix.equals(reverse(suffix))) {
                return true;
            }
        } else {
            String prefix = str.substring(0, midIdx);
            String suffix = str.substring(midIdx);
            if (prefix.equals(reverse(suffix))) {
                return true;
            }
        }
        return false;
    }

    static boolean isOdd(String str) {
        return str.length() % 2 != 0;
    }

    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}