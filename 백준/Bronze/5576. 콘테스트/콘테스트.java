import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> w = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            w.add(Integer.parseInt(br.readLine()));
        List<Integer> h = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            h.add(Integer.parseInt(br.readLine()));

        Collections.sort(w);
        Collections.sort(h);

        System.out.print(w.get(9) + w.get(8) + w.get(7) + " ");
        System.out.println(h.get(9) + h.get(8) + h.get(7));
    }
}