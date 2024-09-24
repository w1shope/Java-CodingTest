import java.util.Scanner;

public class Main {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int cnt = 1;
        long number = 666;
        while (cnt != N) {
            number++;
            if (String.valueOf(number).contains("666")) {
                cnt++;
            }
        }

        System.out.println(number);
    }
}