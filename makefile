JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AssignStmt.java \
	Comp.java \
	Cond.java \
	Decl.java \
	DeclSeq.java\
	Exp.java \
	IdList.java \
	IfStmt.java \
	InStmt.java \
	LoopStmt.java \
	Op.java \
	OutStmt.java \
	Prog.java \
	Stmt.java \
	StmtSeq.java \
	Trm.java \
	Executor.java \
	Interpreter.java \
	Parser.java \
	Printer.java \
	Tokenizer.java \
	Tokenizer1.java \
	TokenKind.java \
	ExecutorException.java \
	ParseException.java
MAIN = Interpreter

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
