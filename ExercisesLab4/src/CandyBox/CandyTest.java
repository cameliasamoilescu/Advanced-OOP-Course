package CandyBox;

import CandyBox.Heidi.Heidi;
import CandyBox.Lindt.Lindt;
import CandyBox.Milka.Milka;
import sun.swing.MenuItemLayoutHelper;

import java.util.Scanner;

public class CandyTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Precizati nr max de cutii de bomboane ce pot fi adaugate in sacosa: ");
        int nrMax = scanner.nextInt();
        scanner.close();


        CandyBag candyBag = new CandyBag(nrMax);

        adaugaCutii(candyBag);

        for(int i = 0; (i < candyBag.chocolateBox.length) && (candyBag.chocolateBox[i] != null); i++){
            System.out.println(candyBag.chocolateBox[i].toString());

        }




    }
    public static void adaugaCutii(CandyBag candyBag){
        Lindt lindt = new Lindt("cappuccino", "Irland",2,3,4);
        candyBag.adaugaChocolateBox(lindt);

        Lindt newlindt = new Lindt("cappuccino", "Irland",2,3,4);
        candyBag.adaugaChocolateBox(newlindt);

        Lindt oldlindt = new Lindt("hazelnut", "Irland",3,3,4);
        candyBag.adaugaChocolateBox(oldlindt);


        Milka milka = new Milka("oreo", "Germany", 4, 2);
        candyBag.adaugaChocolateBox(milka);

        Heidi heidi = new Heidi("coconat", "Italy", 5);
        candyBag.adaugaChocolateBox(heidi);

    }


}
