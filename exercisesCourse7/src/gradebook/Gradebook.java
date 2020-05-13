package gradebook;

import student.Student;

import java.util.*;

public class Gradebook extends TreeMap<Integer, ArrayList<Student>>{


    public Gradebook(Comparator<? super Integer> comparator) {
        super(comparator);
    }

    public void add(Student student){

        Integer medie = (int) Math.round(student.getMedie());
        if( medie > 0 && medie <= 10) {
            if (this.containsKey(medie)) {
                ArrayList<Student> studenti = this.get(medie);
                studenti.add(student);
                this.put(medie, studenti);
            } else
            {
                ArrayList<Student> studenti = new ArrayList<Student> (Arrays.asList(student));
                this.put(medie, studenti);
            }
        }


    }
}
