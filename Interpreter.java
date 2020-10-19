import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Interpreter {

    public static void main(String[] args) {
        if (args.length != 3
                || !(args[2].equals("print") || args[2].equals("doNotPrint"))) {
            System.err.println(
                    "Error: invalid number of inputs OR incrorect printing method.");
            System.exit(0);
        }
        Scanner in;
        BufferedReader inputData;
        boolean print = args[2].equals("print");
        try {
            in = new Scanner(Paths.get(args[0]));
            inputData = new BufferedReader(new FileReader(args[1]));
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
            return;
        }
        Tokenizer1.create(in);
        //read input data
        String str;
        try {
            while ((str = inputData.readLine()) != null) {
                String[] inputTokens = str.split("\\s+");
                for (int i = 0; i < inputTokens.length; i++) {
                    Executor.addInput(Integer.parseInt(inputTokens[i]));
                }
            }
        } catch (IOException e1) {
            System.err.println(e1.getMessage());
            e1.printStackTrace();
            return;
        }
        Prog program = new Prog();
        try {
            program.parse();
            if (print) {
                program.print();
            }
            program.exec();
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            //e.printStackTrace();
            System.exit(0);
        } catch (ExecutorException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }

        /*
         * Close input stream
         */

        try {
            in.close();
            inputData.close();
        } catch (IOException e) {
            System.err.println("Error closing file: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }

    public static boolean isInt(String s) {
        boolean isInt = false;
        try {
            Integer.parseInt(s);
            isInt = true;
        } catch (NumberFormatException e) {

        }
        return isInt;
    }

}
