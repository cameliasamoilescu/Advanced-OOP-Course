package student;

import java.util.*;

public class TestStudent {
    public static void main(String[] args) {
        Set<Student> s1 = new HashSet<Student>();
        adaugaElement(s1, new Student("Ana", 10));
        adaugaElement(s1, new Student("Ana", 10));

        adaugaElement(s1, new Student("Maria", 8));
        adaugaElement(s1, new Student("Maria", 8));

        adaugaElement(s1, new Student("Ioana", 7));

        System.out.println(s1);


        ArrayList<Student> studenti = new ArrayList<Student>();
        studenti.add(new Student("Ana", 10));
        studenti.add(new Student("Maria", 8));

        for(int i = 0; i < studenti.size(); i ++){
            System.out.println(studenti.get(i).equals(studenti.get(i)));
            System.out.println(((Object) studenti.get(i)).equals(studenti.get(i)));
        }


    }

    public static void adaugaElement(Set<Student> set, Student s){
        if (set.contains(s)){
            System.out.println("Element existent");
        }
        else
            set.add(s);
    }

}
