package polymorphism.zoo;

import polymorphism.zoo.carnivor.Leu;
import polymorphism.zoo.carnivor.Pisica;
import polymorphism.zoo.ierbivor.Cal;
import polymorphism.zoo.ierbivor.Elefant;
import polymorphism.zoo.omnivor.Caine;
import polymorphism.zoo.omnivor.Urs;

import java.util.Scanner;

/**
 *
 * java.lang - importat default
 */
public class ZooTest {
    public static void main(String[] args) {

        //Integer nrAnimaleZoo = Integer.valueOf(args[0]);
        int nrAnimaleZoo = Integer.parseInt(args[0]);
        System.out.println(nrAnimaleZoo);

        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Precizati nr max de animale ce pot fi gazduite la zoo:");
        //int nrAnimaleZoo = scanner.nextInt();
        //scanner.close();

        Zoo zooBucuresti = new Zoo(nrAnimaleZoo);
        adaugaAnimalLaZoo(zooBucuresti);


        for (int i = 0; (i < zooBucuresti.animaleZoo.length) && (zooBucuresti.animaleZoo[i] != null); i++) {
            Animal animal = zooBucuresti.animaleZoo[i];
            animal.afiseazaDetalii();
            animal.seHraneste();
            animal.scoateSunet();
        }


        Pisica cat = new Pisica("Thomas", 7);
        System.out.println(cat);

        Pisica newCat = new Pisica("Thomas", 7);
        System.out.println(cat == newCat);
        System.out.println(cat.equals(newCat));

    }

    public static void adaugaAnimalLaZoo(Zoo zoo){



        Leu leu = new Leu("Simba", 7);
        zoo.adaugaAnimal(leu);

        Elefant elefant = new Elefant("Eli", 10);
        zoo.adaugaAnimal(elefant);

        Urs urs = new Urs("Fram", 4);
        zoo.adaugaAnimal(urs);

        Pisica pisica = new Pisica("Tom", 2);
        zoo.adaugaAnimal(pisica);

        Caine caine = new Caine("Toto", 3);
        zoo.adaugaAnimal(caine);

        Cal cal = new Cal("Thunder", 3);
        zoo.adaugaAnimal(cal);

    }
}
