import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String find = sc.nextLine();

        int cnt = 0;
        while (true) {
            int idx = str.indexOf(find);
            if (idx == -1) {
                break;
            }
            cnt++;
            str = str.substring(idx + find.length());
        }

        System.out.println(cnt);
    }
}