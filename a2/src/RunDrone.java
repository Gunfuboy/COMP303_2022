import java.util.ArrayList;

public class RunDrone {
    //NOTE: I have implemented a series of tests to test out the feature of my program. Please comment out these tests
    //if it is unnecessary for grading.
    public static void main(String[] args) {
        // TODO: illustrate your implementations here
        Flight f1 = new Flight("Flight 1");
        Flight f2 = new Flight("Flight 2");
        Flight f3 = new Flight("Flight 3");

        Trick takeOff = new Trick(Tricks.TakeOff);
        Trick land = new Trick(Tricks.Land);
        Trick pucker = new Trick(Tricks.Pucker);

        f1.addTrick(takeOff);
        f2.addTrick(pucker);
        f3.addTrick(takeOff); f3.addTrick(pucker); f3.addTrick(land);

        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(f3); flights.add(f2); flights.add(f1);

        System.out.println("Current flight list is:\n" + flights);

        flights.sort(new UniqueMoveComparator());
        System.out.println("Sorted by number of unique move flight list is:\n" + flights); //1,3,2

        flights.sort(new TricksNumberComparator());
        System.out.println("Sorted by number of tricks flight list is:\n" + flights); //1,2,3





        /* ================================== TESTS ================================================ */
        Drone d = new Drone("Test Drone");


        Flight f = new Flight("Test Flight");

        System.out.println("Our drone name is "+ d.getName());

        System.out.println("===============TEST 1 : REGULAR RUN================");
        d.setMovement(Direction.FORWARD, 1.0, Speed.HIGH);
        d.execute();

        System.out.println("===============TEST 2 : REGULAR RUN + RECORD================");
        d.setMovement(Direction.UP, 10.5, Speed.MODERATE);
        d.record(Format.AVI);
        d.execute();

        System.out.println("===============TEST 3 : OVERRIDE MOVEMENTS================");
        d.setMovement(Direction.UP, 10.5, Speed.MODERATE);
        d.getInfo();
        d.setMovement(Direction.DOWN,5.0, Speed.HIGH);
        d.record(Format.FLV);
        d.getInfo();
        d.execute();

        System.out.println("===============TEST 4 : ERROR - EXECUTE WITH NO SET MOVEMENT================");
        d.getInfo();
        d.execute();
        d.record(Format.AVI);
        d.getInfo();

        System.out.println("===============TEST 5 : DO A TRICK================");
        d.doTrick(takeOff,false);
        d.doTrick(pucker,false);
        d.doTrick(land,false);

        System.out.println("===============TEST 6 : FLIGHTS================");

        f.addTrick(takeOff);
        f.addTrick(land);
        f.addTrick(pucker);
        System.out.println(f.uniqueMove());
//        d.runFlight(f);
        /* ================================== TESTS ================================================ */

    }
}
