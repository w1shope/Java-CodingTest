import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(answer(num));
    }

    static int answer(int num) {
        Queue<int[]> que = new LinkedList<>(); // {연산 횟수, 현재 값}
        que.offer(new int[]{0, num});
        while (!que.isEmpty()) {
            int[] poll = que.poll();
            if (poll[1] == 1) {
                return poll[0];
            }

            if (poll[1] % 3 == 0) {
                que.offer(new int[]{poll[0] + 1, poll[1] / 3});
            }
            if (poll[1] % 2 == 0) {
                que.offer(new int[]{poll[0] + 1, poll[1] / 2});
            }
            que.offer(new int[]{poll[0] + 1, poll[1] - 1});
        }
        return -1;
    }
}