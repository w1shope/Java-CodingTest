import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> xSet = new HashSet<>();
        Set<String> ySet = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            String y = st.nextToken();

            if (xSet.contains(x)) {
                xSet.remove(x);
            } else {
                xSet.add(x);
            }

            if (ySet.contains(y)) {
                ySet.remove(y);
            } else {
                ySet.add(y);
            }
        }

        System.out.println(xSet.toArray()[0] + " " + ySet.toArray()[0]);
    }
}