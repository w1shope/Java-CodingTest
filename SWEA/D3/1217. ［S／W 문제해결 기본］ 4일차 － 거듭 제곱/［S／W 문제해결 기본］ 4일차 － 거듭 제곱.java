import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int result = 1;
            for (int i = 0; i < b; i++) {
                result *= a;
            }

            System.out.println("#" + t + " " + result);
        }
    }
}