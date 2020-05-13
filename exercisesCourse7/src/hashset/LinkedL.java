package hashset;


import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class LinkedL extends LinkedList<Integer> {
    Integer nr_adaugate;

    public LinkedL() {
        this.nr_adaugate = 0;
    }

    public Integer getNr_adaugate() {
        return nr_adaugate;
    }

    public void setNr_adaugate(Integer nr_adaugate) {
        this.nr_adaugate = nr_adaugate;
    }

    @Override
    public boolean add(Integer integer) {
        this.nr_adaugate += 1;
        return super.add(integer);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        this.nr_adaugate += c.size();
        return super.addAll(c);
    }
}
