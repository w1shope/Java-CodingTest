import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static final String PREFIX_FOLDER = "FOLDER_";
    static final String PREFIX_FILE = "FILE_";

    static int N, M;
    static Map<String, ArrayList<String>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            String topFolder = PREFIX_FOLDER + st.nextToken();
            String fileOrFolder = st.nextToken();

            boolean isFolder = st.nextToken().equals("1");
            fileOrFolder = (isFolder ? PREFIX_FOLDER : PREFIX_FILE) + fileOrFolder;

            if (map.containsKey(topFolder)) {
                map.get(topFolder).add(fileOrFolder);
            } else {
                ArrayList<String> folder = new ArrayList<>();
                folder.add(fileOrFolder);
                map.put(topFolder, folder);
            }
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            String[] split = br.readLine().split("/");
            String folderName = PREFIX_FOLDER + split[split.length - 1];

            Set<String> files = new HashSet<>();
            int fileCount = getFileCount(folderName, files);
            sb.append(files.size()).append(" ").append(fileCount).append("\n");
        }

        System.out.println(sb);
    }

    static int getFileCount(String folderName, Set<String> fileAndFolders) {
        if (!map.containsKey(folderName)) {
            return 0;
        }

        int count = 0;
        for (String name : map.get(folderName)) {
            if (name.startsWith(PREFIX_FOLDER)) {
                count += getFileCount(name, fileAndFolders);
            } else {
                count++;
                fileAndFolders.add(name);
            }
        }

        return count;
    }
}