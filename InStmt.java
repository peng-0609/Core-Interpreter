
public class InStmt extends Stmt {
    private IdList idList;

    public InStmt() {
        this.idList = null;
    }

    @Override
    public void parse() throws ParseException {
        Parser.moveToNextToken();//parse READ
        this.idList = new IdList();
        this.idList.parse();
        Parser.matchTerminalToken(TokenKind.SEMICOLON);
    }

    @Override
    public void print() {
        System.out.print("read ");
        this.idList.print();
        System.out.println(";");

    }

    @Override
    public void exec() throws ExecutorException {
        this.idList.exec(TokenKind.READ);

    }
}
