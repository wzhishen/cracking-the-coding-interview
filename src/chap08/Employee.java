package chap08;

public abstract class Employee {
    protected String name;
    protected boolean sex;
    protected int phone;
    protected String address;
    protected boolean isAvailable = true;
    
    Employee(String name, boolean male) {
        this.name = name;
        sex = male;
    }
//    protected Type type;
//    enum Type {Director, Manager, Responder}
}
