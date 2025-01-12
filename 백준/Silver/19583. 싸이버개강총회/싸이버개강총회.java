import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] times = br.readLine().split(" ");

        Set<String> enter = new HashSet<>();
        Set<String> answer = new HashSet<>();
        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }

            String time = input.split(" ")[0];
            String name = input.split(" ")[1];

            if (times[0].compareTo(time) >= 0) {
                enter.add(name);
                continue;
            }

            if (times[1].compareTo(time) > 0 || times[2].compareTo(time) < 0) {
                continue;
            }

            if (enter.contains(name)) {
                answer.add(name);
            }
        }

        System.out.print(answer.size());
    }
}