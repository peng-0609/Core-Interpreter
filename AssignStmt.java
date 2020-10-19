
public class AssignStmt extends Stmt {
    private String id;
    private Exp exp;

    public AssignStmt() {
        this.exp = null;
        this.id = "";
    }

    @Override
    public void parse() throws ParseException {
        this.id = Parser.getCurrentID();
        Parser.moveToNextToken();
        Parser.matchTerminalToken(TokenKind.ASSIGNMENT_OPERATOR);
        this.exp = new Exp();
        this.exp.parse();
        Parser.matchTerminalToken(TokenKind.SEMICOLON);
    }

    @Override
    public void print() {
        System.out.print(this.id + " = ");
        this.exp.print();
        System.out.print(";\n");

    }

    @Override
    public void exec() throws ExecutorException {
        int value = this.exp.exec();
        Executor.addVariableValue(this.id, value);
    }
}
