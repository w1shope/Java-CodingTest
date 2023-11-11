import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            nums.add(i);

        while (true) {
            sb.append(nums.remove(0) + " ");
            if (nums.size() <= 0)
                break;
            nums.add(nums.remove(0));
        }
        System.out.println(sb);
    }
}