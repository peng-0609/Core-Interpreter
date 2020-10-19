
public class Cond {
    private Cond cond1;
    private Comp cmpr;
    private Cond cond2;
    private int op;

    public Cond() {
        this.cond1 = null;
        this.cond2 = null;
        this.cmpr = null;
        this.op = 0;
    }

    public void parse() throws ParseException {
        if (Parser.getCurrentTokenKind() == TokenKind.L_BRACKET) {
            Parser.moveToNextToken();//parse [
            this.cond1 = new Cond();
            this.cond1.parse();
            this.op = Parser.getCurrentTokenKind().testDriverTokenNumber();
            this.cond2 = new Cond();
            this.cond2.parse();
            Parser.matchTerminalToken(TokenKind.R_BRACKET);
        } else if (Parser.getCurrentTokenKind() == TokenKind.NEGATION) {
            Parser.moveToNextToken();//parse !
            this.cond1 = new Cond();
            this.cond1.parse();
        } else if (Parser.getCurrentTokenKind() == TokenKind.L_PAREN) {
            this.cmpr = new Comp();
            this.cmpr.parse();
        } else {
            throw new ParseException("'(', '[' or '!'");
        }

    }

    public void print() {
        if (this.cond2 != null) {
            System.out.print("[");
            this.cond1.print();
            if (this.op == 18) {
                System.out.print(" && ");
            } else {
                System.out.print(" || ");
            }
            this.cond2.print();
            System.out.print("]");
        } else if (this.cond1 != null) {
            System.out.print("!");
            this.cond1.print();
        } else {
            this.cmpr.print();
        }
    }

    public boolean exec() throws ExecutorException {
        boolean result = true;
        if (this.cond1 == null) {
            result = this.cmpr.exec();
        } else if (this.cond2 == null) {
            result = !this.cond1.exec();
        } else {
            if (this.op == 18) {
                result = this.cond1.exec() && this.cond2.exec();
            }
            if (this.op == 19) {
                result = this.cond1.exec() || this.cond2.exec();
            }
        }
        return result;
    }
}
