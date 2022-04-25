import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    static final String[] regexList = new String[] {
            "^((if)|(int)|(while)|(for)|(do)|(return)|(break)|(continue))",
            "^([a-zA-Z]+)",
            "^([0-9]+)",
            "^(=)",
            "^(([+\\-*/(),;{}])|(>=)|(<=)|(!=)|([<>]))"
    };
    static final Pattern spacePattern = Pattern.compile("^ +");
    static final Pattern commentPattern = Pattern.compile("^//.*\n");
    static final Pattern[] patterns = new Pattern[regexList.length];
    public static Lexer ins = new Lexer();

    private Lexer() {
        for (int i=0; i< regexList.length; ++i) {
            patterns[i] = Pattern.compile(regexList[i]);
        }
    }

    public List<LexToken> analyze(String str) {
        str = str + "\n";
        List<LexToken> ret = new ArrayList<>();
        while (str.length() > 0) {
            Matcher matcherSpace = spacePattern.matcher(str);
            if (matcherSpace.find()) {
                str = str.substring(matcherSpace.group(0).length());
            }

            Matcher matcherComment = commentPattern.matcher(str);
            if (matcherComment.find()) {
                str = str.substring(matcherComment.group(0).length());
            }

            boolean flag = false;
            for (int i=0; i<patterns.length; ++i) {
                Matcher matcher = patterns[i].matcher(str);
                if (matcher.find()) {
                    ret.add(new LexToken(i + 1, matcher.group(0)));
                    str = str.substring(matcher.group(0).length());
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return ret;
    }

    public void sout(List<LexToken> list) {
        for (LexToken item : list) {
            System.out.printf("(%d, \t`%s`)%n", item.type, item.word);
        }
    }
}
