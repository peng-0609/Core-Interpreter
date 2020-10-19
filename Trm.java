
public class Trm {
    private Op op;
    private Trm trm;

    public Trm() {
        this.op = null;
        this.trm = null;
    }

    public void parse() throws ParseException {
        this.op = new Op();
        this.op.parse();
        if (Parser.getCurrentTokenKind().testDriverTokenNumber() == 24) {
            Parser.moveToNextToken();//parse *
            this.trm = new Trm();
            this.trm.parse();
        }
    }

    public void print() {
        this.op.print();
        if (this.trm != null) {
            System.out.print(" * ");
            this.trm.print();
        }

    }

    public int exec() throws ExecutorException {
        int result = this.op.exec();
        if (this.trm != null) {
            result *= this.trm.exec();
        }
        return result;
    }
}
