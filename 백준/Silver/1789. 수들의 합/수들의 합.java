import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        int count = 1;
        long cal = 1;
        while (true) {
            if (cal == s) {
                System.out.println(count);
                break;
            } else if (cal > s) {
                System.out.println(count - 1);
                break;
            }
            cal += ++count;
        }

    }

}