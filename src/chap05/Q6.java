package chap05;

import static helpers.Printer.*;
import static helpers.Bit.*;

/**
 * Write a program to swap odd and even bits in an integer with
 * as few instructions as possible (e.g., bit 0 and bit 1 are
 * swapped, bit 2 and bit 3 are swapped, and so on).
 */
public class Q6 {
    public static int swapOddEvenBits(int n) {
        // Key: 
        // 0xAAAAAAAA -> mask: 10101010...
        // 0x55555555 -> mask: 01010101...
        // for 32-bit integers
        return ((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String bitString = "01001011";
        int bits = toInt(bitString);
        println(bitString);
        println("swapOddEvenBits: " + toBitString(swapOddEvenBits(bits)));
    }
}
