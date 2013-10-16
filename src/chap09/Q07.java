package chap09;

public class Q07 {
//    Implement the "paint fill" function that one might see on many image editing
//    programs. That is, given a screen (represented by a two-dimensional array of
//    colors), a point, and a new color, fill in the surrounding area until the color
//    changes from the original color.
    
    void paintFill(Color[][] screen, int x, int y, Color oldColor, Color newColor) {
        if (screen == null || oldColor == null || newColor == null) return;
        if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) return;
        if (screen[y][x] == oldColor) {
            screen[y][x] = newColor;
            paintFill(screen, x - 1, y, oldColor, newColor);
            paintFill(screen, x + 1, y, oldColor, newColor);
            paintFill(screen, x, y - 1, oldColor, newColor);
            paintFill(screen, x, y + 1, oldColor, newColor);
        }
    }
    
    void paintFill(Color[][] screen, int x, int y, Color newColor) {
        paintFill(screen, x, y, screen[y][x], newColor);
    }
    
    enum Color {RED, BLUE, GREEN}

}
