import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Character> dq = new ArrayDeque<>();
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '<') {
                while (!dq.isEmpty()) {
                    sb.append(dq.pollLast());
                }

                sb.append("<");
                for (int j = i + 1; j < arr.length; j++) {
                    sb.append(arr[j]);
                    if (arr[j] == '>') {
                        i = j;
                        break;
                    }
                }
            } else if (arr[i] == ' ') {
                while (!dq.isEmpty()) {
                    sb.append(dq.pollLast());
                }
                sb.append(arr[i]);
            } else {
                dq.offer(arr[i]);
            }
        }

        while (!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }

        System.out.print(sb);
    }
}