import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        Stack<Long> picked = new Stack<>();
        long currentSum = 0L;
        long pickedCnt = 0;

        for (long num = 1; num <= s; num++) {
            picked.push(num);
            currentSum += num;
            pickedCnt++;

            if (currentSum == s) {
                break;
            } else if (currentSum > s) {
                currentSum -= picked.pop();
                currentSum -= picked.pop();
                pickedCnt -= 2;
                num -= 1;
            }
        }

        System.out.println(pickedCnt);
    }
}