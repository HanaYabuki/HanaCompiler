import java.util.List;

public class Main {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
            String data = FileUtil.ins.read(s);
            List<LexToken> lexTokens = Lexer.ins.analyze(data);
            Lexer.ins.sout(lexTokens);
            FileUtil.ins.saveLex(s + ".analyzed.txt", lexTokens);
        }
    }
}
