package chap11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chap11.Q7.Person;

public class Q7_2 {
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
    
    //treat it as a longest-increasing-subsequence problem
    static List<Person> findHighestTower(List<Person> persons) {
        if (persons == null || persons.isEmpty()) return null;
        //sort on first attribute
        Collections.sort(persons);
        
        //then get longest increasing subsequence based on second attribute
        ArrayList<Person> list = new ArrayList<Person>();
        ArrayList<Person> maxList = new ArrayList<Person>();
        int maxSize = 0;
        list.add(persons.get(0));
        for (int i = 1; i < persons.size(); ++i) {
            if (persons.get(i).wt < persons.get(i-1).wt) {
                if(list.size() > maxSize) {
                    maxSize = list.size();
                    maxList = (ArrayList<Person>) list.clone(); //XXX: clone!
                }
                list.clear();
            }
            list.add(persons.get(i));
        }
        return maxList;
    }
    
   //-------------------------------------
    public static void main(String[]args) {
        List<Person> l = new ArrayList<Person>();
        l.add(new Person(65,100));l.add(new Person(70,150));l.add(new Person(56,90));
        l.add(new Person(75,190));l.add(new Person(60,95));l.add(new Person(68,110));
        l.add(new Person(76,10));
        System.out.println("[TOP]"+findHighestTower(l)+"[BOTTOM]");
    }

}
