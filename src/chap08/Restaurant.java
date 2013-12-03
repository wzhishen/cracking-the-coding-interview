package chap08;

public class Restaurant {
    private static Restaurant _instance = null;
    
    private Restaurant() { }
    
    public static Restaurant getlnstance() {
        if (_instance == null) {
            _instance = new Restaurant();
        }
        return _instance;
    }
    
    public void serve() {}
    public void open() {}
    public boolean isOpen() {return false;}
}