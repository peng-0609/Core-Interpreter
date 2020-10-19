
public class IfStmt extends Stmt {
    private Cond cond;
    private StmtSeq stmt_seq;
    private StmtSeq stmt_seq2;

    public IfStmt() {
        this.cond = null;
        this.stmt_seq = null;
        this.stmt_seq2 = null;
    }

    @Override
    public void parse() throws ParseException {
        Parser.moveToNextToken();//parse IF
        this.cond = new Cond();
        this.cond.parse();
        Parser.matchTerminalToken(TokenKind.THEN);
        this.stmt_seq = new StmtSeq();
        this.stmt_seq.parse();
        if (Parser.getCurrentTokenKind() == TokenKind.ELSE) {
            Parser.moveToNextToken();//parse ELSE
            this.stmt_seq2 = new StmtSeq();
            this.stmt_seq2.parse();
        }
        Parser.matchTerminalToken(TokenKind.END);
        Parser.matchTerminalToken(TokenKind.SEMICOLON);
    }

    @Override
    public void print() {
        System.out.print("if ");
        this.cond.print();
        System.out.print(" then\n");
        Printer.space++;
        this.stmt_seq.print();
        Printer.space--;
        if (this.stmt_seq2 != null) {
            Printer.blankGenerator();
            System.out.print("else\n");
            Printer.space++;
            this.stmt_seq2.print();
            Printer.space--;
        }
        Printer.blankGenerator();
        System.out.println("end;");
    }

    @Override
    public void exec() throws ExecutorException {
        if (this.cond.exec()) {
            this.stmt_seq.exec();
        } else {
            if (this.stmt_seq2 != null) {
                this.stmt_seq2.exec();
            }
        }

    }
}
