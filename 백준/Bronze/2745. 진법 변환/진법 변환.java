import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initMap();

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] N = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < N.length; i++) {
            sum += (int) Math.pow(B, N.length - i - 1) * map.get(N[i]);
        }
        System.out.println(sum);
    }

    static void initMap() {
        for (int i = 0; i <= 9; i++) {
            map.put((char) (i + '0'), i);
        }

        char c = 'A';
        for (int i = 0; i < 26; i++) {
            map.put((char) (c + i), 10 + i);
        }
    }

}