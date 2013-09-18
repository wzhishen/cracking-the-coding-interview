package chap05;

public class Q8 {
//    A monochrome screen is stored as a single array of bytes, allowing eight consecutive
//    pixels to be stored in one byte.The screen has width w, where w is divisible
//    by 8 (that is, no byte will be split across rows).The height of the screen, of course,
//    can be derived from the length of the array and the width. Implement a function
//    drawHorizontall_ine(byte[] screen, int width, int xl, int x2,
//    int y) which draws a horizontal line from (xl, y)to(x2, y).
    
    void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int startOffset = x1 % 8;
        int firstByte = startOffset == 0 ? x1/8 : x1/8 + 1;
        int endOffset = (x2+1) % 8;
        int lastByte = endOffset == 0 ? x2/8 : x2/8 - 1;
        
        // draw line for full bytes
        for (int i = firstByte; i <= lastByte; ++i) {
            screen[i + width/8*y] = (byte) 0xFF;
        }
        
        // draw start/end of line
        if (x1/8 == x2/8) {
            byte mask = (byte) (0xFF >> startOffset);
            mask &= (0xFF << 8-endOffset);
            screen[firstByte - 1 + width/8*y] |= mask;
        }
        else {
            if (startOffset != 0) {
                screen[firstByte - 1 + width/8*y] |= (byte)(0xFF >> startOffset);
            }
            if (endOffset != 0) {
                screen[lastByte + 1 + width/8*y] |= (byte)(0xFF << 8-endOffset);
            }
        }
    }

}
