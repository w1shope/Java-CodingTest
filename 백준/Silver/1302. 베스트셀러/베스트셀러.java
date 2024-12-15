import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Book> map = new HashMap<>(); // {책 이름, 인스턴스}
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                Book book = map.get(name);
                book.sellCount++;
            } else {
                map.put(name, new Book(name, 1));
            }
        }

        List<Book> books = new ArrayList<>(map.values());
        Collections.sort(books, (a, b) -> {
            if (a.sellCount == b.sellCount) {
                return a.name.compareTo(b.name);
            }
            return b.sellCount - a.sellCount;
        });

        System.out.println(books.get(0).name);

    }

    static class Book {
        String name;
        int sellCount;

        public Book(String name, int sellCount) {
            this.name = name;
            this.sellCount = sellCount;
        }
    }
}