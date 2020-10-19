
public class Printer {
    public static int space = 0;

    public static void blankGenerator() {
        String blank = "";
        for (int i = 0; i < space; i++) {
            blank += "  ";
        }
        System.out.print(blank);
    }
}
