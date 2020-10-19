
public class Parser {

    public static void matchTerminalToken(TokenKind k) throws ParseException {
        Tokenizer t = Tokenizer1.instance();
        if (t.getToken() != k) {
            throw new ParseException(k.toString());
        }
        t.skipToken();
    }

    public static TokenKind getCurrentTokenKind() {
        Tokenizer t = Tokenizer1.instance();
        return t.getToken();
    }

    public static void moveToNextToken() {
        Tokenizer t = Tokenizer1.instance();
        t.skipToken();
    }

    public static String getCurrentID() {
        Tokenizer t = Tokenizer1.instance();
        return t.idName();
    }

    public static int getCurrentInt() {
        Tokenizer t = Tokenizer1.instance();
        return t.intVal();
    }
}
