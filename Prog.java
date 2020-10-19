/**
 * Non-Terminal class <prog>.
 */

public class Prog {
    private DeclSeq decl_seq;
    private StmtSeq stmt_seq;

    public Prog() {
        this.decl_seq = null;
        this.stmt_seq = null;
    }

    public void parse() throws ParseException {
        Parser.matchTerminalToken(TokenKind.PROGRAM);
        this.decl_seq = new DeclSeq();
        this.decl_seq.parse();
        Parser.matchTerminalToken(TokenKind.BEGIN);
        this.stmt_seq = new StmtSeq();
        this.stmt_seq.parse();
        Parser.matchTerminalToken(TokenKind.END);
        Parser.matchTerminalToken(TokenKind.EOF);
    }

    public void print() {
        System.out.print("program\n");
        Printer.space++;
        this.decl_seq.print();
        Printer.space--;
        System.out.print("begin\n");
        Printer.space++;
        this.stmt_seq.print();
        Printer.space--;
        System.out.print("end\n");
    }

    public void exec() throws ExecutorException {
        this.decl_seq.exec();
        this.stmt_seq.exec();
    }
}
