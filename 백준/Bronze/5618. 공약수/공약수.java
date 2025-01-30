import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> nums = new ArrayList<>();
        while (st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        int gcd = nums.get(0);
        for (int i = 1; i < N; i++) {
            gcd = gcd(gcd, nums.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= gcd; i++) {
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if (nums.get(j) % i != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}