
public class ParseException extends Exception {
    public ParseException(String expected) {
        super("\nPARSING ERROR: " + expected + " was expected, but got " + "'"
                + Tokenizer1.instance().tokenContent() + "'");
    }
}
