public class Op {
    private String id;
    private int num;
    private Exp exp;

    public Op() {
        this.id = "";
        this.exp = null;
        this.num = 0;
    }

    public void parse() throws ParseException {
        //parse number
        if (Parser.getCurrentTokenKind() == TokenKind.INTEGER_CONSTANT) {
            this.num = Parser.getCurrentInt();
            Parser.moveToNextToken();
        }
        //parse id
        else if (Parser.getCurrentTokenKind() == TokenKind.IDENTIFIER) {
            this.id = Parser.getCurrentID();
            Parser.moveToNextToken();
        }
        // parse (<exp>)
        else if (Parser.getCurrentTokenKind() == TokenKind.L_PAREN) {
            Parser.moveToNextToken();//parse (
            this.exp = new Exp();
            this.exp.parse();
            Parser.matchTerminalToken(TokenKind.R_PAREN);
        } else {
            throw new ParseException("INTEGER_CONSTANT, IDENTIFIER or '('");
        }
    }

    public void print() {
        if (this.id.length() != 0) {
            System.out.print(this.id);
        } else if (this.exp == null) {
            System.out.print(this.num);
        } else {
            System.out.print("(");
            this.exp.print();
            System.out.print(")");
        }
    }

    public int exec() throws ExecutorException {
        int value = 0;
        if (this.id.length() != 0) {
            value = Executor.getValue(this.id);
        } else if (this.exp == null) {
            value = this.num;
        } else {
            value = this.exp.exec();
        }
        return value;
    }
}
