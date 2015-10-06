package helpers;

public class Printer {
    public static void print(Object o) {
        System.out.print(o);
    }

    public static void println() {
        print(lineSeparator());
    }

    public static void println(Object o) {
        print(o);
        println();
    }

    private static String lineSeparator() {
        return System.lineSeparator();
    }
}
