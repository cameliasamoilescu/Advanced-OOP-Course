import carte.*;
import persoana.Adult;
import persoana.Copil;
import persoana.Student;
import servicii.Biblioteca;
import servicii.ServiciiAbonati;
import servicii.ServiciiCarti;
import servicii.ServiciiInput;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;


public class Aplicatie {

    public static void main(String[] args) throws ParseException, IOException {

        ServiciiInput servInput = ServiciiInput.getInstance();
        ServiciiAbonati serviciiAbonati = servInput.readAbonati();
        ServiciiCarti serviciiCarti = servInput.readCarti();

        Biblioteca biblioteca = new Biblioteca(serviciiAbonati, serviciiCarti);

        afiseazaMeniu();
        Scanner scanner = new Scanner(System.in);

        int optiune = scanner.nextInt();
        scanner.nextLine();

        Date date = new Date();
        try {
            while (optiune != 0) {
                switch (optiune) {

                    case 1:

                        afiseazaTipul("abonat");

                        int optiuneAbonat = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Introduceti numele");
                        String nume = scanner.nextLine();

                        System.out.println("Introduceti prenumele");
                        String prenume = scanner.nextLine();

                        System.out.println("Introduceti cnp");
                        String cnp = scanner.nextLine();

                        System.out.println("introduceti nr de telefon");
                        String telefon = scanner.nextLine();


                        switch (optiuneAbonat) {
                            //Adult
                            case 1: {
                                System.out.println("Indeplineste criteriul de reducere?\n 1.Da\n 2.Nu\n");
                                int crt = scanner.nextInt();

                                if (crt == 1)
                                    biblioteca.adaugaAbonat(new Adult(nume, prenume, cnp, telefon, true));
                                else
                                    biblioteca.adaugaAbonat(new Adult(nume, prenume, cnp, telefon, false));
                                break;
                            }

                            //Student
                            case 2: {
                                System.out.println("Are carnetul vizat?\n 1.Da\n 2.Nu\n");
                                int vizat = scanner.nextInt();


                                if (vizat == 1)
                                    biblioteca.adaugaAbonat(new Student(nume, prenume, cnp, telefon, true));
                                else
                                    biblioteca.adaugaAbonat(new Student(nume, prenume, cnp, telefon, false));
                                break;

                            }

                            //Copil
                            case 3: {
                                System.out.println("Introduceti varsta copilului");
                                int varsta = scanner.nextInt();
                                biblioteca.adaugaAbonat(new Copil(nume, prenume, cnp, telefon, varsta));
                                break;

                            }
                            default:
                                System.out.println("Nu ati introdus o optiune valida");
                                break;
                        }

                        break;
                    case 2:


                        afiseazaTipul("carte");

                        int optiuneCarte = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Introduceti titlul cartii");
                        String titlu = scanner.nextLine();


                        System.out.println("Introduceti autorul cartii");
                        String autor = scanner.nextLine();

                        String editura;

                        switch (optiuneCarte) {

                            //Atlas
                            case 1:

                                System.out.println("Introduceti editura: ");
                                editura = scanner.nextLine();
                                biblioteca.adaugaCarteinStoc(new Atlas(titlu, autor, editura));
                                break;

                            //Dictionar
                            case 2:

                                System.out.println("Introduceti tipul dictionarului: ");
                                String tip = scanner.nextLine();


                                System.out.println("Introduceti editura: ");
                                editura = scanner.nextLine();

                                biblioteca.adaugaCarteinStoc(new Dictionar(titlu, autor, tip, editura));

                                break;

                            //Manual
                            case 3:

                                System.out.println("Introduceti materia pentru care este manualul: ");
                                String materie = scanner.nextLine();

                                biblioteca.adaugaCarteinStoc(new Manual(titlu, autor, materie));
                                break;


                            //Roman
                            case 4:

                                System.out.println("Introduceti genul romanului ");
                                String gen = scanner.nextLine();

                                biblioteca.adaugaCarteinStoc(new Roman(titlu, autor, gen));

                                break;

                            default:
                                System.out.println("Nu ati introdus o optiune valida\n");
                                break;

                        }


                        break;

                    case 3:
                        biblioteca.afiseazaAbonatii();
                        break;

                    case 4:
                        System.out.println("Adauga id-ul cartii:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        biblioteca.scoateCartedinStoc(id);
                        break;

                    case 5:
                        System.out.println("Introduceti titlu");
                        titlu = scanner.nextLine();

                        System.out.println("Introduceti autor");
                        autor = scanner.nextLine();

                        biblioteca.cautaCarte(titlu, autor);

                        break;

                    case 6:
                        System.out.println("Adauga id-ul cartii:");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        biblioteca.cautaCarteDupaIdCarte(id);
                        break;

                    case 7:
                        biblioteca.afiseazaCartileImprumutate();
                        break;
                    case 8:
                        biblioteca.afiseazaCartilePeStoc();
                        break;

                    case 9:
                        System.out.println("Introduceti cnp-ul abonatului");
                        cnp = scanner.nextLine();

                        biblioteca.cautaAbonat(cnp);
                        break;

                    case 10:
                        System.out.println("Introduceti data in format : yyyy/mm/dd");
                        String data = scanner.nextLine();

                        biblioteca.afiseazaImprumuturiDeLaData(date);
                        break;

                    case 11:
                        System.out.println("Introduceti cnp-ul abonatului");
                        cnp = scanner.nextLine();
                        System.out.println("Introduceti id-ul cartii");
                        int idCarte = scanner.nextInt();

                        biblioteca.restituieCarte(cnp, idCarte, date);
                        break;

                    case 12:
                        System.out.println("Introduceti cnp-ul abonatului");
                        cnp = scanner.nextLine();

                        System.out.println("Introduceti titlul cartii");
                        titlu = scanner.nextLine();

                        System.out.println("Introduceti autorul cartii");
                        autor = scanner.nextLine();
                        biblioteca.imprumutaCarte(cnp, titlu, autor, date);
                        break;

                    case 13:
                        System.out.println("Introduceti cnp-ul abonatului");
                        cnp = scanner.nextLine();

                        System.out.println("Introduceti id-ul cartii");
                        idCarte = scanner.nextInt();

                        biblioteca.prelungesteTermenImprumut(cnp, idCarte, date);
                        break;


                    case 14:
                        System.out.println("Introduceti cnp-ul abonatului");
                        cnp = scanner.nextLine();

                        biblioteca.afiseazaCartileImprumutateDeAbonat(cnp);
                        break;

                    case 15:
                        biblioteca.dezaboneaza();
                        break;

                    default:
                        System.out.println("Nu ati ales o optiune existenta\n");
                        break;

                }

                afiseazaMeniu();
                optiune = scanner.nextInt();
                scanner.nextLine();
            }

        }catch (Exception e){
            System.out.println(e);
        }
        scanner.close();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//
//        //instantiem cartile pentru biblioteca
//        Roman roman = new Roman(1, "Fratii Jderi", "Mihail Sadoveanu", "istoric");
//        Roman roman2 = new Roman(2, "Razboi si pace", "Lev Tolstoi", "istoric");
//        Roman roman3 = new Roman(3, "Anna Karenina", "Lev Tolstoi", "de dragoste");
//        Roman roman4 = new Roman(4, "Fratii Jderi", "Mihail Sadoveanu", "istoric");
//
//
//        Manual manual = new Manual(200, "Geografie - Manual pentru clasa a 5-a", "Octavian Mandrut", "Geografie");
//        Manual manual2 = new Manual(7, "Lb romana - Manual ptr calasa a 5-a", "Alexandru Crisan", "Limba Romana");
//        Manual manual3 = new Manual(10, "Lb Engleza - Manual ptr calasa a 5-a", "Diana Ionita", "Limba Engleza");
//        Manual manual4 = new Manual(20, "Biologie", "Dan Cristescu", "Biologie");
//
//        Atlas atlas = new Atlas(100, "Atlas Geografic", "Prof. Marius Lungu", "Steaua Nordului");
//        Atlas atlas2 = new Atlas(101, "Atlas Geografic General", "Marius Lungu", "Arta Atlas");
//        Atlas atlas3 = new Atlas(30, "Atlasul Corpului Uman", "Profesor Peter Abrahams", "Corint");
//        Atlas atlas4 = new Atlas(35, "Enciclopedia Corpului Uman", "Inel Rosu", "Corint");
//
//
//        Dictionar dictionar = new Dictionar(105, "Dictionar Medical", "Valeriu Rusu", "medical", "Editura Medicala");
//
//        //abonatii
//        Student student1 = new Student("Ion", "Ana", "2980201331222", "0723951209", true);
//        Adult adult1 = new Adult("Ionescu", "Mihai", "1682003221002", "0758192034", false);
//        Copil copil1 = new Copil("Bujor", "Ionel", "5090303221009", "0733456212", 10);
//
//        ArrayList<Carte> carti = new ArrayList<Carte>(Arrays.asList(atlas, atlas2, manual, manual2, roman, roman2, roman3));
//        ServiciiCarti serviciiCarti = new ServiciiCarti(carti);
//        ServiciiAbonati serviciiAbonati = new ServiciiAbonati();
//
//
//
//        serviciiAbonati.adaugaAbonat(adult1);
//
//        //print "Abonat Existent"
//        serviciiAbonati.adaugaAbonat(adult1);
//
//        serviciiAbonati.adaugaAbonat(student1);
//        serviciiAbonati.adaugaAbonat(copil1);

//        //print 90
//        System.out.println("Suma totala este: " + biblioteca.sumaTotala());
//
//
//        serviciiCarti.afiseazaCartilePeStoc();
//        serviciiAbonati.afiseazaAbonatii();
//
//
//        serviciiAbonati.scoateAbonat(copil1);
//        serviciiAbonati.afiseazaAbonatii();
//
//        //print Nu exista abonat
//        serviciiAbonati.scoateAbonat(copil1);
//
//        Biblioteca biblioteca = new Biblioteca(serviciiAbonati, serviciiCarti);
//
//
//        biblioteca.imprumutaCarte("2980201331222","Atlas Geografic","Prof. Marius Lungu", date);
//
//        System.out.println("\n--------------Dupa imprumut------------\n");
//        biblioteca.afiseazaCartileImprumutateDeAbonat("2980201331222");
//        biblioteca.afiseazaImprumuturiDeLaData(date);
//
//        biblioteca.restituieCarte("2980201331222",100, new Date());
//        biblioteca.afiseazaImprumuturiDeLaData(date);
//
//
//        biblioteca.afiseazaCartileImprumutateDeAbonat("2980201331222");

//        ServiciiInput servInput = ServiciiInput.getInstance();
//        ServiciiAbonati serviciiAbonati = servInput.readAbonati();
//        serviciiAbonati.afiseazaAbonatii();
//
//        ServiciiCarti serviciiCarti = servInput.readCarti();
//        serviciiCarti.afiseazaCartilePeStoc();
//
//        ServiciiBiblioteca serviciiBiblioteca = new ServiciiBiblioteca(serviciiAbonati, serviciiCarti);
//        serviciiBiblioteca.afiseazaCartilePeStoc();
//        serviciiBiblioteca.afiseazaAbonatii();


//        biblioteca.imprumutaCarte(student1, roman, "2020-02-10");
//        biblioteca.imprumutaCarte(student1, manual, "2020-02-10");
//        biblioteca.imprumutaCarte(student1, roman3, "2020-02-10");
//        biblioteca.imprumutaCarte(student1, roman2, "2020-02-10");
//        biblioteca.imprumutaCarte(student1, roman4, "2020-02-10");
//
//        boolean adv1 = serviciiCarti.cautaCarte(atlas);
//        System.out.println(adv1);
//        biblioteca.afiseazaCartileImprumutate();

//        biblioteca.restituieCarte(student1, atlas, "2020-06-01");
//        biblioteca.restituieCarte(student1, roman2, "2020-03-01");
//        biblioteca.restituieCarte(student1, roman3, "2020-03-01");
//        biblioteca.restituieCarte(student1, roman4, "2020-04-01");
//        biblioteca.restituieCarte(student1, roman, "2020-06-01");
//
//        System.out.println("\n--------------Dupa restituiere------------\n");
//
//        biblioteca.afiseazaCartileImprumutateDeAbonat(student1);
//        biblioteca.afiseazaCartileImprumutate();
//
//
//
//        //student1 este dezabonat ptr ca are 5 abateri
//        biblioteca.dezaboneaza();
//        System.out.println("\n--------------Abnonati Dupa dezabonari------------\n");
//
//
//        //Abonatul nu are nico carte imprumutata
//        biblioteca.afiseazaCartileImprumutateDeAbonat(adult1);
//
//
//        //Nu exista abonatul cautat
//        biblioteca.afiseazaCartileImprumutateDeAbonat(student1);
//
//        biblioteca.afiseazaAbonatii();
//
//        biblioteca.adaugaCarteinStoc(dictionar);
//        biblioteca.adaugaCarteinStoc(atlas4);
//        biblioteca.afiseazaCartilePeStoc();
//
//        biblioteca.scoateCartedinStoc(atlas4);
//        biblioteca.afiseazaCartilePeStoc();
//
//
//        System.out.println("\n-------Inainte de prelungire imprumut----------\n");
//        biblioteca.adaugaAbonat(copil1);
//        biblioteca.imprumutaCarte(copil1, roman4, "2020-02-10");
//        biblioteca.afiseazaCartileImprumutateDeAbonat(copil1);
//
//
//        System.out.println("\n-------Dupa prelungire imprumut----------\n");
//
//        biblioteca.prelungesteTermenImprumut(copil1, roman4,  "2020-02-20");
//        biblioteca.afiseazaCartileImprumutateDeAbonat(copil1);
//


    }


    static void afiseazaMeniu(){
        System.out.println("\n Alegeti optiune:\n " +
                "0.Exit\n" +
                " 1. Adauga abonat\n" +
                " 2. Adauga Carte\n" +
                " 3. Afiseaza Abonatii\n" +
                " 4. Scoate carte din stoc\n" +
                " 5. Cauta carte dupa Titlu si Autor\n" +
                " 6. Cauta carte dupa id\n" +
                " 7. Afiseaza Cartile Imprumutate\n" +
                " 8. Afiseaza cartile din stoc\n" +
                " 9. Cauta Abonat\n" +
                " 10. Afiseaza imprumuturile de la data de\n" +
                " 11. Restituie Carte\n" +
                " 12. Imprumuta Carte\n" +
                " 13. Prelungeste Termen Imprumut\n" +
                " 14. Afiseaza cartile imprumutate de abonat\n" +
                " 15. Dezaboneaza\n");
    }


    static void afiseazaTipul(String s){


        switch (s) {
            case "carte":{
                System.out.println("\nAlegeti tipul cartii:\n 1. Atlas\n 2. Dictionar\n 3. Manual\n 4. Roman\n");
                break;
            }
            case "abonat":{
                System.out.println("\nAlegeti tipul abonatului:\n 1. Adult\n 2. Student\n 3. Copil");
                break;
            }
            default: break;
        }

    }


}
