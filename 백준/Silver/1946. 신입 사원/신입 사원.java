import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            int highestRank1 = 1000000;
            int highestRank2 = 1000000;
            List<Pair> persons = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                persons.add(new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }
            Collections.sort(persons, (p1, p2) -> p1.rank1 - p2.rank1);
            for (int j = 0; j < n; j++) {
                Pair pair = persons.get(j);
                if (pair.rank1 < highestRank1 || pair.rank2 < highestRank2) {
                    count++;
                    if (pair.rank1 < highestRank1)
                        highestRank1 = pair.rank1;
                    if (pair.rank2 < highestRank2)
                        highestRank2 = pair.rank2;
                    ;
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}

class Pair {
    int rank1;
    int rank2;

    public Pair(int rank1, int rank2) {
        this.rank1 = rank1;
        this.rank2 = rank2;
    }
}