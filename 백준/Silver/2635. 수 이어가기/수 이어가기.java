import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        List<Number> numbers = new ArrayList<>();
        for (int i = 1; i <= input; i++) {
            Number number = new Number();
            int prev = input;
            int now = i;
            number.addNumber(prev);
            number.addNumber(now);
            while (true) {
                int cal = prev - now;
                if (cal < 0) {
                    break;
                }
                number.addNumber(cal);
                prev = now;
                now = cal;
            }
            numbers.add(number);
        }

        Collections.sort(numbers);

        List<Integer> result = numbers.get(0).numbers;
        sb.append(result.size() + "\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + " ");
        }

        System.out.println(sb);
    }

    static class Number implements Comparable<Number> {
        List<Integer> numbers = new ArrayList<>();

        public void addNumber(int number) {
            numbers.add(number);
        }

        @Override
        public int compareTo(Number other) {
            return other.numbers.size() - this.numbers.size();
        }
    }
}