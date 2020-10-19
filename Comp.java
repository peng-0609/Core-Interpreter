
public class Comp {
    private Op op1;
    private Op op2;
    private int compOp;

    public Comp() {
        this.op1 = null;
        this.op2 = null;
        this.compOp = 0;
    }

    public void parse() throws ParseException {
        Parser.matchTerminalToken(TokenKind.L_PAREN);
        this.op1 = new Op();
        this.op1.parse();
        this.compOp = Parser.getCurrentTokenKind().testDriverTokenNumber();
        if (this.compOp < 25 || this.compOp > 30) {
            throw new ParseException("'!=', '==', '<', '>', '<=' or '>='");
        }
        Parser.moveToNextToken();//parse compOp
        this.op2 = new Op();
        this.op2.parse();
        Parser.matchTerminalToken(TokenKind.R_PAREN);
    }

    public void print() {
        System.out.print("(");
        this.op1.print();
        switch (this.compOp) {
            case 25:
                System.out.print(" != ");
                break;
            case 26:
                System.out.print(" == ");
                break;
            case 27:
                System.out.print(" < ");
                break;
            case 28:
                System.out.print(" > ");
                break;
            case 29:
                System.out.print(" <= ");
                break;
            case 30:
                System.out.print(" >= ");
                break;
        }
        this.op2.print();
        System.out.print(")");
    }

    public boolean exec() throws ExecutorException {
        boolean result = true;
        switch (this.compOp) {
            case 25:
                result = this.op1.exec() != this.op2.exec();
                break;
            case 26:
                result = this.op1.exec() == this.op2.exec();
                break;
            case 27:
                result = this.op1.exec() < this.op2.exec();
                break;
            case 28:
                result = this.op1.exec() > this.op2.exec();
                break;
            case 29:
                result = this.op1.exec() <= this.op2.exec();
                break;
            case 30:
                result = this.op1.exec() >= this.op2.exec();
                break;
        }
        return result;
    }
}
