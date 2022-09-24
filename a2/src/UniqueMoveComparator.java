import java.util.Comparator;

public class UniqueMoveComparator implements Comparator<Flight> {
    /**
     * compare two flights by their number of unique movements in ascending order
     * @param o1 first flight
     * @param o2 second flight
     * @return 0 if same, negative if o1 before o2, positive if o1 after o2.
     */
    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.uniqueMove() - o2.uniqueMove();
    }
}
