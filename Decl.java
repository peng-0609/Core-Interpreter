public class Decl {
    private IdList idList;

    public Decl() {
        this.idList = null;
    }

    public void parse() throws ParseException {
        Parser.matchTerminalToken(TokenKind.INT);
        this.idList = new IdList();
        this.idList.parse();
        Parser.matchTerminalToken(TokenKind.SEMICOLON);
    }

    public void print() {
        System.out.print("int ");
        this.idList.print();
        System.out.print(";\n");
    }

    public void exec() throws ExecutorException {
        this.idList.exec(TokenKind.INT);
    }

}
