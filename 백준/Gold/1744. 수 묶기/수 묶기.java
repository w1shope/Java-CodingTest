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

        // 양수를 갖는 list는 내림차순 정렬
        Collections.sort(positiveNumbers, Comparator.reverseOrder());
        // 음수 갖는 list는 오름차순 정렬
        Collections.sort(negativeNumbers);

        long sum = 0L;
        while (positiveNumbers.size() >= 2) {
            int num1 = positiveNumbers.remove(0);
            int num2 = positiveNumbers.remove(0);
            sum += calculatePositiveNum(num1, num2);
        }
        if (!positiveNumbers.isEmpty())
            sum += calculatePositiveNum(positiveNumbers.get(0));

        while (negativeNumbers.size() >= 2) {
            int num1 = negativeNumbers.remove(0);
            int num2 = negativeNumbers.remove(0);
            sum += calculateNegativeNum(num1, num2);
        }
        if (!negativeNumbers.isEmpty())
            sum += calculateNegativeNum(negativeNumbers.get(0));

        System.out.println(sum);
    }

    // 양수인 경우
    private static int calculatePositiveNum(int... args) {
        if (args.length >= 2) {
            if (args[0] == 1 || args[1] == 1) {
                return args[0] + args[1];
            } else
                return args[0] * args[1];
        } else {
            return args[0];
        }
    }

    // 음수인 경우
    private static int calculateNegativeNum(int... args) {
        if (args.length >= 2) {
            if (args[0] < 0 && args[1] < 0)
                return args[0] * args[1];
            else
                return 0;
        } else {
            return args[0];
        }
    }
}
