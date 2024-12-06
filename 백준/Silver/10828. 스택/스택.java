import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<String> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input.length == 2) { // "push"인 경우
                nums.add(input[1]);
            } else {
                if (input[0].equals("top")) {
                    sb.append(nums.isEmpty() ? "-1" : nums.get(nums.size() - 1));
                } else if (input[0].equals("empty")) {
                    sb.append(nums.isEmpty() ? "1" : 0);
                } else if (input[0].equals("size")) {
                    sb.append(nums.size());
                } else if (input[0].equals("pop")) {
                    if (nums.isEmpty()) {
                        sb.append("-1");
                    } else {
                        String popNum = nums.remove(nums.size() - 1);
                        sb.append(popNum);
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}