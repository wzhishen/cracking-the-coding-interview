package chap03;

import java.util.LinkedList;

public class Q7 /* class AnimalQueue */ {
    /*An animal shelter holds only dogs and cats, and operates on a strictly "first in,
    first out" basis. People must adopt either the "oldest" (based on arrival time) of
    all animals at the shelter, or they can select whether they would prefer a dog or
    a cat (and will receive the oldest animal of that type). They cannot select which
    specific animal they would like. Create the data structures to maintain this system
    and implement operations such as enqueue, dequeueAny, dequeueDog and
    dequeueCat.You may use the built-in LinkedList data structure.*/
    
    LinkedList<Animal> dogs = new LinkedList<Animal>();
    LinkedList<Animal> cats = new LinkedList<Animal>();
    int time = 0;
    enum Type {CAT, DOG}
    
    class Animal {
        Type type;
        String name;
        int timestamp;
        
        public Animal(Type type, String name) {
            this.type = type;
            this.name = name;
        }
        
        @Override
        public String toString() {
            return type + ": " + name;
        }
    }
    
    void enqueue(Animal a) {
        a.timestamp = ++time;
        switch (a.type) {
            case CAT: cats.add(a); break;// XXX: break!
            case DOG: dogs.add(a); break;
        }
    }
    
    Animal dequeueDog() {
        if (dogs.isEmpty()) 
            throw new IllegalStateException("No dogs!");
        return dogs.removeFirst();
    }
    
    Animal dequeueCat() {
        if (cats.isEmpty()) 
            throw new IllegalStateException("No cats!");
        return cats.removeFirst();
    }
    
    Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty())
            throw new IllegalStateException("No animals!");
        else if (dogs.isEmpty())
            return dequeueCat();
        else if (cats.isEmpty())
            return dequeueDog();
        else if (dogs.getFirst().timestamp < cats.getFirst().timestamp)
            return dequeueDog();
        else
            return dequeueCat();
    }
    
    //-------------------------------------------------
    public static void main(String[]args) {
        Q7 q = new Q7(); /* AnimalQueue */
        q.enqueue(q.new Animal(Type.CAT, "lily"));
        q.enqueue(q.new Animal(Type.DOG, "tom"));
        q.enqueue(q.new Animal(Type.DOG, "peter"));
        q.enqueue(q.new Animal(Type.CAT, "john"));
        
        System.out.println(q.dequeueAny());
        System.out.println(q.dequeueCat());
        System.out.println(q.dequeueAny());
        q.enqueue(q.new Animal(Type.DOG, "tom"));
        System.out.println(q.dequeueDog());
        System.out.println(q.dequeueAny());
    }
}
