import biblioteca.Biblioteca;
import carte.*;
import persoana.Adult;
import persoana.Copil;
import persoana.Student;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class main {

    public static void main(String[] args) throws ParseException {



        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String data_curenta = dateFormat.format(date);

        //instantiem cartile pentru biblioteca
        Roman roman = new Roman(1, "Fratii Jderi", "Mihail Sadoveanu", "istoric");
        Roman roman2 = new Roman(2, "Razboi si pace", "Lev Tolstoi", "istoric");
        Roman roman3 = new Roman(3, "Anna Karenina", "Lev Tolstoi", "de dragoste");
        Roman roman4 = new Roman(4, "Fratii Jderi", "Mihail Sadoveanu", "istoric");


        Manual manual = new Manual(200, "Geografie - Manual pentru clasa a 5-a", "Octavian Mandrut", "Geografie");
        Manual manual2 = new Manual(7, "Lb romana - Manual ptr calasa a 5-a", "Alexandru Crisan", "Limba Romana");
        Manual manual3 = new Manual(10, "Lb Engleza - Manual ptr calasa a 5-a", "Diana Ionita", "Limba Engleza");
        Manual manual4 = new Manual(20, "Biologie", "Dan Cristescu", "Biologie");

        Atlas atlas = new Atlas(100, "Atlas Geografic", "Prof. Marius Lungu", "Steaua Nordului");
        Atlas atlas2 = new Atlas(101, "Atlas Geografic General", "Marius Lungu", "Arta Atlas");
        Atlas atlas3 = new Atlas(30, "Atlasul Corpului Uman", "Profesor Peter Abrahams", "Corint");
        Atlas atlas4 = new Atlas(35, "Enciclopedia Corpului Uman", "Inel Rosu", "Corint");


        Dictionar dictionar = new Dictionar(105, "Dictionar Medical", "Valeriu Rusu", "medical", "Editura Medicala");

        //abonatii
        Student student1 = new Student("Ion", "Ana", "2019-02-15", "2980201331222", "0723951209", true);
        Adult adult1 = new Adult("Ionescu", "Mihai", "2018-01-11", "1682003221002", "0758192034", false);
        Copil copil1 = new Copil("Bujor", "Ionel", "2020-01-12", "5090303221009", "0733456212", 10);

        ArrayList<Carte> carti = new ArrayList<Carte>(Arrays.asList(atlas, atlas2, manual, manual2, roman, roman2, roman3));


        Biblioteca biblioteca = new Biblioteca("Centrala",carti);


        boolean adv = biblioteca.cautaCarte(atlas4);




        biblioteca.adaugaAbonat(adult1);

        //print "Abonat Existent"
        biblioteca.adaugaAbonat(adult1);

        biblioteca.adaugaAbonat(student1);
        biblioteca.adaugaAbonat(copil1);

        //print 90
        System.out.println("Suma totala este: " + biblioteca.sumaTotala());


        biblioteca.afiseaza_cartile_pe_stoc();
        biblioteca.afiseaza_abonatii();


        biblioteca.scoateAbonat(copil1);
        biblioteca.afiseaza_abonatii();

        //print Nu exista abonat
        biblioteca.scoateAbonat(copil1);

        biblioteca.imprumuta_carte(student1, atlas, "2020-02-10");
        biblioteca.imprumuta_carte(student1, roman, "2020-02-10");
        biblioteca.imprumuta_carte(student1, manual, "2020-02-10");
        biblioteca.imprumuta_carte(student1, roman3, "2020-02-10");
        biblioteca.imprumuta_carte(student1, roman2, "2020-02-10");
        biblioteca.imprumuta_carte(student1, roman4, "2020-02-10");

        boolean adv1 = biblioteca.cautaCarte(atlas);



        System.out.println("\n--------------Dupa imprumut------------\n");
        biblioteca.afiseaza_cartile_imprumutate_de_abonat(student1);
        biblioteca.afiseaza_cartile_imprumutate();



        biblioteca.restituie_carte(student1, atlas, "2020-06-01");
        biblioteca.restituie_carte(student1, roman2, "2020-03-01");
        biblioteca.restituie_carte(student1, roman3, "2020-03-01");
        biblioteca.restituie_carte(student1, roman4, "2020-04-01");
        biblioteca.restituie_carte(student1, roman, "2020-06-01");

        System.out.println("\n--------------Dupa restituiere------------\n");

        biblioteca.afiseaza_cartile_imprumutate_de_abonat(student1);
        biblioteca.afiseaza_cartile_imprumutate();



        //student1 este dezabonat ptr ca are 5 abateri
        biblioteca.dezaboneaza();
        System.out.println("\n--------------Abnonati Dupa dezabonari------------\n");


        //Abonatul nu are nico carte imprumutata
        biblioteca.afiseaza_cartile_imprumutate_de_abonat(adult1);


        //Nu exista abonatul cautat
        biblioteca.afiseaza_cartile_imprumutate_de_abonat(student1);

        biblioteca.afiseaza_abonatii();

        biblioteca.adaugaCarteinStoc(dictionar);
        biblioteca.adaugaCarteinStoc(atlas4);
        biblioteca.afiseaza_cartile_pe_stoc();

        biblioteca.scoateCartedinStoc(atlas4);
        biblioteca.afiseaza_cartile_pe_stoc();


        System.out.println("\n-------Inainte de prelungire imprumut----------\n");
        biblioteca.adaugaAbonat(copil1);
        biblioteca.imprumuta_carte(copil1, roman4, "2020-02-10");
        biblioteca.afiseaza_cartile_imprumutate_de_abonat(copil1);


        System.out.println("\n-------Dupa prelungire imprumut----------\n");

        biblioteca.prelungeste_termen_imprumut(copil1, roman4,  "2020-02-20");
        biblioteca.afiseaza_cartile_imprumutate_de_abonat(copil1);






    }
}
