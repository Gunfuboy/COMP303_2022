import java.util.Comparator;

public class TricksNumberComparator implements Comparator<Flight> {

    /**
     * Compare two flights by their number of tricks, in ascending order
     * @param o1 first flight
     * @param o2 second flight
     * @return 0 if same amount of tricks, negative if o1 before o2, positive if o1 after o2
     */
    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.getFlight().size() - o2.getFlight().size();
    }
}
