import java.io.*;
import java.util.List;

public class FileUtil {
    public static FileUtil ins = new FileUtil();
    private FileUtil() {}

    public String read(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String str;
            StringBuilder sb = new StringBuilder();
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void saveLex(String filename, List<LexToken> list) {
        StringBuilder sb = new StringBuilder();
        for (LexToken lk : list) {
            sb.append(
                    String.format("(%d, `%s`)", lk.type, lk.word)
            );
            sb.append('\n');
        }
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            out.write(sb.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
