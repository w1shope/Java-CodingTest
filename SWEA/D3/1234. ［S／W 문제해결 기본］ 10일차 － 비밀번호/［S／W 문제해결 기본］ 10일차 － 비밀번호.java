import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            String[] inputArr = br.readLine().split(" ");
            sb.append("#" + t + " ").append(answer(inputArr[1]) + "\n");
        }

        System.out.println(sb);
    }

    static String answer(String str) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            result.add(str.charAt(i) - '0');
        }

        int idx = 0;
        while (true) {
            if (result.get(idx) == result.get(idx + 1)) {
                result.remove(idx);
                result.remove(idx);
                idx = 0;
            } else {
                idx++;
            }
            if (idx == result.size() - 1) {
                break;
            }
        }

        StringBuilder word = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            word.append(result.get(i));
        }
        return word.toString();
    }

}