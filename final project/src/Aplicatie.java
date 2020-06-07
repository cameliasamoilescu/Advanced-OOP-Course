import carte.*;
import persoana.Adult;
import persoana.Copil;
import persoana.Student;
import servicii.Biblioteca;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;


public class Aplicatie {

    public static void main(String[] args) throws ParseException, IOException {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.start();
        afiseazaMeniu();
        Scanner scanner = new Scanner(System.in);

        int optiune = scanner.nextInt();
        scanner.nextLine();


        Date date = new Date();

        System.out.println(date);
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
                        System.out.println("Introduceti data in format : yyyy-mm-dd");
                        String data = scanner.nextLine();
                        biblioteca.afiseazaImprumuturiDeLaData(data);
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
