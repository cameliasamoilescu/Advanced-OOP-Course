package student;

import java.util.Objects;

public class Student {
    private String nume;
    private double medie;

    public Student(String nume, double medie) {
        this.nume = nume;
        this.medie = medie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        this.medie = medie;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", medie=" + medie +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Float.compare(student.medie, medie) == 0 &&
//                Objects.equals(nume, student.nume);
//    }



    public boolean equals(Student s) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, medie);
    }
}
