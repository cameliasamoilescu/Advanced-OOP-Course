package hashset;

import java.util.Collection;
import java.util.HashSet;

public class HashS extends HashSet<Integer> {
    Integer nr_adaugate;

    public HashS() {
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
        System.out.println(this.nr_adaugate);
//        this.nr_adaugate += c.size();
        System.out.println(this.nr_adaugate);

        return super.addAll(c);
    }
}
