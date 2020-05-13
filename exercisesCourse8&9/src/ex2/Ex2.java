package ex2;

import javax.rmi.CORBA.StubDelegate;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        List<Persoana> persoane =Arrays.asList(new Persoana("Mihai", "Arina", 10),
                                                new Persoana("Ionescu", "Ion", 12),
                                                new Persoana("Anton", "Ana", 15));

        afisare(persoane);
        sortare(persoane);
        afisareDupaPrimaLitera(persoane, "m");
        afisDupaVarsta(persoane);
        afisCelMaiTanar(persoane);
    }


    public static void afisare(List<Persoana> persoane){
        System.out.println("Afisare persoane");
        persoane.stream().forEach(System.out::println);
        System.out.println();
    }

    public static void sortare(List<Persoana> persoane){
        System.out.println("Afisare persoane sortate dupa prenume:");
        persoane.stream().sorted(new Comparator<Persoana>() {
            @Override
            public int compare(Persoana o1, Persoana o2) {
                return o1.getPrenume().compareTo(o2.getPrenume());
            }
        }).forEach(System.out::println);
        System.out.println();
    }

    public static void afisareDupaPrimaLitera(List<Persoana> persoane, String l){
        System.out.println("Afisare persoane al caror nume incepe cu litera " + l);
        persoane.stream().filter(i -> i.getNume().toLowerCase().startsWith(l)).forEach(System.out::println);
        System.out.println();
    }

    public static void afisDupaVarsta(List<Persoana> persoane){
        System.out.println("Afisare persoane sortate descrescator dupa varsta:");
        persoane.stream().sorted(new Comparator<Persoana>() {
            @Override
            public int compare(Persoana o1, Persoana o2) {
                return o2.getVarsta() - o1.getVarsta();
            }
        }).forEach(System.out::println);
        System.out.println();
    }

    public static void afisCelMaiTanar(List<Persoana> persoane){

        System.out.println("Afisare cea mai tanara persoana");
        System.out.println(persoane.stream().min(new Comparator<Persoana>() {
            @Override
            public int compare(Persoana o1, Persoana o2) {
                return o1.getVarsta() - o2.getVarsta();
            }
        }).get());
    }


}
