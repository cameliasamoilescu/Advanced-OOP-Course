package biblioteca;

import biblioteca.Imprumut;

import java.util.Comparator;

public class sortareImprumut implements Comparator<Imprumut> {
    @Override
    public int compare(Imprumut o1, Imprumut o2) {
            return o1.getData_restituire().compareTo(o2.getData_restituire());
        }
    }

