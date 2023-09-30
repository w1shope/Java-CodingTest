import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<String> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++)
            words.add(input.substring(i, input.length()));

        words.stream().sorted().forEach(word -> sb.append(word + "\n"));
        System.out.println(sb);
    }
}