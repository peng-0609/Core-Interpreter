
public class LoopStmt extends Stmt {
    private Cond cond;
    private StmtSeq stmt_seq;

    public LoopStmt() {
        this.cond = null;
        this.stmt_seq = null;
    }

    @Override
    public void parse() throws ParseException {
        Parser.moveToNextToken();//parse WHILE
        this.cond = new Cond();
        this.cond.parse();
        Parser.matchTerminalToken(TokenKind.LOOP);
        this.stmt_seq = new StmtSeq();
        this.stmt_seq.parse();
        Parser.matchTerminalToken(TokenKind.END);
        Parser.matchTerminalToken(TokenKind.SEMICOLON);
    }

    @Override
    public void print() {
        System.out.print("while ");
        Printer.space++;
        this.cond.print();
        Printer.space--;
        System.out.print(" loop\n");
        Printer.space++;
        this.stmt_seq.print();
        Printer.space--;
        Printer.blankGenerator();
        System.out.println("end;");

    }

    @Override
    public void exec() throws ExecutorException {
        while (this.cond.exec()) {
            this.stmt_seq.exec();
        }
    }
}
