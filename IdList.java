public class IdList {
    private String id;
    private IdList idList;

    public IdList() {
        this.id = "";
        this.idList = null;
    }

    public void parse() {
        this.id = Parser.getCurrentID();
        Parser.moveToNextToken();
        if (Parser.getCurrentTokenKind() == TokenKind.COMMA) {
            Parser.moveToNextToken();
            this.idList = new IdList();
            this.idList.parse();
        }
    }

    public void print() {
        System.out.print(this.id);
        if (this.idList != null) {
            System.out.print(",");
            this.idList.print();
        }

    }

    public void exec(TokenKind k) throws ExecutorException {
        if (k == TokenKind.READ) {
            Executor.addVariableValue(this.id, Executor.readValue());
            if (this.idList != null) {
                this.idList.exec(k);
            }
        } else if (k == TokenKind.WRITE) {
            System.out.println(this.id + " = " + Executor.getValue(this.id));
            if (this.idList != null) {
                this.idList.exec(k);
            }
        } else {//decl
            Executor.addVariableID(this.id);
            if (this.idList != null) {
                this.idList.exec(k);
            }
        }

    }
}
