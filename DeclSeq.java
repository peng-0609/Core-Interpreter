
public class DeclSeq {
    private Decl decl;
    private DeclSeq decl_seq;

    public DeclSeq() {
        this.decl = null;
        this.decl_seq = null;
    }

    public void parse() throws ParseException {
        this.decl = new Decl();
        this.decl.parse();
        if (Parser.getCurrentTokenKind() != TokenKind.BEGIN) {
            this.decl_seq = new DeclSeq();
            this.decl_seq.parse();
        }
    }

    public void print() {
        Printer.blankGenerator();
        this.decl.print();
        if (this.decl_seq != null) {
            this.decl_seq.print();
        }
    }

    public void exec() throws ExecutorException {
        this.decl.exec();
        if (this.decl_seq != null) {
            this.decl_seq.exec();
        }
    }
}
