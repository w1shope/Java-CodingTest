import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static List<Integer> positiveNumbers = new ArrayList<>();
    private static List<Integer> negativeNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num >= 1)
                positiveNumbers.add(num);
            else
                negativeNumbers.add(num);
        }

        Collections.sort(positiveNumbers, Comparator.reverseOrder());
        Collections.sort(negativeNumbers);

        long sum = 0L;
        while (positiveNumbers.size() >= 2) {
            int num1 = positiveNumbers.remove(0);
            int num2 = positiveNumbers.remove(0);
            if (num1 == 1 || num2 == 1) {
                sum += num1;
                sum += num2;
            } else
                sum += num1 * num2;
        }
        if (!positiveNumbers.isEmpty())
            sum += positiveNumbers.get(0);

        while (negativeNumbers.size() >= 2) {
            int num1 = negativeNumbers.remove(0);
            int num2 = negativeNumbers.remove(0);
            if (num1 < 0 && num2 < 0)
                sum += num1 * num2;
        }
        if (!negativeNumbers.isEmpty())
            sum += negativeNumbers.get(0);

        System.out.println(sum);
    }
}