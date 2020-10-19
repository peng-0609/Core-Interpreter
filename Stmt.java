
public class Stmt {
    private Stmt child;

    Stmt() {
        this.child = null;
    }

    public void parse() throws ParseException {
        TokenKind current = Parser.getCurrentTokenKind();
        if (current == TokenKind.IDENTIFIER) {
            this.child = new AssignStmt();
            this.child.parse();
        } else if (current == TokenKind.IF) {
            this.child = new IfStmt();
            this.child.parse();
        } else if (current == TokenKind.WHILE) {
            this.child = new LoopStmt();
            this.child.parse();
        } else if (current == TokenKind.READ) {
            this.child = new InStmt();
            this.child.parse();
        } else if (current == TokenKind.WRITE) {
            this.child = new OutStmt();
            this.child.parse();
        }
    }

    public void print() {
        this.child.print();
    }

    public void exec() throws ExecutorException {
        this.child.exec();
    }
}
