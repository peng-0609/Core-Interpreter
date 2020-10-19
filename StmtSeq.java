public class StmtSeq {
    private Stmt stmt;
    private StmtSeq stmt_seq;

    StmtSeq() {
        this.stmt = null;
        this.stmt_seq = null;
    }

    public void parse() throws ParseException {
        this.stmt = new Stmt();
        this.stmt.parse();
        TokenKind current = Parser.getCurrentTokenKind();
        if (current == TokenKind.IDENTIFIER || current == TokenKind.IF
                || current == TokenKind.WHILE || current == TokenKind.READ
                || current == TokenKind.WRITE) {
            this.stmt_seq = new StmtSeq();
            this.stmt_seq.parse();
        }
    }

    public void print() {

        Printer.blankGenerator();
        this.stmt.print();
        if (this.stmt_seq != null) {
            this.stmt_seq.print();
        }

    }

    public void exec() throws ExecutorException {
        this.stmt.exec();
        if (this.stmt_seq != null) {
            this.stmt_seq.exec();
        }
    }
}
