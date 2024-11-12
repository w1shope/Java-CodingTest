import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            t = Integer.parseInt(br.readLine());
            String find = br.readLine();
            String input = br.readLine();
            sb.append("#" + t + " " + answer(input, find)).append("\n");
        }

        System.out.println(sb);
    }

    static int answer(String input, String find) {
        int answer = 0;
        while (true) {
            int idx = input.indexOf(find);
            if (idx == -1) {
                break;
            }

            answer++;
            input = input.substring(idx + find.length());
        }
        return answer;
    }

}