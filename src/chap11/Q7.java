package chap11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q7 {
    /*A circus is designing a tower routine consisting of people standing atop one
    another's shoulders. For practical and aesthetic reasons, each person must be
    both shorter and lighter than the person below him or her. Given the heights
    and weights of each person in the circus, write a method to compute the largest
    possible number of people in such a tower.
    EXAMPLE:
    Input (ht,wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95)
    (68, 110)
    Output:The longest tower is length 6 and includes from top to bottom:
    (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
    */
    
    //treat it as a box-stacking problem
    static List<Person> findHighestTower(List<Person> persons, Person bottom) {
        if (persons == null || persons.isEmpty()) return null;
        int maxNum = 0;
        List<Person> maxList = new ArrayList<Person>();
        for (Person p : persons) {
            if (p.canStandAbove(bottom)) {
                List<Person> retList = findHighestTower(persons, p);
                if (retList.size() > maxNum) {
                    maxNum = retList.size();
                    maxList = retList;
                }
            }
        }
        if (bottom != null) 
            maxList.add(0, bottom);
        return maxList;
    }
    
    static List<Person> findHighestTowerDP(List<Person> persons, Person bottom, 
            HashMap<Person, List<Person>> cache) {
        if (persons == null || persons.isEmpty()) return null;
        if (cache.containsKey(bottom))
            return cache.get(bottom);
        int maxNum = 0;
        List<Person> maxList = new ArrayList<Person>();
        for (Person p : persons) {
            if (p.canStandAbove(bottom)) {
                List<Person> retList = findHighestTowerDP(persons, p, cache);
                if (retList.size() > maxNum) {
                    maxNum = retList.size();
                    maxList = retList;
                }
            }
        }
        if (bottom != null) 
            maxList.add(0, bottom);
        cache.put(bottom, maxList);
        return maxList;
    }
    
    //-------------------------------------
    public static void main(String[]args) {
        List<Person> l = new ArrayList<Person>();
        l.add(new Person(65,100));l.add(new Person(70,150));l.add(new Person(56,90));
        l.add(new Person(75,190));l.add(new Person(60,95));l.add(new Person(68,110));
        System.out.println("[BOTTOM]"+findHighestTower(l, null)+"[TOP]");
        System.out.println("[BOTTOM]"+findHighestTowerDP(l, null, new HashMap<Person, List<Person>>())+"[TOP]");
    }
    
    static class Person implements Comparable<Object> {
        int ht; int wt;
        public Person(int h, int w) {ht=h;wt=w;}
        private boolean canStandAbove(Person that) {
            return that == null ||
                    (this.ht < that.ht &&
                    this.wt < that.wt);
        }
        @Override
        public String toString() {return "("+ht+", "+wt+")";}
        @Override
        public int compareTo(Object o) {
            Person that = (Person) o;
            return this.ht != that.ht ? 
                    ((Integer)this.ht).compareTo(that.ht) :
                    ((Integer)this.wt).compareTo(that.wt);
        }
    }
    
}
