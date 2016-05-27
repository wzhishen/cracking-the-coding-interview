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

    public static void printArray(int[] a) {
        if (a == null) {
            print(null);
        } else {
            for(int n : a) print(n + " ");
        }
        println();
    }

    public static void printArray(char[] a) {
        if (a == null) {
            print(null);
        } else {
            for(char n : a) print(n + " ");
        }
        println();
    }

    public static void printArray(String[] a) {
        if (a == null) {
            print(null);
        } else {
            for(String n : a) print(n + " ");
        }
        println();
    }

    public static void printArray(int[][] a) {
        for (int[] row : a) {
            for (int col : row) {
                print(col + " ");
            }
            println();
        }
    }

    private static String lineSeparator() {
        return System.lineSeparator();
    }
}
