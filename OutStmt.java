
public class OutStmt extends Stmt {
    private IdList idlist;

    public OutStmt() {
        this.idlist = null;
    }

    @Override
    public void parse() throws ParseException {
        Parser.moveToNextToken();//parse WRITE
        this.idlist = new IdList();
        this.idlist.parse();
        Parser.matchTerminalToken(TokenKind.SEMICOLON);
    }

    @Override
    public void print() {
        System.out.print("write ");
        this.idlist.print();
        System.out.println(";");

    }

    @Override
    public void exec() throws ExecutorException {
        this.idlist.exec(TokenKind.WRITE);
    }
}
