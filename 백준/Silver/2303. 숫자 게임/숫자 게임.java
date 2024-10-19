import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        int[] result = new int[tc];
        for (int t = 0; t < tc; t++) {
            String[] split = br.readLine().split(" ");
            int[] numbers = Arrays.stream(split)
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int bigLastNumber = 0;
            for (int i = 0; i < numbers.length - 2; i++) {
                for (int j = i + 1; j < numbers.length - 1; j++) {
                    for (int k = j + 1; k < numbers.length; k++) {
                        int number = numbers[i] + numbers[j] + numbers[k];
                        int lastNumber = number %  10;
                        if(lastNumber > bigLastNumber) {
                            bigLastNumber = lastNumber;
                        }
                    }
                }
            }
            result[t] = bigLastNumber;
        }

        int personNumber = 1;
        int bigNumber = result[0];
        for (int i = 1; i < result.length; i++) {
            if (result[i] >= bigNumber) {
                personNumber = i + 1;
                bigNumber = result[i];
            }
        }

        System.out.println(personNumber);
    }
}