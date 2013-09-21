package chap08;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static Restaurant _instance = null;
    public static Restaurant getlnstance() {
        if (_instance == null) {
            _instance = new Restaurant();
        }
        return _instance;
    }
    
    public static void main(String[]args) {
        Restaurant r = new Restaurant();
    }
}