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

    public static void printf(String s, Object... args) {
        print(String.format(s, args));
    }

    public static void printfln(String s, Object... args) {
        println(String.format(s, args));
    }

    private static String lineSeparator() {
        return System.lineSeparator();
    }
}
