package gradebook;

import student.Student;

import java.util.Comparator;

public class ComparatorStudent implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getNume().compareTo(o2.getNume());
    }
}
