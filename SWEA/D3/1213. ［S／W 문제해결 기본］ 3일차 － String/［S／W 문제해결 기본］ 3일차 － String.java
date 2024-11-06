import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static String findStr;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int t = Integer.parseInt(br.readLine());
            findStr = br.readLine(); // 찾고자 하는 문자열
            str = br.readLine(); // 원본 문자열

            sb.append("#" + t + " " + answer() + "\n");
            if (t == 10) {
                break;
            }
        }

        System.out.println(sb);
    }

    static int answer() {
        int count = 0;
        while (str.indexOf(findStr) != -1) {
            int index = str.indexOf(findStr);
            count++;
            str = str.substring(index + 1);
        }
        return count;
    }
}