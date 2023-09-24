import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] persons = new Integer[n];
        for (int i = 0; i < n; i++)
            persons[i] = Integer.parseInt(br.readLine());

        Arrays.sort(persons, (num1, num2) -> num2 - num1);

        long sum = 0;
        for (int i = 0; i < n; i++)
            sum += getMoney(persons, i);

        System.out.println(sum);
    }

    private static long getMoney(Integer[] persons, int order) {
        long tip = persons[order] - ((order + 1) - 1);
        if (tip < 0)
            return 0;
        return tip;
    }
}