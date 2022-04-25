public class LexToken {
    int type;
    String word;

    public LexToken(int type, String word) {
        this.type = type;
        this.word = word;
    }

    public int getType() {
        return type;
    }

    public String getWord() {
        return word;
    }
}
