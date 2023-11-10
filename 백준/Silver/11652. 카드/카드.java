import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<BigInteger, Integer> map = new HashMap<>(n);
        for (int i=0; i<n; i++){
            BigInteger b = new BigInteger(br.readLine());
            if (map.containsKey(b))
                map.put(b, map.get(b)+1);
            else map.put(b, 1);
        }
        System.out.print(map.entrySet()
                            .stream()
                            .sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                            .max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
                            .get()
                            .getKey()
        );
    }
}