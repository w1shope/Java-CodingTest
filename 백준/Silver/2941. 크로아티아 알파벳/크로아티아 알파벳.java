import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final List<String> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        init();

        int count = 0;
        while (input.length() > 0) {
            boolean isChange = false;
            for (int i = 0; i < words.size(); i++) {
                int length = words.get(i).length();
                if (input.length() >= length && input.substring(0, length).equals(words.get(i))) {
                    input = input.substring(length);
                    isChange = true;
                    break;
                }
            }
            if (!isChange)
                input = input.substring(1);
            count++;
        }
        System.out.println(count);
    }

    static void init() {
        words.add("c=");
        words.add("c-");
        words.add("dz=");
        words.add("d-");
        words.add("lj");
        words.add("nj");
        words.add("s=");
        words.add("z=");
    }
}