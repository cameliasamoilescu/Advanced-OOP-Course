package gradebook;

import student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook(new ComparatorTreeMap());


        gradebook.add(new Student("Maria", 7.23));
        gradebook.add(new Student("Ion", 6.50));
        gradebook.add(new Student("Andrei", 10));
        gradebook.add(new Student("Miron", 9.49));
        gradebook.add(new Student("Sorina", 9.56));
        gradebook.add(new Student("Arina", 8.73));
        gradebook.add(new Student("Alina", 10));
        gradebook.add(new Student("Stefan", 9.49));


        for (Integer key: gradebook.keySet()){

            ArrayList<Student> studenti = gradebook.get(key);
            System.out.println(key + " " + studenti);

            studenti.sort(new ComparatorStudent());
            System.out.println(studenti + "\n");
            gradebook.put(key, studenti);
        }

    }

}
