package chap08;

public class Responder extends Employee{
    private int responderId;
    public Responder(String name, boolean male) {
        super(name, male);
    }
    
    public static void main(String[]args) {
        Responder r = new Responder("peter",true);
    }
}
