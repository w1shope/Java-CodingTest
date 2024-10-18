import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        List<String> strings = new ArrayList<>();
        for (int second = 1; second < str.length() - 1; second++) {
            for (int third = second + 1; third < str.length(); third++) {
                String s1 = str.substring(0, second);
                String s2 = str.substring(second, third);
                String s3 = str.substring(third);
                strings.add(reverse(s1) + reverse(s2) + reverse(s3));
            }
        }

        Collections.sort(strings);
        System.out.println(strings.get(0));
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}