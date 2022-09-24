

import java.util.ArrayList;
import java.util.Iterator;

public class Flight implements Comparable {

    private final ArrayList<Trick> flight = new ArrayList<>();
    final private String name;

    @Override
    public String toString(){
        return this.name;
    }

    /**
     * constructor
     * @param name name of this flight
     */
    public Flight(String name) {

        this.name = name;
    }

    /**
     * getter with encapsulation
     * @return shallow copy list of tricks
     */
    public ArrayList<Trick> getFlight() {
        return new ArrayList<>(flight);
    }

    public void addTrick(Trick t){flight.add(t);}

    public int uniqueMove(){
        int unique = 0;
        ArrayList<Direction> uniqueDirections = new ArrayList<>();
        for (Trick t: getFlight()){
            Iterator<Direction> d = t.getDirections();
            while(d.hasNext()){
                Direction element = d.next();
                if (uniqueDirections.contains(element)){
                    continue;
                }else{
                    unique++;
                    uniqueDirections.add(element);
                }
            }
        }
        return unique;
    }

    public void runFlight(){
        System.out.println("Executing flight '" + this.name + "'...");
        for (Trick t: getFlight()){
            t.execute();
            }



    }


    @Override
    public int compareTo( Object o) {
        return 0;
    }

    
}
