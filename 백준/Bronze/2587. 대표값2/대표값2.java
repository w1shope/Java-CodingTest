import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int val = Integer.parseInt(br.readLine());
            sum += val;
            list.add(val);
        }
        Collections.sort(list);

        System.out.println(sum / 5);
        System.out.println(list.get(2));
    }
}