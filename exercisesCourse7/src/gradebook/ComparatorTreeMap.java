package gradebook;

import java.util.Comparator;

public class ComparatorTreeMap implements Comparator<Integer> {

    @Override

    public int compare(Integer o1, Integer o2) {
        return (o2 - o1);
        }
}
