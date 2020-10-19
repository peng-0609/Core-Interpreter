import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Executor {
    public static Map<String, Integer> variables = new HashMap<String, Integer>();
    public static List<Integer> inputVal = new LinkedList<Integer>();
    public static int index = 0;

    public static void execProg(Prog p) throws ExecutorException {
        p.exec();
    }

    public static void addVariableID(String id) {
        variables.put(id, null);
    }

    public static void addVariableValue(String id, int value) {
        variables.put(id, value);
    }

    public static void addInput(int input) {
        inputVal.add(input);
    }

    public static int getValue(String id) throws ExecutorException {
        if (variables.get(id) == null) {
            throw new ExecutorException(id + "is not initialized.");
        }
        return variables.get(id);
    }

    public static int readValue() {
        int value = inputVal.get(index);
        index++;
        return value;
    }
}
