package biblioteca;

import persoana.Abonat;

import java.util.Comparator;

public class sortareAbonati implements Comparator<Abonat> {
    @Override
    public int compare(Abonat o1, Abonat o2) {

        if(o1.getNume().compareTo(o2.getNume()) == 0)
            return o1.getPrenume().compareTo(o2.getPrenume());

        return o1.getNume().compareTo(o2.getNume());


    }
}
