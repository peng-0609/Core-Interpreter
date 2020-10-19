public class Exp {
    private Trm trm;
    private Exp exp;
    private int op;

    public Exp() {
        this.trm = null;
        this.exp = null;
        this.op = 0;
    }

    public void parse() throws ParseException {
        this.trm = new Trm();
        this.trm.parse();
        if (Parser.getCurrentTokenKind().testDriverTokenNumber() == 22) {
            this.op = 22;
            Parser.moveToNextToken();
            this.exp = new Exp();
            this.exp.parse();
        } else if (Parser.getCurrentTokenKind().testDriverTokenNumber() == 23) {
            this.op = 23;
            Parser.moveToNextToken();
            this.exp = new Exp();
            this.exp.parse();
        }

    }

    public void print() {
        this.trm.print();
        if (this.exp != null) {
            if (this.op == 22) {
                System.out.print(" + ");
            } else {
                System.out.print(" - ");
            }
            this.exp.print();
        }
    }

    public int exec() throws ExecutorException {
        int result = this.trm.exec();
        if (this.op == 22) {
            result += this.exp.exec();
        } else if (this.op == 23) {
            result -= this.exp.exec();
        }
        return result;
    }
}
