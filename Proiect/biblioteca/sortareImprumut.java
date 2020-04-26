package biblioteca;

import java.util.Comparator;

public class SortareImprumut implements Comparator<Imprumut> {
    @Override
    public int compare(Imprumut o1, Imprumut o2) {
            return o1.getDataRestituire().compareTo(o2.getDataRestituire());
        }
    }

