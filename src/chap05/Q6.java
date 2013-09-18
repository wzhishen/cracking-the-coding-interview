package chap05;

public class Q6 {
//    Write a program to swap odd and even bits in an integer with as few instructions
//    as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and
//    so on).
    
    int swapOddEvenBits(int n) {
        //XXX: 
        //0xAAAAAAAA -> mask: 10101010...
        //0x55555555 -> mask: 01010101...
        // for 32-bit integers
        return ((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1);
    }

}
