import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner in = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String next = in.nextLine();
                if (next.equals("")) {
                    List<LexToken> lexTokens = Lexer.ins.analyze(sb.toString());
                    Lexer.ins.sout(lexTokens);
                    FileUtil.ins.saveLex("tmp.analyze.txt", lexTokens);
                    return;
                }
                else {
                    sb.append(next);
                    sb.append('\n');
                }
            }
        }
        else for (String s : args) {
            System.out.println(s);
            String data = FileUtil.ins.read(s);
            List<LexToken> lexTokens = Lexer.ins.analyze(data);
            Lexer.ins.sout(lexTokens);
            FileUtil.ins.saveLex(s + ".analyzed.txt", lexTokens);
        }
    }
}
