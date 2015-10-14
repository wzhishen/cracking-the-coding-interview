package helpers;

public class Bit {
    public static String toBitString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % 2);
            n /= 2;
        }
        return sb.toString();
    }

    public static int toInt(String bitString) {
        int n = 0, base = 1;
        char[] bits = bitString.toCharArray();
        for (int i = bits.length - 1; i >=0; --i) {
            int bitChar = bits[i];
            if (bitChar != '0' && bitChar != '1')
                throw new IllegalArgumentException("Invalid bit string!");
            n += (bitChar - 48) * base;
            base *= 2;
        }
        return n;
    }
}
